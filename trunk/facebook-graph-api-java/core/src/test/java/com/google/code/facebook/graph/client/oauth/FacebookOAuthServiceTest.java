/*
 * 
 */
package com.google.code.facebook.graph.client.oauth;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.EnumSet;

import com.google.code.facebook.graph.client.BaseFacebookGraphApiTestCase;
import com.google.code.facebook.graph.client.constant.TestConstants;
import com.google.code.facebook.graph.model.enumeration.Permission;

/**
 * The Class FacebookOAuthServiceTest.
 */
public class FacebookOAuthServiceTest extends BaseFacebookGraphApiTestCase {
	
    /** The service. */
	private FacebookOAuthService service;
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.BaseFacebookGraphApiTestCase#setUp()
	 */
	protected void setUp() throws Exception {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test consumer key."), TestConstants.TEST_CONSUMER_KEY);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test consumer secret."), TestConstants.TEST_CONSUMER_SECRET);
		service = FacebookOAuthServiceFactory.getInstance().createFacebookOAuthService(TestConstants.TEST_CONSUMER_KEY, TestConstants.TEST_CONSUMER_SECRET);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.BaseFacebookGraphApiTestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		service = null;
	}

	/**
	 * Test get authorization url.
	 */
	public void testGetAuthorizationUrl() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test callback URL."), TestConstants.TEST_CALLBACK_URL);
		String authorizationUrl = service.getAuthorizationUrl(TestConstants.TEST_CALLBACK_URL);
		assertNotNullOrEmpty("Authorization URL should not be null.", authorizationUrl);
		try {
            URL               url     = new URL(authorizationUrl);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
			
			if (request.getResponseCode() != HttpURLConnection.HTTP_OK) {
				fail(convertStreamToString(request.getErrorStream()));
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test get authorization url set.
	 */
	public void testGetAuthorizationUrlSet() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test callback URL."), TestConstants.TEST_CALLBACK_URL);
		String authorizationUrl = service.getAuthorizationUrl(TestConstants.TEST_CALLBACK_URL, EnumSet.of(Permission.USER_PHOTOS, Permission.USER_VIDEOS, Permission.PUBLISH_STREAM));
		assertNotNullOrEmpty("Authorization URL should not be null.", authorizationUrl);
		try {
            URL               url     = new URL(authorizationUrl);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
			
			if (request.getResponseCode() != HttpURLConnection.HTTP_OK) {
				fail(convertStreamToString(request.getErrorStream()));
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test get access token.
	 */
	public void testGetAccessToken() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test callback URL."), TestConstants.TEST_CALLBACK_URL);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test code."), TestConstants.TEST_CODE);
		FacebookAccessToken accessToken = service.getAccessToken(TestConstants.TEST_CALLBACK_URL, TestConstants.TEST_CODE);
		assertNotNull("Access token should not be null.", accessToken);
		assertNotNullOrEmpty("Access token should not be null.", accessToken.getAccessToken());
	}
}
