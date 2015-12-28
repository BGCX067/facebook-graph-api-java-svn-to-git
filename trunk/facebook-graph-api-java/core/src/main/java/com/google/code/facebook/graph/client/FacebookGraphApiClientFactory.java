/*
 * 
 */
package com.google.code.facebook.graph.client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.code.facebook.graph.client.oauth.FacebookApiConsumer;
import com.google.code.facebook.graph.common.FacebookGraphAccessObject;

/**
 * A factory for creating FacebookGraphApiClient objects.
 */
public class FacebookGraphApiClientFactory {

    /** The Constant factoriesMap. */
    private static final Map<FacebookApiConsumer, FacebookGraphApiClientFactory> factoriesMap =
        new ConcurrentHashMap<FacebookApiConsumer, FacebookGraphApiClientFactory>();
    
    /** The task executor. */
    private ExecutorService taskExecutor = Executors.newCachedThreadPool();

    /** The api consumer. */
    @SuppressWarnings("unused")
	private FacebookApiConsumer apiConsumer;

    /**
     * Instantiates a new facebook graph api client factory.
     * 
     * @param apiConsumer the api consumer
     */
	private FacebookGraphApiClientFactory() {
		super();
    }
	
    /**
     * Instantiates a new facebook graph api client factory.
     * 
     * @param apiConsumer the api consumer
     */
	private FacebookGraphApiClientFactory(FacebookApiConsumer apiConsumer) {
        this.apiConsumer = apiConsumer;
    }
	
    /**
     * Sets the task executor.
     * 
     * @param taskExecutor the new task executor
     */
	public void setTaskExecutor(ExecutorService taskExecutor) {
        this.taskExecutor = taskExecutor;
	}

    /**
     * New instance.
     * 
     * @param consumerKey the consumer key
     * @param consumerSecret the consumer secret
     * 
     * @return the facebook graph api client factory
     */
    public static FacebookGraphApiClientFactory newInstance() {
        return new FacebookGraphApiClientFactory();
    }
    
    /**
     * New instance.
     * 
     * @param consumerKey the consumer key
     * @param consumerSecret the consumer secret
     * 
     * @return the facebook graph api client factory
     */
    public static FacebookGraphApiClientFactory newInstance(String consumerKey, String consumerSecret) {
        return newInstance(new FacebookApiConsumer(consumerKey, consumerSecret));
    }

    /**
     * New instance.
     * 
     * @param apiConsumer the api consumer
     * 
     * @return the facebook graph api client factory
     */
    public static synchronized FacebookGraphApiClientFactory newInstance(FacebookApiConsumer apiConsumer) {
    	validateConsumerKey(apiConsumer);
    	
        FacebookGraphApiClientFactory factory = factoriesMap.get(apiConsumer);

        if (factory == null) {
            factory = new FacebookGraphApiClientFactory(apiConsumer);
            factoriesMap.put(apiConsumer, factory);
        }

        return factory;
    }

    /**
     * Creates a new FacebookGraphApiClient object.
     * 
     * @param accessToken the access token
     * 
     * @return the facebook graph api client
     */
	public FacebookGraphApiClient createFacebookGraphApiClient(String accessToken) {
    	validateAccessToken(accessToken);
		final FacebookGraphApiClient client = new FacebookGraphApiJsonClient();

		client.setAccessToken(accessToken);

        return client;
    }
	
	/**
	 * Creates a new FacebookGraphApiClient object.
	 * 
	 * @param accessToken the access token
	 * 
	 * @return the facebook graph access object
	 */
	public FacebookGraphAccessObject createFacebookGraphAccessObject(String accessToken) {
    	validateAccessToken(accessToken);
		final FacebookGraphAccessObject client = new FacebookGraphApiJsonClient();

		client.setAccessToken(accessToken);

        return client;
    }
	
    /**
     * Creates a new FacebookGraphApiClient object.
     * 
     * @param accessToken the access token
     * 
     * @return the async facebook graph api client
     */
    public AsyncFacebookGraphApiClient createAsyncFacebookGraphApiClient(String accessToken) {
    	validateAccessToken(accessToken);
        final FacebookGraphApiClient client = createFacebookGraphApiClient(accessToken);

        return new AsyncFacebookGraphApiClientAdapter(client, taskExecutor);
    }
    
    /**
     * Validate consumer key.
     * 
     * @param apiConsumer the api consumer
     */
	private static void validateConsumerKey(FacebookApiConsumer apiConsumer) {
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
    
    /**
     * Validate access token.
     * 
     * @param accessToken the access token
     */
	private void validateAccessToken(String accessToken) {
		if (accessToken == null || accessToken.length() == 0) {
    		throw new IllegalArgumentException("access token cannot be null.");
    	}
	}
}
