/*
 * 
 */
package com.google.code.facebook.graph.client;


/**
 * The Interface FacebookAuthenticationClient.
 */
public interface FacebookAuthenticationClient extends FacebookCommunicationClient {

    /**
     * Sets the access token.
     * 
     * @param accessToken the new access token
     */
    public void setAccessToken(String accessToken);

    /**
     * Gets the access token.
     * 
     * @return the access token
     */
    public String getAccessToken();
}
