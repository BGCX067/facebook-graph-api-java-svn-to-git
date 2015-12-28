/*
 * 
 */
package com.google.code.facebook.graph.client.constant;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.code.facebook.graph.common.FacebookGraphAccessObject.Paging;
import com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod;
import com.google.code.facebook.graph.model.enumeration.ValueEnum;

/**
 * The Class FacebookGraphApiUrls.
 */
public final class FacebookGraphApiUrls {

    /** The Constant API_URLS_FILE. */
    private static final String API_URLS_FILE = "FacebookGraphApiUrls.properties";

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(FacebookGraphApiUrls.class.getCanonicalName());
    
    /** The Constant graphApiUrls. */
    private static final Properties graphApiUrls = new Properties();

    static {
        try {
            graphApiUrls.load(FacebookGraphApiUrls.class.getResourceAsStream(API_URLS_FILE));
        } catch (IOException e) {
        	LOG.log(Level.SEVERE, "An error occurred while loading urls.", e);
        }
    }

    /** The Constant FACEBOOK_GRAPH_API_AUTHORIZATION_URL. */
    public static final String FACEBOOK_GRAPH_API_AUTHORIZATION_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.auth.authorize");

    /** The Constant FACEBOOK_GRAPH_API_ACCESS_TOKEN_URL. */
    public static final String FACEBOOK_GRAPH_API_ACCESS_TOKEN_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.auth.accessToken");
    
    /** The Constant FACEBOOK_GRAPH_API_OBJECT_URL. */
    public static final String FACEBOOK_GRAPH_API_OBJECT_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.object");
    
    /** The Constant FACEBOOK_GRAPH_API_PICTURE_URL. */
    public static final String FACEBOOK_GRAPH_API_PICTURE_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.picture");
    
    /** The Constant FACEBOOK_GRAPH_API_CONNECTIONS_URL. */
    public static final String FACEBOOK_GRAPH_API_CONNECTIONS_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.connections");
    
    /** The Constant FACEBOOK_GRAPH_API_SEARCH_URL. */
    public static final String FACEBOOK_GRAPH_API_SEARCH_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.search");
    
    /** The Constant FACEBOOK_GRAPH_API_SEARCH_NEWS_FEED_URL. */
    public static final String FACEBOOK_GRAPH_API_SEARCH_NEWS_FEED_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.searchNewsFeed");
    
    /** The Constant FACEBOOK_GRAPH_API_POST_FEED_URL. */
    public static final String FACEBOOK_GRAPH_API_POST_FEED_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.postFeed");
    
    /** The Constant FACEBOOK_GRAPH_API_POST_COMMENT_URL. */
    public static final String FACEBOOK_GRAPH_API_POST_COMMENT_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.postComment");
    
    /** The Constant FACEBOOK_GRAPH_API_LIKE_POST_URL. */
    public static final String FACEBOOK_GRAPH_API_LIKE_POST_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.likePost");
    
    /** The Constant FACEBOOK_GRAPH_API_POST_NOTE_URL. */
    public static final String FACEBOOK_GRAPH_API_POST_NOTE_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.postNote");
    
    /** The Constant FACEBOOK_GRAPH_API_POST_LINK_URL. */
    public static final String FACEBOOK_GRAPH_API_POST_LINK_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.postLink");
    
    /** The Constant FACEBOOK_GRAPH_API_CREATE_EVENT_URL. */
    public static final String FACEBOOK_GRAPH_API_CREATE_EVENT_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.createEvent");
    
    /** The Constant FACEBOOK_GRAPH_API_ATTEND_EVENT_URL. */
    public static final String FACEBOOK_GRAPH_API_ATTEND_EVENT_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.attendEvent");
    
    /** The Constant FACEBOOK_GRAPH_API_MAYBE_ATTEND_EVENT_URL. */
    public static final String FACEBOOK_GRAPH_API_MAYBE_ATTEND_EVENT_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.maybeAttendEvent");
    
    /** The Constant FACEBOOK_GRAPH_API_DECLINE_EVENT_URL. */
    public static final String FACEBOOK_GRAPH_API_DECLINE_EVENT_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.declineEvent");
    
    /** The Constant FACEBOOK_GRAPH_API_CREATE_ALBUM_URL. */
    public static final String FACEBOOK_GRAPH_API_CREATE_ALBUM_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.createAlbum");
    
    /** The Constant FACEBOOK_GRAPH_API_UPLOAD_PHOTO_URL. */
    public static final String FACEBOOK_GRAPH_API_UPLOAD_PHOTO_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.uploadPhoto");
    
    /** The Constant FACEBOOK_GRAPH_API_ANALYTICS_URL. */
    public static final String FACEBOOK_GRAPH_API_ANALYTICS_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.analytics");
    
    /** The Constant FACEBOOK_GRAPH_API_ANALYTICS_URL. */
    public static final String FACEBOOK_GRAPH_API_SUBSCRIPTIONS_URL =
        graphApiUrls.getProperty("com.google.code.facebook.graph.subscriptions");
    
    /**
     * Instantiates a new facebook graph api urls.
     */
    private FacebookGraphApiUrls() {}

    /**
     * The Class FacebookGraphApiUrlBuilder.
     */
    public static class FacebookGraphApiUrlBuilder {
        
        /** The Constant API_URLS_PLACEHOLDER_START. */
        private static final char API_URLS_PLACEHOLDER_START = '{';

        /** The Constant API_URLS_PLACEHOLDER_END. */
        private static final char API_URLS_PLACEHOLDER_END = '}';
        
        /** The Constant QUERY_PARAMETERS_PLACEHOLDER. */
        private static final String QUERY_PARAMETERS_PLACEHOLDER = "queryParameters";
    	
    	/** The url format. */
	    private String urlFormat;
    	
    	/** The parameters map. */
	    private Map<String, Collection<String>> parametersMap = new HashMap<String, Collection<String>>();
    	
	    /** The fields map. */
	    private Map<String, String> fieldsMap = new HashMap<String, String>();
    	
    	/**
	     * Instantiates a new facebook graph api url builder.
	     * 
	     * @param urlFormat the url format
	     */
	    public FacebookGraphApiUrlBuilder(String urlFormat) {
    		this.urlFormat = urlFormat;    		
    	}
    	
    	/**
	     * Instantiates a new facebook graph api url builder.
	     * 
	     * @param urlFormat the url format
	     * @param accessToken the access token
	     */
	    public FacebookGraphApiUrlBuilder(String urlFormat, String accessToken) {
    		this.urlFormat = urlFormat;
    		withParameter(ParameterNames.ACCESS_TOKEN, accessToken);
    	}
    	
    	/**
	     * With parameter.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the facebook graph api url builder
	     */
	    public FacebookGraphApiUrlBuilder withParameter(String name, String value) {
	    	if (value != null && value.length() > 0) {
	    		parametersMap.put(name, Collections.singleton(encodeUrl(value)));
	    	}
    		
    		return this;
    	}
    	
    	/**
	     * With parameters.
	     * 
	     * @param name the name
	     * @param values the values
	     * 
	     * @return the facebook graph api url builder
	     */
	    public FacebookGraphApiUrlBuilder withParameters(String name, Collection<String> values) {
	    	List<String> encodedValues = new ArrayList<String>(values.size());
	    	for (String value : values) {
	    		encodedValues.add(encodeUrl(value));
	    	}
    		parametersMap.put(name, encodedValues);
    		
    		return this;
    	}
	    
		/**
		 * With parameters.
		 * 
		 * @param name the name
		 * @param values the values
		 * @param separator the separator
		 * 
		 * @return the facebook graph api url builder
		 */
		public FacebookGraphApiUrlBuilder withParameters(String name, Collection<String> values, String separator) {
			StringBuilder builder = new StringBuilder();
			for (Iterator<String> iterator = values.iterator(); iterator.hasNext();) {
				builder.append(iterator.next());
				if (iterator.hasNext()) {
					builder.append(separator);
				}
			}
			parametersMap.put(name, Collections.singleton(encodeUrl(builder.toString())));

			return this;
		}
	    
    	
    	/**
	     * With parameter enum set.
	     * 
	     * @param name the name
	     * @param enumSet the enum set
	     * 
	     * @return the facebook graph api url builder
	     */
	    public FacebookGraphApiUrlBuilder withParameterEnumSet(String name, Set<? extends ValueEnum> enumSet) {
	    	Set<String> values = new HashSet<String>(enumSet.size());
	    	
	    	for (ValueEnum fieldEnum : enumSet) {
	    		values.add(encodeUrl(fieldEnum.value()));
	    	}
	    	
    		parametersMap.put(name, values);
    		
    		return this;
    	}
	    
    	/**
	     * With parameter enum set.
	     * 
	     * @param name the name
	     * @param enumSet the enum set
	     * @param separator the separator
	     * 
	     * @return the facebook graph api url builder
	     */
	    public FacebookGraphApiUrlBuilder withParameterEnumSet(String name, Set<? extends ValueEnum> enumSet, String separator) {
	    	Set<String> values = new HashSet<String>(enumSet.size());
	    	
	    	for (ValueEnum fieldEnum : enumSet) {
	    		values.add(encodeUrl(fieldEnum.value()));
	    	}
	    	
	    	withParameters(name, values, separator);
	    	
    		return this;
    	}
	    
    	/**
	     * With parameter enum.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the facebook graph api url builder
	     */
	    public FacebookGraphApiUrlBuilder withParameterEnum(String name, ValueEnum value) {
	    	withParameter(name, value.value());
    		
    		return this;
    	}
    	
    	/**
	     * With empty field.
	     * 
	     * @param name the name
	     * 
	     * @return the facebook graph api url builder
	     */
	    public FacebookGraphApiUrlBuilder withEmptyField(String name) {
    		fieldsMap.put(name, "");
    		
    		return this;
    	}
	    
    	/**
	     * With field.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the facebook graph api url builder
	     */
	    public FacebookGraphApiUrlBuilder withField(String name, String value) {
	    	withField(name, value, false);
    		
    		return this;
    	}
	    
    	/**
	     * With field.
	     * 
	     * @param name the name
	     * @param value the value
	     * @param escape the escape
	     * 
	     * @return the facebook graph api url builder
	     */
	    public FacebookGraphApiUrlBuilder withField(String name, String value, boolean escape) {
	    	if (escape) {
	    		fieldsMap.put(name, encodeUrl(value));
	    	} else {
	    		fieldsMap.put(name, value);
	    	}
    		
    		return this;
    	}
	    
    	/**
	     * With field enum.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the facebook graph api url builder
	     */
	    public FacebookGraphApiUrlBuilder withFieldEnum(String name, ValueEnum value) {
	    	if (value.value() == null || value.value().length() == 0) {
	    		fieldsMap.put(name, "");
	    	} else {
	    		fieldsMap.put(name, value.value());
	    	}
    		
    		return this;
    	}
	    
		/**
		 * With paging.
		 * 
		 * @param paging the paging
		 * 
		 * @return the facebook graph api url builder
		 */
		public FacebookGraphApiUrlBuilder withPaging(Paging paging) {
			if (paging != null) {
				if (paging.getLimit() > 0) {
					withParameter(ParameterNames.LIMIT, String.valueOf(paging.getLimit()));
				}
				if (paging.getOffset() > 0) {
					withParameter(ParameterNames.OFFSET, String.valueOf(paging.getOffset()));
				}
			}

			return this;
		}
		
		/**
		 * With time period.
		 * 
		 * @param timePeriod the time period
		 * 
		 * @return the facebook graph api url builder
		 */
		public FacebookGraphApiUrlBuilder withTimePeriod(TimePeriod timePeriod) {
			if (timePeriod != null) {
				if (timePeriod.getSince() != null) {
					withParameter(ParameterNames.SINCE, timePeriod.getSince());
				}
				if (timePeriod.getUntil() != null) {
					withParameter(ParameterNames.UNTIL, timePeriod.getUntil());
				}
			}

			return this;
		}
		
		/**
		 * With id.
		 * 
		 * @param id the id
		 * 
		 * @return the facebook graph api url builder
		 */
		public FacebookGraphApiUrlBuilder withId(String id) {
			withField("id", id, false);
			return this;
		}

		/**
		 * With ids.
		 * 
		 * @param ids the ids
		 * 
		 * @return the facebook graph api url builder
		 */
		public FacebookGraphApiUrlBuilder withIds(List<String> ids) {
			withParameters(ParameterNames.IDS, ids, ",");
			return this;
		}
		
	    
    	/**
	     * Builds the url.
	     * 
	     * @return the string
	     */
		public String buildUrl() {
        	StringBuilder urlBuilder = new StringBuilder();
        	StringBuilder placeHolderBuilder = new StringBuilder();
        	boolean placeHolderFlag = false;
        	for (int i = 0; i < urlFormat.length(); i++) {
        		if (urlFormat.charAt(i) == API_URLS_PLACEHOLDER_START) {
        			placeHolderBuilder = new StringBuilder();
        			placeHolderFlag = true;
        		} else if (placeHolderFlag && urlFormat.charAt(i) == API_URLS_PLACEHOLDER_END) {
        			String placeHolder = placeHolderBuilder.toString();
        			if (fieldsMap.containsKey(placeHolder)) {
        				urlBuilder.append(fieldsMap.get(placeHolder));
        			} else if (QUERY_PARAMETERS_PLACEHOLDER.equals(placeHolder)) {
    			    	StringBuilder builder = new StringBuilder();
    			    	if (!parametersMap.isEmpty()) {
    			        	builder.append("?");
    			    		Iterator<String> iter = parametersMap.keySet().iterator();
    			    		while (iter.hasNext()) {
    			    			String name = iter.next();
			    				Collection<String> parameterValues = parametersMap.get(name);
			    				Iterator<String> iterParam = parameterValues.iterator();
			    				while (iterParam.hasNext()) {
    			    				builder.append(name);
    			    				builder.append("=");
    			    				builder.append(iterParam.next());
    			    				if (iterParam.hasNext()) {
        			    				builder.append("&");
    			    				}
			    				}
    			    			if (iter.hasNext()) {
    			    				builder.append("&");
    			    			}
    			    		}
    			    	}
    			    	urlBuilder.append(builder.toString());
        			} else {
        				// we did not find a binding for the placeholder.
        				// append it as it is.
        				urlBuilder.append(API_URLS_PLACEHOLDER_START);
        				urlBuilder.append(placeHolder);
        				urlBuilder.append(API_URLS_PLACEHOLDER_END);
        			}
        			placeHolderFlag = false;
        		} else if (placeHolderFlag) {
        			placeHolderBuilder.append(urlFormat.charAt(i));
        		} else {
        			urlBuilder.append(urlFormat.charAt(i));
        		}
        	}

        	return urlBuilder.toString();
    	}
    	
        /**
         * Encode url.
         * 
         * @param original the original
         * 
         * @return the string
         */
        private static String encodeUrl(String original) {
        	try {
    			return URLEncoder.encode(original, ApplicationConstants.CONTENT_ENCODING);
    		} catch (UnsupportedEncodingException e) {
    			// should never be here..
    			return original;
    		}
        }
    }
}
