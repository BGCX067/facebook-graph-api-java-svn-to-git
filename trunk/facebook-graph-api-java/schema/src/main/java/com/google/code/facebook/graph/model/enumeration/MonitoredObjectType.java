/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

import com.google.code.facebook.graph.model.Entity;
import com.google.code.facebook.graph.model.User;

/**
 * The Enum MonitoredObjectType.
 */
public enum MonitoredObjectType implements ValueEnum, TypeEnum {
	
//	PERMISSION("permissions", User.class),
//	ERROR("errors", User.class),
	/** The USER. */
USER("user", User.class);

    /** The Constant stringToEnum. */
	private static final Map<String, MonitoredObjectType> stringToEnum = new HashMap<String, MonitoredObjectType>();

	static { // Initialize map from constant name to enum constant
		for (MonitoredObjectType op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /** The type. */
    private final Class<? extends Entity<?, ?>> type;
    
    /**
     * Instantiates a new monitored object type.
     * 
     * @param value the value
     * @param type the type
     */
    MonitoredObjectType(String value, Class<? extends Entity<?, ?>> type) {
        this.value = value;
        this.type = type;
    }

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.enumeration.ValueEnum#value()
	 */
	@Override
	public String value() {
		return value;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.enumeration.TypeEnum#type()
	 */
	public Class<? extends Entity<?, ?>> type() {
		return type;
	}
	
	/**
	 * From value.
	 * 
	 * @param value the value
	 * 
	 * @return the monitored object type
	 */
	public static MonitoredObjectType fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
