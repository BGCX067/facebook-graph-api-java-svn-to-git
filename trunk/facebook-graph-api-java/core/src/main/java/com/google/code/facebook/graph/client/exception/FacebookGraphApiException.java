/*
 * 
 */
package com.google.code.facebook.graph.client.exception;

import java.util.Date;

/**
 * The Class FacebookGraphApiClientException.
 */
public class FacebookGraphApiException extends RuntimeException {
	
	/** The status code. */
	private int statusCode;
	
	/** The error code. */
	private String errorCode;
	
	/** The timestamp. */
	private Date timestamp = new Date();

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4345556572105572685L;

	/**
	 * Instantiates a new facebook graph api client exception.
	 */
    public FacebookGraphApiException() {
        super();
    }

    /**
     * Instantiates a new facebook graph api client exception.
     * 
     * @param message the message
     */
    public FacebookGraphApiException(String message) {
        super(message);
    }

    /**
     * Instantiates a new facebook graph api client exception.
     * 
     * @param cause the cause
     */
    public FacebookGraphApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new facebook graph api client exception.
     * 
     * @param message the message
     * @param cause the cause
     */
    public FacebookGraphApiException(String message, Throwable cause) {
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
    public FacebookGraphApiException(String message, int statusCode , String errorCode, Date timestamp) {
        super(message);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.timestamp = timestamp;
    }
    
	/**
	 * Gets the status code.
	 * 
	 * @return the status code
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets the status code.
	 * 
	 * @param statusCode the new status code
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Gets the error code.
	 * 
	 * @return the error code
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 * 
	 * @param errorCode the new error code
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Gets the timestamp.
	 * 
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 * 
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
