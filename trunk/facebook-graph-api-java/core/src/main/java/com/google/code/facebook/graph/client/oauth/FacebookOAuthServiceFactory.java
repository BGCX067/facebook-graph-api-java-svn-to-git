/*
 * 
 */
package com.google.code.facebook.graph.client.oauth;


/**
 * A factory for creating FacebookOAuthService objects.
 */
public class FacebookOAuthServiceFactory {

    /** The instance. */
    private static FacebookOAuthServiceFactory instance;

    /**
     * Instantiates a new facebook o auth service factory.
     */
    private FacebookOAuthServiceFactory() {}

    /**
     * Gets the single instance of FacebookOAuthServiceFactory.
     * 
     * @return single instance of FacebookOAuthServiceFactory
     */
    public static synchronized FacebookOAuthServiceFactory getInstance() {
        if (instance == null) {
            instance = new FacebookOAuthServiceFactory();
        }

        return instance;
    }

    /**
     * Creates a new FacebookOAuthService object.
     * 
     * @param consumerKey the consumer key
     * @param consumerSecret the consumer secret
     * 
     * @return the facebook o auth service
     */
    public FacebookOAuthService createFacebookOAuthService(String consumerKey, String consumerSecret) {
        return createFacebookOAuthService(new FacebookApiConsumer(consumerKey, consumerSecret));
    }

    /**
     * Creates a new FacebookOAuthService object.
     * 
     * @param apiConsumer the api consumer
     * 
     * @return the facebook o auth service
     */
    public FacebookOAuthService createFacebookOAuthService(FacebookApiConsumer apiConsumer) {
    	validateConsumerKey(apiConsumer);
        return new FacebookOAuthServiceImpl(apiConsumer);
    }
    
    /**
     * Validate consumer key.
     * 
     * @param apiConsumer the api consumer
     */
	private void validateConsumerKey(FacebookApiConsumer apiConsumer) {
		if (apiConsumer == null) {
    		throw new IllegalArgumentException("api consumer cannot be null.");
    	}
    	if (apiConsumer.getConsumerKey() == null || apiConsumer.getConsumerKey().length() == 0) {
    		throw new IllegalArgumentException("consumer key cannot be null or empty.");
    	}
    	if (apiConsumer.getConsumerSecret() == null || apiConsumer.getConsumerSecret().length() == 0) {
    		throw new IllegalArgumentException("consumer secret cannot be null or empty.");
    	}
	}
}
