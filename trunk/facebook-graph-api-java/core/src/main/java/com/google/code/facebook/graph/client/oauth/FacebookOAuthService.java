/*
 * 
 */
package com.google.code.facebook.graph.client.oauth;

import java.util.Set;

import com.google.code.facebook.graph.client.FacebookCommunicationClient;
import com.google.code.facebook.graph.model.enumeration.DialogFormFactor;
import com.google.code.facebook.graph.model.enumeration.Permission;

/**
 * The Interface FacebookOAuthService.
 */
public interface FacebookOAuthService extends FacebookCommunicationClient {

    /**
     * Gets the authorization url.
     * 
     * @param callBackUrl the call back url
     * 
     * @return the authorization url
     */
    public String getAuthorizationUrl(String callBackUrl);
    
    /**
     * Gets the authorization url.
     * 
     * @param callBackUrl the call back url
     * @param permissions the permissions
     * 
     * @return the authorization url
     */
    public String getAuthorizationUrl(String callBackUrl, Set<Permission> permissions);

    /**
     * Gets the authorization url.
     * 
     * @param callBackUrl the call back url
     * @param formFactor the form factor
     * 
     * @return the authorization url
     */
    public String getAuthorizationUrl(String callBackUrl, DialogFormFactor formFactor);

    /**
     * Gets the authorization url.
     * 
     * @param callBackUrl the call back url
     * @param permissions the permissions
     * @param formFactor the form factor
     * 
     * @return the authorization url
     */
    public String getAuthorizationUrl(String callBackUrl, Set<Permission> permissions, DialogFormFactor formFactor);

    /**
     * Gets the access token.
     * 
     * @param callBackUrl the call back url
     * @param code the code
     * 
     * @return the access token
     */
    public FacebookAccessToken getAccessToken(String callBackUrl, String code);
}
