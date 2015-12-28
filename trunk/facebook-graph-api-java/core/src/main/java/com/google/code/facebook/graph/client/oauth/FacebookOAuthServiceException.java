/*
 * 
 */
package com.google.code.facebook.graph.client.oauth;

/**
 * The Class FacebookOAuthServiceException.
 */
public class FacebookOAuthServiceException extends RuntimeException {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4345556572105572685L;

	/**
	 * Instantiates a new facebook o auth service exception.
	 */
    public FacebookOAuthServiceException() {
        super();
    }

    /**
     * Instantiates a new facebook o auth service exception.
     * 
     * @param message the message
     */
    public FacebookOAuthServiceException(String message) {
        super(message);
    }

    /**
     * Instantiates a new facebook o auth service exception.
     * 
     * @param cause the cause
     */
    public FacebookOAuthServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new facebook o auth service exception.
     * 
     * @param message the message
     * @param cause the cause
     */
    public FacebookOAuthServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
