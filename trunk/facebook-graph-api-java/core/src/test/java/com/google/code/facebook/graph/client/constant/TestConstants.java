/*
 * 
 */
package com.google.code.facebook.graph.client.constant;
import java.io.IOException;
import java.util.Properties;

/**
 * The Class TestConstants.
 */
public final class TestConstants {

    /** The Constant TEST_CONSTANTS_FILE. */
    private static final String TEST_CONSTANTS_FILE = "TestConstants.properties";

    /** The Constant testConstants. */
    private static final Properties testConstants = new Properties();

    static {
        try {
            testConstants.load(TestConstants.class.getResourceAsStream(TEST_CONSTANTS_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /** The Constant TEST_CONSUMER_KEY. */
    public static final String TEST_CONSUMER_KEY = testConstants.getProperty("com.google.code.facebook.graph.client.consumerKey");
    
    /** The Constant TEST_CONSUMER_SECRET. */
    public static final String TEST_CONSUMER_SECRET = testConstants.getProperty("com.google.code.facebook.graph.client.consumerSecret");
    
    /** The Constant TEST_CODE. */
    public static final String TEST_CODE = testConstants.getProperty("com.google.code.facebook.graph.client.code");
    
    /** The Constant TEST_ACCESS_TOKEN. */
    public static final String TEST_ACCESS_TOKEN = testConstants.getProperty("com.google.code.facebook.graph.client.accessToken");
    
    /** The Constant TEST_CALLBACK_URL. */
    public static final String TEST_CALLBACK_URL = testConstants.getProperty("com.google.code.facebook.graph.client.callbackUrl");
    
    /** The Constant TEST_APPLICATION_IDS. */
    public static final String TEST_APPLICATION_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.applicationIds");
    
    /** The Constant TEST_ALBUM_IDS. */
    public static final String TEST_ALBUM_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.albumIds");
    
    /** The Constant TEST_EVENT_IDS. */
    public static final String TEST_EVENT_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.eventIds");
    
    /** The Constant TEST_GROUP_IDS. */
    public static final String TEST_GROUP_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.groupIds");
    
    /** The Constant TEST_LINK_IDS. */
    public static final String TEST_LINK_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.linkIds");
    
    /** The Constant TEST_NOTE_IDS. */
    public static final String TEST_NOTE_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.noteIds");
    
    /** The Constant TEST_PAGE_IDS. */
    public static final String TEST_PAGE_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.pageIds");
    
    /** The Constant TEST_PHOTO_IDS. */
    public static final String TEST_PHOTO_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.photoIds");
    
    /** The Constant TEST_POST_IDS. */
    public static final String TEST_POST_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.postIds");
    
    /** The Constant TEST_STATUS_MESSAGE_IDS. */
    public static final String TEST_STATUS_MESSAGE_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.statusMessageIds");
    
    /** The Constant TEST_USER_IDS. */
    public static final String TEST_USER_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.userIds");
    
    /** The Constant TEST_VIDEO_IDS. */
    public static final String TEST_VIDEO_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.videoIds");
    
    /**
     * Instantiates a new test constants.
     */
    private TestConstants() {}
}
