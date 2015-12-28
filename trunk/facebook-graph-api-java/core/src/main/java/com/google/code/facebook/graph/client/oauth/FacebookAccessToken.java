/*
 * 
 */
package com.google.code.facebook.graph.client.oauth;

/**
 * The Class FacebookApiConsumer.
 */
public class FacebookAccessToken {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -508151196474695320L;
	
	private String accessToken;
	private int duration;
	
	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}
	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
