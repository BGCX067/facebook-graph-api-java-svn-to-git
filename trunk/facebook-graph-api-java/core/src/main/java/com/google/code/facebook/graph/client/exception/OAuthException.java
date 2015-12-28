/*
 * 
 */
package com.google.code.facebook.graph.client.exception;

import java.util.Date;

/**
 * The Class FacebookGraphApiClientException.
 */
public class OAuthException extends FacebookGraphApiException {
	
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4345556572105572685L;

	/**
	 * Instantiates a new facebook graph api client exception.
	 */
    public OAuthException() {
        super();
    }

    /**
     * Instantiates a new facebook graph api client exception.
     * 
     * @param message the message
     */
    public OAuthException(String message) {
        super(message);
    }

    /**
     * Instantiates a new facebook graph api client exception.
     * 
     * @param cause the cause
     */
    public OAuthException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new facebook graph api client exception.
     * 
     * @param message the message
     * @param cause the cause
     */
    public OAuthException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new facebook graph api client exception.
     * 
     * @param message the message
     * @param statusCode the status code
     * @param errorCode the error code
     * @param timestamp the timestamp
     */
    public OAuthException(String message, int statusCode , String errorCode, Date timestamp) {
        super(message, statusCode, errorCode, timestamp);
    }
}
