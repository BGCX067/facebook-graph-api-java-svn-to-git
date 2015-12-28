/*
 * 
 */
package com.google.code.facebook.graph.client.exception;

import java.util.Date;

/**
 * The Class FacebookGraphApiClientException.
 */
public class QueryParseException extends FacebookGraphApiException {
	
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4345556572105572685L;

	/**
	 * Instantiates a new facebook graph api client exception.
	 */
    public QueryParseException() {
        super();
    }

    /**
     * Instantiates a new facebook graph api client exception.
     * 
     * @param message the message
     */
    public QueryParseException(String message) {
        super(message);
    }

    /**
     * Instantiates a new facebook graph api client exception.
     * 
     * @param cause the cause
     */
    public QueryParseException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new facebook graph api client exception.
     * 
     * @param message the message
     * @param cause the cause
     */
    public QueryParseException(String message, Throwable cause) {
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
    public QueryParseException(String message, int statusCode , String errorCode, Date timestamp) {
        super(message, statusCode, errorCode, timestamp);
    }
}
