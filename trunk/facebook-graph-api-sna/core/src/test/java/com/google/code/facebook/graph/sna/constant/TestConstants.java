/**
 *
 */
package com.google.code.facebook.graph.sna.constant;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Nabeel Mukhtar
 *
 */
public final class TestConstants {

    /** Field description */
    private static final String TEST_CONSTANTS_FILE = "TestConstants.properties";

    /** Field description */
    private static final Properties testConstants = new Properties();

    static {
        try {
            testConstants.load(TestConstants.class.getResourceAsStream(TEST_CONSTANTS_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static final String TEST_CONSUMER_KEY = testConstants.getProperty("com.google.code.facebook.graph.client.consumerKey");
    public static final String TEST_CONSUMER_SECRET = testConstants.getProperty("com.google.code.facebook.graph.client.consumerSecret");
    public static final String TEST_CODE = testConstants.getProperty("com.google.code.facebook.graph.client.code");
    public static final String TEST_ACCESS_TOKEN = testConstants.getProperty("com.google.code.facebook.graph.client.accessToken");
    public static final String TEST_CALLBACK_URL = testConstants.getProperty("com.google.code.facebook.graph.client.callbackUrl");
    
    public static final String TEST_ALBUM_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.albumIds");
    public static final String TEST_EVENT_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.eventIds");
    public static final String TEST_GROUP_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.groupIds");
    public static final String TEST_LINK_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.linkIds");
    public static final String TEST_NOTE_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.noteIds");
    public static final String TEST_PAGE_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.pageIds");
    public static final String TEST_PHOTO_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.photoIds");
    public static final String TEST_POST_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.postIds");
    public static final String TEST_STATUS_MESSAGE_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.statusMessageIds");
    public static final String TEST_USER_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.userIds");
    public static final String TEST_VIDEO_IDS = testConstants.getProperty("com.google.code.facebook.graph.client.videoIds");
    /**
     * Constructs ...
     *
     */
    private TestConstants() {}
}
