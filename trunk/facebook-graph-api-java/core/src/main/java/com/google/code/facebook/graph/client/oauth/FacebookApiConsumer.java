/*
 * 
 */
package com.google.code.facebook.graph.client.oauth;

/**
 * The Class FacebookApiConsumer.
 */
public class FacebookApiConsumer {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -508151196474695320L;
	
    /** The consumer key. */
	private String consumerKey;
	
    /** The consumer secret. */
	private String consumerSecret;

	/**
	 * Instantiates a new facebook api consumer.
	 * 
	 * @param consumerKey the consumer key
	 * @param consumerSecret the consumer secret
	 */
    public FacebookApiConsumer(String consumerKey, String consumerSecret) {
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
    }
    
    /**
     * Gets the consumer key.
     * 
     * @return the consumer key
     */
    public String getConsumerKey() {
        return consumerKey;
    }

    /**
     * Sets the consumer key.
     * 
     * @param consumerKey the new consumer key
     */
    public void setConsumerKey(String consumerKey) {
    	this.consumerKey = consumerKey;
    }

    /**
     * Gets the consumer secret.
     * 
     * @return the consumer secret
     */
    public String getConsumerSecret() {
        return consumerSecret;
    }

    /**
     * Sets the consumer secret.
     * 
     * @param consumerSecret the new consumer secret
     */
    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }
}
