/*
 * 
 */
package com.google.code.facebook.graph.client.constant;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class ParameterNames.
 */
public final class ParameterNames {

    /** The Constant PARAMETER_NAMES_FILE. */
    private static final String PARAMETER_NAMES_FILE = "ParameterNames.properties";

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(ParameterNames.class.getCanonicalName());
    
    /** The Constant parameterNames. */
    private static final Properties parameterNames = new Properties();

    static {
        try {
            parameterNames.load(
                ParameterNames.class.getResourceAsStream(PARAMETER_NAMES_FILE));
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "An error occurred while loading parameter names.", e);
        }
    }
    
    /** The Constant ACCESS_TOKEN. */
    public static final String ACCESS_TOKEN = getParameterName("com.google.code.facebook.graph.client.accessToken");
    
    /** The Constant LIMIT. */
    public static final String LIMIT = getParameterName("com.google.code.facebook.graph.client.limit");
    
    /** The Constant OFFSET. */
    public static final String OFFSET = getParameterName("com.google.code.facebook.graph.client.offset");
    
    /** The Constant SINCE. */
    public static final String SINCE = getParameterName("com.google.code.facebook.graph.client.since");
    
    /** The Constant UNTIL. */
    public static final String UNTIL = getParameterName("com.google.code.facebook.graph.client.until");
    
    /** The Constant CLIENT_ID. */
    public static final String CLIENT_ID = getParameterName("com.google.code.facebook.graph.client.clientId");
    
    /** The Constant CLIENT_SECRET. */
    public static final String CLIENT_SECRET = getParameterName("com.google.code.facebook.graph.client.clientSecret");
    
    /** The Constant REDIRECT_URI. */
    public static final String REDIRECT_URI = getParameterName("com.google.code.facebook.graph.client.redirectUri");
    
    /** The Constant CODE. */
    public static final String CODE = getParameterName("com.google.code.facebook.graph.client.code");
    
    /** The Constant SCOPE. */
    public static final String SCOPE = getParameterName("com.google.code.facebook.graph.client.scope");
    
    /** The Constant DISPLAY. */
    public static final String DISPLAY = getParameterName("com.google.code.facebook.graph.client.display");
    
    /** The Constant METADATA. */
    public static final String METADATA = getParameterName("com.google.code.facebook.graph.client.metadata");
    
    /** The Constant TYPE. */
    public static final String TYPE = getParameterName("com.google.code.facebook.graph.client.type");
    
    /** The Constant QUERY. */
    public static final String QUERY = getParameterName("com.google.code.facebook.graph.client.query");
    
    /** The Constant IDS. */
    public static final String IDS = getParameterName("com.google.code.facebook.graph.client.ids");
    
    /** The Constant FIELDS. */
    public static final String FIELDS = getParameterName("com.google.code.facebook.graph.client.fields");
    
    /** The Constant MESSAGE. */
    public static final String MESSAGE = getParameterName("com.google.code.facebook.graph.client.message");
    
    /** The Constant PICTURE. */
    public static final String PICTURE = getParameterName("com.google.code.facebook.graph.client.picture");
    
    /** The Constant LINK. */
    public static final String LINK = getParameterName("com.google.code.facebook.graph.client.link");
    
    /** The Constant NAME. */
    public static final String NAME = getParameterName("com.google.code.facebook.graph.client.name");
    
    /** The Constant DESCRIPTION. */
    public static final String DESCRIPTION = getParameterName("com.google.code.facebook.graph.client.description");
    
    /** The Constant SUBJECT. */
    public static final String SUBJECT = getParameterName("com.google.code.facebook.graph.client.subject");
    
    /** The Constant START_TIME. */
    public static final String START_TIME = getParameterName("com.google.code.facebook.graph.client.startTime");
    
    /** The Constant END_TIME. */
    public static final String END_TIME = getParameterName("com.google.code.facebook.graph.client.endTime");
    
    /** The Constant HUB_MODE. */
    public static final String HUB_MODE = getParameterName("com.google.code.facebook.graph.client.hub.mode");
    
    /** The Constant HUB_CHALLENGE. */
    public static final String HUB_CHALLENGE = getParameterName("com.google.code.facebook.graph.client.hub.challenge");
    
    /** The Constant HUB_VERIFY_TOKEN. */
    public static final String HUB_VERIFY_TOKEN = getParameterName("com.google.code.facebook.graph.client.hub.verifyToken");
    
    /** The Constant OBJECT. */
    public static final String OBJECT = getParameterName("com.google.code.facebook.graph.client.object");
    
    /** The Constant CALLBACK_URL. */
    public static final String CALLBACK_URL = getParameterName("com.google.code.facebook.graph.client.callbackUrl");
    
    /** The Constant VERIFY_TOKEN. */
    public static final String VERIFY_TOKEN = getParameterName("com.google.code.facebook.graph.client.verifyToken");
    
    /**
     * Instantiates a new parameter names.
     */
    private ParameterNames() {}
    
    /**
     * Gets the parameter name.
     * 
     * @param key the key
     * 
     * @return the parameter name
     */
    public static String getParameterName(String key) {
        return parameterNames.getProperty(key);
    }
}
