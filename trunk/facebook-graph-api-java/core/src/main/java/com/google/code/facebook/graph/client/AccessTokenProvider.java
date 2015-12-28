/*
 * 
 */
package com.google.code.facebook.graph.client;

/**
 * The Interface AccessTokenProvider.
 */
public interface AccessTokenProvider {

	/**
	 * Gets the access token.
	 * 
	 * @param id the id
	 * 
	 * @return the access token
	 */
	public String getAccessToken(String id);
}
