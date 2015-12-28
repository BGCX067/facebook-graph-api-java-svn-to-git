/*
 * 
 */
package com.google.code.facebook.graph.client;

import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.code.facebook.graph.client.constant.FacebookGraphApiUrls;
import com.google.code.facebook.graph.client.constant.ParameterNames;
import com.google.code.facebook.graph.client.constant.FacebookGraphApiUrls.FacebookGraphApiUrlBuilder;
import com.google.code.facebook.graph.common.ActiveRecord;
import com.google.code.facebook.graph.common.FacebookGraphAccessObject;
import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.Entity;
import com.google.code.facebook.graph.model.enumeration.ConnectionEnum;
import com.google.code.facebook.graph.model.enumeration.FieldEnum;
import com.google.code.facebook.graph.model.enumeration.ObjectType;

/**
 * The Class BaseFacebookGraphAccessObject.
 */
public abstract class BaseFacebookGraphAccessObject extends FacebookGraphApiGateway implements FacebookGraphAccessObject {
	
    /**
     * Instantiates a new base facebook graph access object.
     */
    protected BaseFacebookGraphAccessObject() {
        // by default we compress contents
        requestHeaders.put("Accept-Encoding", "gzip, deflate");
    }
    
    /**
     * Creates the facebook graph api url builder.
     * 
     * @param methodName the method name
     * 
     * @return the facebook graph api url builder
     */
    protected abstract FacebookGraphApiUrlBuilder createFacebookGraphApiUrlBuilder(String methodName);
    
	/**
	 * Read response.
	 * 
	 * @param clazz the clazz
	 * @param is the is
	 * 
	 * @return the t
	 */
	protected <T> T readResponse(Class<T> clazz, InputStream is) {
		try {
			return unmarshallObject(clazz, is);
		} finally {
			closeStream(is);
		}
	}

	/**
	 * Read map response.
	 * 
	 * @param clazz the clazz
	 * @param is the is
	 * 
	 * @return the map< string, t>
	 */
	protected <T> Map<String, T> readMapResponse(Class<T> clazz, InputStream is) {
		try {
			return unmarshallMap(clazz, is);
		} finally {
			closeStream(is);
		}
	}

	/**
	 * Read list response.
	 * 
	 * @param clazz the clazz
	 * @param is the is
	 * 
	 * @return the list< t>
	 */
	protected <T> PagedList<T> readListResponse(Class<T> clazz, InputStream is) {
		try {
			return unmarshallList(clazz, is);
		} finally {
			closeStream(is);
		}
	}
	
	/**
	 * Unmarshall object.
	 * 
	 * @param clazz the clazz
	 * @param is the is
	 * 
	 * @return the t
	 */
	protected abstract <T> T unmarshallObject(Class<T> clazz, InputStream is);

	/**
	 * Unmarshall map.
	 * 
	 * @param clazz the clazz
	 * @param is the is
	 * 
	 * @return the map< string, t>
	 */
	protected abstract <T> Map<String, T> unmarshallMap(Class<T> clazz, InputStream is);

	/**
	 * Unmarshall list.
	 * 
	 * @param clazz the clazz
	 * @param is the is
	 * 
	 * @return the list< t>
	 */
	protected abstract <T> PagedList<T> unmarshallList(Class<T> clazz, InputStream is);
	
	/**
	 * Marshall object.
	 * 
	 * @param element the element
	 * 
	 * @return the string
	 */
	protected abstract String marshallObject(Object element);
    
    /**
     * Checks if is null or empty.
     * 
     * @param s the s
     * 
     * @return true, if is null or empty
     */
    protected boolean isNullOrEmpty(String s) {
        return ((s == null) || (s.length() == 0));
    }

    /**
     * Assert not null or empty.
     * 
     * @param name the name
     * @param value the value
     */
    protected void assertNotNullOrEmpty(String name, String value) {
        if (isNullOrEmpty(value)) {
            throw new IllegalArgumentException(name + " cannot be null or empty.");
        }
    }

    /**
     * Assert not null or empty.
     * 
     * @param name the name
     * @param value the value
     */
    protected void assertNotNullOrEmpty(String name, Collection<?> value) {
        if ((value == null) || value.isEmpty()) {
            throw new IllegalArgumentException(name + " cannot be null or empty.");
        }
    }

    /**
     * Assert positive number.
     * 
     * @param name the name
     * @param value the value
     */
    protected void assertPositiveNumber(String name, int value) {
        if (value < 0) {
            throw new IllegalArgumentException(name + " cannot be less than zero.");
        }
    }

    /**
     * Assert not null.
     * 
     * @param name the name
     * @param value the value
     */
    protected void assertNotNull(String name, Object value) {
        if (value == null) {
            throw new IllegalArgumentException(name + " cannot be null.");
        }
    }
    
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphAccessObject#get(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Entity<?, ?>> T get(String id) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_OBJECT_URL);
		builder.withId(id).withParameter(ParameterNames.METADATA, "1");
		return (T) readResponse(null, callApiGet(builder.buildUrl()));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphAccessObject#reload(com.google.code.facebook.graph.model.Entity)
	 */
	public <T extends Entity<?, ?>> T reload(T entity) {
		return load(entity.getId());
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphAccessObject#load(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Entity<?, ?>> T load(String id) {
		return load(id, null);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphAccessObject#load(java.lang.String, com.google.code.facebook.graph.client.AccessTokenProvider)
	 */
	@Override
	public <T extends Entity<?, ?>> T load(String id, AccessTokenProvider accessTokenProvider) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_OBJECT_URL);
		builder.withId(id).withParameter(ParameterNames.METADATA, "1");
		final T entity = readResponse(null, callApiGet(builder.buildUrl()));
		// resolve connections
		runAsConnected(Collections.singletonList((ActiveRecord) entity), new ConnectedModeCallback<Object>() {
			@Override
			public Object run() {
				entity.getAllConnections();
				return null;
			}
			
		}, accessTokenProvider);
		return entity;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphAccessObject#get(java.util.List)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Entity<?, ?>> Map<String, T> get(List<String> ids) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_OBJECT_URL);
		builder.withEmptyField("id").withIds(ids).withParameter(ParameterNames.METADATA, "1");
		return (Map<String, T>) readMapResponse(null, callApiGet(builder.buildUrl()));
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphAccessObject#get(com.google.code.facebook.graph.model.enumeration.ObjectType, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Entity<?, ?>> T get(ObjectType type, String id) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_OBJECT_URL);
		builder.withId(id);
		return (T) readResponse(type.type(), callApiGet(builder.buildUrl()));
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphAccessObject#get(com.google.code.facebook.graph.model.enumeration.ObjectType, java.lang.String, java.util.Set)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Entity<?, ?>> T get(ObjectType type, String id, Set<? extends FieldEnum> fields) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_OBJECT_URL);
		builder.withId(id).withParameterEnumSet(ParameterNames.FIELDS, fields, ",");
		return (T) readResponse(type.type(), callApiGet(builder.buildUrl()));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphAccessObject#get(com.google.code.facebook.graph.model.enumeration.ObjectType, java.util.List)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Entity<?, ?>> Map<String, T> get(ObjectType type, List<String> ids) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_OBJECT_URL);
		builder.withEmptyField("id").withIds(ids);
		return (Map<String, T>) readMapResponse(type.type(), callApiGet(builder.buildUrl()));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphAccessObject#get(com.google.code.facebook.graph.model.enumeration.ObjectType, java.util.List, java.util.Set)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Entity<?, ?>> Map<String, T> get(ObjectType type, List<String> ids, Set<? extends FieldEnum> fields) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_OBJECT_URL);
		builder.withEmptyField("id").withIds(ids).withParameterEnumSet(ParameterNames.FIELDS, fields, ",");
		return (Map<String, T>) readMapResponse(type.type(), callApiGet(builder.buildUrl()));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphAccessObject#getConnections(com.google.code.facebook.graph.model.enumeration.ObjectType, java.lang.String, com.google.code.facebook.graph.model.enumeration.ConnectionEnum)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getConnections(ObjectType type, String id, ConnectionEnum connectionType) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_CONNECTIONS_URL);
		builder.withId(id).withFieldEnum("connectionType", connectionType);
		return (PagedList<T>) readListResponse(connectionType.type(), callApiGet(builder.buildUrl()));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getConnections(ObjectType type, String id, ConnectionEnum connectionType, Paging paging, TimePeriod timePeriod) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_CONNECTIONS_URL);
		builder.withId(id).withFieldEnum("connectionType", connectionType).withPaging(paging).withTimePeriod(timePeriod);
		return (PagedList<T>) readListResponse(connectionType.type(), callApiGet(builder.buildUrl()));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphAccessObject#delete(java.lang.String)
	 */
	public void delete(String id) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_OBJECT_URL);
		builder.withId(id);
		callApiDelete(builder.buildUrl());
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphAccessObject#runAsConnected(java.util.List, com.google.code.facebook.graph.client.ConnectedModeCallback, com.google.code.facebook.graph.client.AccessTokenProvider)
	 */
	@Override
	public <T> T runAsConnected(List<? extends ActiveRecord> entities, ConnectedModeCallback<T> callback, AccessTokenProvider accessTokenProvider) {
		connectEntities(entities, this);
		// TODO-NM: Set Access Token Provider
		try {
			return callback.run();
		} finally {
			connectEntities(entities, null);			
		}
	}

	/**
	 * Connect entities.
	 * 
	 * @param entities the entities
	 * @param graphAccessObject the graph access object
	 */
	private void connectEntities(List<? extends ActiveRecord> entities, FacebookGraphAccessObject graphAccessObject) {
		for (ActiveRecord entity : entities) {
			entity.setGraphAccessObject(graphAccessObject);
		}
	}
}
