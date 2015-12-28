/*
 * 
 */
package com.google.code.facebook.graph.client.oauth;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;

import com.google.code.facebook.graph.client.FacebookGraphApiGateway;
import com.google.code.facebook.graph.client.constant.ApplicationConstants;
import com.google.code.facebook.graph.client.constant.FacebookGraphApiUrls;
import com.google.code.facebook.graph.client.constant.ParameterNames;
import com.google.code.facebook.graph.client.constant.FacebookGraphApiUrls.FacebookGraphApiUrlBuilder;
import com.google.code.facebook.graph.model.enumeration.DialogFormFactor;
import com.google.code.facebook.graph.model.enumeration.Permission;

/**
 * The Class FacebookOAuthServiceImpl.
 * @version $Revision: 252 $ $Date: 2010-10-13 18:39:25 +0700 (Wed, 13 Oct 2010) $
 * @author $Author: nabeelmukhtar $
 */
class FacebookOAuthServiceImpl extends FacebookGraphApiGateway implements FacebookOAuthService {

    /** The api consumer. */
    private final FacebookApiConsumer apiConsumer;

    /** The request headers. */
    private Map<String, String> requestHeaders;
    
    /**
     * Instantiates a new facebook o auth service impl.
     * 
     * @param apiConsumer the api consumer
     */
    FacebookOAuthServiceImpl(FacebookApiConsumer apiConsumer) {
    	requestHeaders = new HashMap<String, String>();
    	this.apiConsumer = apiConsumer;
    }
    
    /* (non-Javadoc)
     * @see com.google.code.facebook.graph.client.FacebookGraphApiGateway#setRequestHeaders(java.util.Map)
     */
    public void setRequestHeaders(Map<String, String> requestHeaders) {
    	if (requestHeaders == null) {
    		throw new IllegalArgumentException("request headers cannot be null.");
    	}
        this.requestHeaders = requestHeaders;
    }

    /* (non-Javadoc)
     * @see com.google.code.facebook.graph.client.FacebookGraphApiGateway#getRequestHeaders()
     */
    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    /* (non-Javadoc)
     * @see com.google.code.facebook.graph.client.FacebookGraphApiGateway#addRequestHeader(java.lang.String, java.lang.String)
     */
    public void addRequestHeader(String headerName, String headerValue) {
        requestHeaders.put(headerName, headerValue);
    }

    /* (non-Javadoc)
     * @see com.google.code.facebook.graph.client.FacebookGraphApiGateway#removeRequestHeader(java.lang.String)
     */
    public void removeRequestHeader(String headerName) {
        requestHeaders.remove(headerName);
    }

    /* (non-Javadoc)
     * @see com.google.code.facebook.graph.client.oauth.FacebookOAuthService#getAuthorizationUrl(java.lang.String)
     */
    @Override
	public String getAuthorizationUrl(String callBackUrl) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_AUTHORIZATION_URL);
		builder.withParameter(ParameterNames.CLIENT_ID, apiConsumer.getConsumerKey()).withParameter(ParameterNames.REDIRECT_URI, callBackUrl);
		return builder.buildUrl();
	}
    
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.oauth.FacebookOAuthService#getAuthorizationUrl(java.lang.String, java.util.Set)
	 */
	@Override
	public String getAuthorizationUrl(String callBackUrl,
			Set<Permission> permissions) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_AUTHORIZATION_URL);
		builder.withParameter(ParameterNames.CLIENT_ID, apiConsumer.getConsumerKey()).withParameter(ParameterNames.REDIRECT_URI, callBackUrl);
		builder.withParameterEnumSet(ParameterNames.SCOPE, permissions, ",");
		return builder.buildUrl();
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.oauth.FacebookOAuthService#getAuthorizationUrl(java.lang.String, com.google.code.facebook.graph.model.enumeration.DialogFormFactor)
	 */
	@Override
	public String getAuthorizationUrl(String callBackUrl,
			DialogFormFactor formFactor) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_AUTHORIZATION_URL);
		builder.withParameter(ParameterNames.CLIENT_ID, apiConsumer.getConsumerKey()).withParameter(ParameterNames.REDIRECT_URI, callBackUrl);
		builder.withParameterEnum(ParameterNames.DISPLAY, formFactor);
		return builder.buildUrl();
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.oauth.FacebookOAuthService#getAuthorizationUrl(java.lang.String, java.util.Set, com.google.code.facebook.graph.model.enumeration.DialogFormFactor)
	 */
	@Override
	public String getAuthorizationUrl(String callBackUrl,
			Set<Permission> permissions, DialogFormFactor formFactor) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_AUTHORIZATION_URL);
		builder.withParameter(ParameterNames.CLIENT_ID, apiConsumer.getConsumerKey()).withParameter(ParameterNames.REDIRECT_URI, callBackUrl);
		builder.withParameterEnumSet(ParameterNames.SCOPE, permissions, ",").withParameterEnum(ParameterNames.DISPLAY, formFactor);
		return builder.buildUrl();
	}
    
    /* (non-Javadoc)
     * @see com.google.code.facebook.graph.client.oauth.FacebookOAuthService#getAccessToken(java.lang.String, java.lang.String)
     */
    @Override
	public FacebookAccessToken getAccessToken(String callBackUrl, String code) {
    	try {
    		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_ACCESS_TOKEN_URL);
    		builder.withParameter(ParameterNames.CLIENT_ID, apiConsumer.getConsumerKey());
    		builder.withParameter(ParameterNames.CLIENT_SECRET, apiConsumer.getConsumerSecret());
    		builder.withParameter(ParameterNames.REDIRECT_URI, callBackUrl);
    		builder.withParameter(ParameterNames.CODE, code);
    		
			String response = convertStreamToString(callApiGet(builder.buildUrl()));
			Matcher matcher = ApplicationConstants.ACCESS_TOKEN_PATTERN.matcher(response);
			if (matcher.find()) {
				FacebookAccessToken accessToken = new FacebookAccessToken();
				accessToken.setAccessToken(matcher.group(1));
				if (matcher.groupCount() == 3 && matcher.group(3) != null) {
					accessToken.setDuration(Integer.parseInt(matcher.group(3)));
				}
            	return accessToken;
            } else {
            	throw new FacebookOAuthServiceException(response);
            }
		} catch (Exception e) {
			throw new FacebookOAuthServiceException(e);
		}
	}
    
    /**
     * Creates the facebook graph api url builder.
     * 
     * @param urlFormat the url format
     * 
     * @return the facebook graph api url builder
     */
    protected FacebookGraphApiUrlBuilder createFacebookGraphApiUrlBuilder(String urlFormat) {
    	return new FacebookGraphApiUrlBuilder(urlFormat);
    }
}
