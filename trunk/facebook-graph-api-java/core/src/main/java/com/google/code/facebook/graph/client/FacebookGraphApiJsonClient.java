/*
 * 
 */
package com.google.code.facebook.graph.client;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.code.facebook.graph.client.constant.ApplicationConstants;
import com.google.code.facebook.graph.client.constant.FacebookGraphApiUrls;
import com.google.code.facebook.graph.client.constant.FacebookGraphApiUrls.FacebookGraphApiUrlBuilder;
import com.google.code.facebook.graph.client.exception.FacebookGraphApiException;
import com.google.code.facebook.graph.client.exception.OAuthException;
import com.google.code.facebook.graph.client.exception.QueryParseException;
import com.google.code.facebook.graph.common.PagedArrayList;
import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.Album;
import com.google.code.facebook.graph.model.Entity;
import com.google.code.facebook.graph.model.Event;
import com.google.code.facebook.graph.model.Group;
import com.google.code.facebook.graph.model.Insight;
import com.google.code.facebook.graph.model.Link;
import com.google.code.facebook.graph.model.Note;
import com.google.code.facebook.graph.model.Page;
import com.google.code.facebook.graph.model.Photo;
import com.google.code.facebook.graph.model.Post;
import com.google.code.facebook.graph.model.Status;
import com.google.code.facebook.graph.model.Stream;
import com.google.code.facebook.graph.model.User;
import com.google.code.facebook.graph.model.Video;
import com.google.code.facebook.graph.model.adapter.Adapter;
import com.google.code.facebook.graph.model.adapter.json.AlbumImpl;
import com.google.code.facebook.graph.model.adapter.json.BaseEntity;
import com.google.code.facebook.graph.model.adapter.json.EventImpl;
import com.google.code.facebook.graph.model.adapter.json.GroupImpl;
import com.google.code.facebook.graph.model.adapter.json.InsightImpl;
import com.google.code.facebook.graph.model.adapter.json.LinkImpl;
import com.google.code.facebook.graph.model.adapter.json.NoteImpl;
import com.google.code.facebook.graph.model.adapter.json.PageImpl;
import com.google.code.facebook.graph.model.adapter.json.PhotoImpl;
import com.google.code.facebook.graph.model.adapter.json.PostImpl;
import com.google.code.facebook.graph.model.adapter.json.StatusImpl;
import com.google.code.facebook.graph.model.adapter.json.UserImpl;
import com.google.code.facebook.graph.model.adapter.json.VideoImpl;
import com.google.code.facebook.graph.model.enumeration.ObjectType;


/**
 * The Class FacebookGraphApiJsonClient.
 */
@SuppressWarnings("unchecked")
public class FacebookGraphApiJsonClient extends BaseFacebookGraphApiClient {
	
    /** The parser. */
    private final JSONParser parser = new JSONParser();
    
    /** The Constant ADAPTER_CLASSES_MAP. */
	private static final Map<Class<? extends Entity<?, ?>>, Class<? extends Adapter<?>>> ADAPTER_CLASSES_MAP = new HashMap<Class<? extends Entity<?, ?>>, Class<? extends Adapter<?>>>();
	
	/** The Constant DATA_HOLDER. */
	private static final String DATA_HOLDER = "data";
	
	/** The Constant ERROR_HOLDER. */
	private static final String ERROR_HOLDER = "error";
	
	/** The Constant PAGING_HOLDER. */
	private static final String PAGING_HOLDER = "paging";
	
	static {
		ADAPTER_CLASSES_MAP.put(Album.class, AlbumImpl.class);
		ADAPTER_CLASSES_MAP.put(Event.class, EventImpl.class);
		ADAPTER_CLASSES_MAP.put(Group.class, GroupImpl.class);
		ADAPTER_CLASSES_MAP.put(Link.class, LinkImpl.class);
		ADAPTER_CLASSES_MAP.put(Note.class, NoteImpl.class);
		ADAPTER_CLASSES_MAP.put(Page.class, PageImpl.class);
		ADAPTER_CLASSES_MAP.put(Photo.class, PhotoImpl.class);
		ADAPTER_CLASSES_MAP.put(Post.class, PostImpl.class);
		ADAPTER_CLASSES_MAP.put(Status.class, StatusImpl.class);
		ADAPTER_CLASSES_MAP.put(User.class, UserImpl.class);
		ADAPTER_CLASSES_MAP.put(Video.class, VideoImpl.class);
		ADAPTER_CLASSES_MAP.put(Insight.class, InsightImpl.class);
		// TODO-NM: kludge
		ADAPTER_CLASSES_MAP.put((Class<? extends Entity<?, ?>>) Stream.class, PostImpl.class);
	}
	

    /**
     * Instantiates a new facebook graph api json client.
     */
    public FacebookGraphApiJsonClient() {
        super();
    }
    
    /* (non-Javadoc)
     * @see com.google.code.facebook.graph.client.BaseFacebookGraphAccessObject#unmarshallObject(java.lang.Class, java.io.InputStream)
     */
    @SuppressWarnings("unchecked")
    protected <T> T unmarshallObject(Class<T> clazz, InputStream jsonContent) {
    	JSONObject response = parseJson(jsonContent);
		if (clazz == null) {
			ObjectType type = ObjectType.fromValue((String) (response).get("type"));
			if (type == null) {
	        	throw new FacebookGraphApiException("Unknown content found in response:" + response.toString());
			}
			clazz = (Class<T>) type.type();
		}
		try {
			Adapter<JSONObject> adapter = (Adapter<JSONObject>) ADAPTER_CLASSES_MAP.get(clazz).newInstance();
			adapter.adaptFrom((JSONObject) response);
			setPicture((BaseEntity) adapter);
			return (T) adapter;
        } catch (Exception e) {
            throw new FacebookGraphApiException(e);
        }
    }
    
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.BaseFacebookGraphAccessObject#unmarshallMap(java.lang.Class, java.io.InputStream)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected <T> Map<String, T> unmarshallMap(Class<T> clazz, InputStream jsonContent) {
    	JSONObject multipart = parseJson(jsonContent);
        try {
        	Class<T> type = clazz;
    		Map<String, T> objectsMap = new HashMap<String, T>();
    		for (String key : (Set<String>) multipart.keySet()) {
        		JSONObject adaptee = (JSONObject) multipart.get(key);
        		if (clazz == null) {
        			ObjectType objectType = ObjectType.fromValue((String) adaptee.get("type"));
        			if (objectType == null) {
        	        	throw new FacebookGraphApiException("Unknown content found in response:" + multipart.toString());
        			}
        			type = (Class<T>) objectType.type();
        		}
        		Adapter<JSONObject> adapter = (Adapter<JSONObject>) ADAPTER_CLASSES_MAP.get(type).newInstance();
				adapter.adaptFrom(adaptee);
				setPicture((BaseEntity) adapter);
        		objectsMap.put(key, (T) adapter);
    		}
    		return objectsMap;
        } catch (Exception e) {
            throw new FacebookGraphApiException(e);
        }
	}
    
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.BaseFacebookGraphAccessObject#unmarshallList(java.lang.Class, java.io.InputStream)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected <T> PagedList<T> unmarshallList(Class<T> clazz, InputStream jsonContent) {
        try {
        	JSONObject response = parseJson(jsonContent);
    		PagedList<T> objectsList = new PagedArrayList<T>();
    		JSONArray array = (JSONArray) response.get(DATA_HOLDER);
    		if (array != null) {
        		for (JSONObject object : (List<JSONObject>) array) {
            		Adapter<JSONObject> adapter = (Adapter<JSONObject>) ADAPTER_CLASSES_MAP.get(clazz).newInstance();
            		adapter.adaptFrom(object);
            		setPicture((BaseEntity) adapter);
            		objectsList.add((T) adapter);
        		}
    		}
    		JSONObject paging = (JSONObject) response.get(PAGING_HOLDER);
    		if (paging != null) {
    			objectsList.setNextEndPoint((String) paging.get("next"));
    			objectsList.setPreviousEndPoint((String) paging.get("previous"));
    		}
    		return objectsList;
        } catch (Exception e) {
            throw new FacebookGraphApiException(e);
        }
	}
	
    /* (non-Javadoc)
     * @see com.google.code.facebook.graph.client.BaseFacebookGraphAccessObject#marshallObject(java.lang.Object)
     */
    protected String marshallObject(Object element) {
        try {
            StringWriter writer = new StringWriter();

            return writer.toString();
        } catch (Exception e) {
            throw new FacebookGraphApiException(e);
        }
    }

    /* (non-Javadoc)
     * @see com.google.code.facebook.graph.client.BaseFacebookGraphAccessObject#createFacebookGraphApiUrlBuilder(java.lang.String)
     */
    protected FacebookGraphApiUrlBuilder createFacebookGraphApiUrlBuilder(String urlFormat) {
        return new FacebookGraphApiUrlBuilder(urlFormat, getAccessToken());
    }
    
    /**
     * Sets the picture.
     * 
     * @param entity the new picture
     */
	protected void setPicture(BaseEntity entity) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_PICTURE_URL);
		builder.withId(entity.getId());
		entity.setPicture(builder.buildUrl());
	}
	
	protected JSONObject parseJson(InputStream jsonContent) {
		try {
			Object response = parser.parse(new InputStreamReader(jsonContent));
	    	if (response instanceof JSONObject) {
	    		JSONObject object = (JSONObject) response;
	    		if (object.containsKey(ERROR_HOLDER)) {
	    			throw createFacebookGraphApiClientException((JSONObject) object.get(ERROR_HOLDER)); 
	    		}
	    		return object;
	    	}
        	if (ApplicationConstants.ACCESS_DENIED_PATTERN.matcher(response.toString()).find()) {
            	throw new FacebookGraphApiException("Access to the requested resource has been denied.");
        	} else { 
            	throw new FacebookGraphApiException("Unknown content found in response:" + response.toString());
        	}
		} catch (IOException e) {
			throw new FacebookGraphApiException(e);			
		} catch (ParseException e) {
			throw new FacebookGraphApiException(e);			
		}
	}

	protected FacebookGraphApiException createFacebookGraphApiClientException(JSONObject object) {
		String type = (String) object.get("type");
		String message = (String) object.get("message");
		if ("OAuthException".equals(type)) {
			return new OAuthException(message);
		} else if ("QueryParseException".equals(type)) {
			return new QueryParseException(message);
		} else {
			return new FacebookGraphApiException(message);
		}
	}
}
