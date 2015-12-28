/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;

import com.google.code.facebook.graph.model.GraphNode;
import com.google.code.facebook.graph.model.adapter.Adapter;
import com.google.code.facebook.graph.model.adapter.Converter;
import com.google.code.facebook.graph.model.enumeration.Gender;
import com.google.code.facebook.graph.model.enumeration.ObjectType;
import com.google.code.facebook.graph.model.enumeration.Period;
import com.google.code.facebook.graph.model.enumeration.Privacy;

/**
 * The Class BaseJsonAdapter.
 */
public abstract class BaseJsonAdapter implements Adapter<JSONObject> {
	
	/** The Constant DATE_FORMAT. */
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");

	/** The descriptors cache. */
	private static Map<Class<?>, PropertyDescriptor[]> descriptorsCache = new HashMap<Class<?>, PropertyDescriptor[]>();
	
	/** The logger. */
    protected final Logger logger = Logger.getLogger(getClass().getCanonicalName());
	
	/** The converters. */
	protected Map<Class<?>, Converter<?, ?>> converters = new HashMap<Class<?>, Converter<? , ?>>();

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 250056223059654638L;
	
	{
		converters.put(Date.class, new Converter<String, Date>() {
			@Override
			public Date convert(String source) {
				try {
					return DATE_FORMAT.parse(source);
				} catch (Exception e) {
					return null;
				}
			}
		});
		
//		converters.put(Integer.class, new Converter<String, Integer>() {
//			@Override
//			public Integer convert(String source) {
//				try {
//					return Integer.parseInt(source);
//				} catch (Exception e) {
//					return null;
//				}
//			}
//		});
		
		converters.put(int.class, new Converter<Long, Integer>() {
			@Override
			public Integer convert(Long source) {
				try {
					return Integer.valueOf(source.intValue());
				} catch (Exception e) {
					return null;
				}
			}
		});
		
		converters.put(String.class, new Converter<Object, String>() {
			@Override
			public String convert(Object source) {
				return String.valueOf(source);
			}
		});
		
		converters.put(Privacy.class, new Converter<String, Privacy>() {
			@Override
			public Privacy convert(String source) {
				return Privacy.fromValue(source);
			}
		});
		converters.put(ObjectType.class, new Converter<String, ObjectType>() {
			@Override
			public ObjectType convert(String source) {
				return ObjectType.fromValue(source);
			}
		});
		converters.put(Period.class, new Converter<String, Period>() {
			@Override
			public Period convert(String source) {
				return Period.fromValue(source);
			}
		});
		converters.put(Gender.class, new Converter<String, Gender>() {
			@Override
			public Gender convert(String source) {
				return Gender.fromValue(source);
			}
		});
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.Adapter#adaptFrom(java.lang.Object)
	 */
	@Override
	public void adaptFrom(JSONObject adaptee) {
		copyProperties(this, adaptee);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.Adapter#adaptTo()
	 */
	@Override
	public JSONObject adaptTo() {
		JSONObject object = new JSONObject();
		copyProperties(object, this);
		return object;
	}

	/**
	 * Copy properties.
	 * 
	 * @param dest the dest
	 * @param src the src
	 */
	@SuppressWarnings("unchecked")
	protected void copyProperties(Object dest, JSONObject src) {
		try {
			for (Map.Entry<String, Object> entry : (Iterable<Map.Entry<String, Object>>) src.entrySet()) {
				PropertyDescriptor descriptor = getPropertyDescriptor(dest, convertToCamelCase(entry.getKey()));
				Object value = entry.getValue();
				if (descriptor != null && descriptor.getWriteMethod() != null) {
					if (includeProperty(descriptor.getName(), value)) {
						if (value != null && converters.containsKey(descriptor.getPropertyType())) {
							value = ((Converter<Object, Object>) converters.get(descriptor.getPropertyType())).convert(value);
							if (value == null) {
								logger.warning("Could not convert property '" + entry.getKey() + "' with value:" + entry.getValue());
							}
						}
						try {
							descriptor.getWriteMethod().invoke(dest, value);
						} catch (Exception e) {
							logger.log(Level.SEVERE, "Error while setting property '" + descriptor.getName() + "' on:" + dest.getClass(), e);
						}
					}
				} else {
					logger.warning("Additional property '" + entry.getKey() + "' with value '" + entry.getValue() + "' found in response for object." + dest.getClass());
				}
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error while setting properties.", e);
		}
	}

	/**
	 * Copy properties.
	 * 
	 * @param dest the dest
	 * @param src the src
	 */
	@SuppressWarnings("unchecked")
	protected void copyProperties(JSONObject dest, Object src) {
		try {
			PropertyDescriptor[] descriptors = getPropertyDescriptors(src.getClass());
			for (PropertyDescriptor descriptor : descriptors) {
				if (!descriptor.getName().equals("class") && descriptor.getReadMethod() != null) {
					Object value = descriptor.getReadMethod().invoke(src);
					if (includeProperty(descriptor.getName(), value)) {
						dest.put(convertToUnderscores(descriptor.getName()), value);
					}
				}
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error while setting properties.", e);
		}
	}

	/**
	 * Convert to camel case.
	 * 
	 * @param original the original
	 * 
	 * @return the string
	 */
	protected String convertToCamelCase(String original) {
		StringBuilder builder = new StringBuilder();
		boolean upperCase = false;
		for (int i = 0; i < original.length(); i++) {
			if (original.charAt(i) == '_') {
				upperCase = true;
			} else {
				if (upperCase) {
					builder.append(Character.toUpperCase(original.charAt(i)));
					upperCase = false;
				} else {
					builder.append(original.charAt(i));
				}
			}
		}

		return builder.toString();
	}

	/**
	 * Convert to underscores.
	 * 
	 * @param original the original
	 * 
	 * @return the string
	 */
	protected String convertToUnderscores(String original) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < original.length(); i++) {
			if (Character.isUpperCase(original.charAt(i))) {
				builder.append('_');
				builder.append(Character.toLowerCase(original.charAt(i)));
			} else {
				builder.append(original.charAt(i));
			}
		}

		return builder.toString();
	}

	/*
	 * Stolen liberally from commons-beanutils.
	 */
	/**
	 * Gets the property descriptors.
	 * 
	 * @param beanClass the bean class
	 * 
	 * @return the property descriptors
	 */
	public PropertyDescriptor[] getPropertyDescriptors(Class<?> beanClass) {

		if (beanClass == null) {
			throw new IllegalArgumentException("No bean class specified");
		}

		// Look up any cached descriptors for this bean class
		PropertyDescriptor[] descriptors = null;
		descriptors = (PropertyDescriptor[]) descriptorsCache.get(beanClass);
		if (descriptors != null) {
			return (descriptors);
		}

		// Introspect the bean and cache the generated descriptors
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(beanClass);
		} catch (IntrospectionException e) {
			return (new PropertyDescriptor[0]);
		}
		descriptors = beanInfo.getPropertyDescriptors();
		if (descriptors == null) {
			descriptors = new PropertyDescriptor[0];
		}

		descriptorsCache.put(beanClass, descriptors);
		return (descriptors);
	}

	/*
	 * Stolen liberally from commons-beanutils.
	 */
	/**
	 * Gets the property descriptor.
	 * 
	 * @param bean the bean
	 * @param name the name
	 * 
	 * @return the property descriptor
	 * 
	 * @throws IllegalAccessException the illegal access exception
	 * @throws InvocationTargetException the invocation target exception
	 * @throws NoSuchMethodException the no such method exception
	 */
	public PropertyDescriptor getPropertyDescriptor(Object bean, String name)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {

		if (bean == null) {
			throw new IllegalArgumentException("No bean specified");
		}
		if (name == null) {
			throw new IllegalArgumentException(
					"No name specified for bean class '" + bean.getClass()
							+ "'");
		}

		// Resolve nested references
		PropertyDescriptor[] descriptors = getPropertyDescriptors(bean
				.getClass());
		if (descriptors != null) {
			for (int i = 0; i < descriptors.length; i++) {
				if (name.equals(descriptors[i].getName())) {
					return (descriptors[i]);
				}
			}
		}

		return null;
	}
	
	/**
	 * Include property.
	 * 
	 * @param name the name
	 * @param value the value
	 * 
	 * @return true, if successful
	 */
	protected boolean includeProperty(String name, Object value) {
		if (value != null) {
			return value.getClass().equals(String.class)
					|| value.getClass().isPrimitive()
					|| value.getClass().isEnum()
					|| Number.class.isAssignableFrom(value.getClass());
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	protected <T extends GraphNode<?, ?>> Map<String, T> getEntityLinks() {
		Map<String, T> entityLinks = new HashMap<String, T>();
		PropertyDescriptor[] descriptors = getPropertyDescriptors(getClass());
		for (PropertyDescriptor descriptor : descriptors) {
			if (!descriptor.getName().equals("class") 
					&& descriptor.getReadMethod() != null
					&& GraphNode.class.isAssignableFrom(descriptor.getPropertyType())) {
				try {
					Object value = descriptor.getReadMethod().invoke(this);
					if (value != null) {
						entityLinks.put(descriptor.getName(), (T) value);				
					}
				} catch (Exception e) {
					logger.warning("Could not read property '" + descriptor.getName() + "':");
				}
			}
		}
		return entityLinks;
	}
}
