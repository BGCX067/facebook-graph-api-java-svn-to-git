/**
 *
 */
package com.google.code.facebook.graph.sna.constant;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import com.google.code.facebook.graph.model.enumeration.ConnectionEnum;

/**
 * The Class ApplicationConstants.
 *
 * @author Nabeel Mukhtar
 */
public final class ConnectionWeights {

    /** The Constant APP_CONSTANTS_FILE. */
    private static final String CONNECTION_WEIGHTS_FILE = "ConnectionWeights.properties";

    /** The static logger. */
    private static final Logger LOG = Logger.getLogger(ConnectionWeights.class.getCanonicalName());
    
    /** The Constant applicationConstants. */
    private static final Properties connectionWeights = new Properties();

    static {
        try {
            connectionWeights.load(
                ConnectionWeights.class.getResourceAsStream(CONNECTION_WEIGHTS_FILE));
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "An error occurred while loading properties.", e);
        }
    }
    
    /**
     * Instantiates a new application constants.
     */
    private ConnectionWeights() {}
    
    /**
     * Get connection weight.
     */
    public static double getConnectionWeight(ConnectionEnum connection) {
        return getDoubleProperty(connection.getClass().getName() + "." + connection.value(), connection.weight());
    }
    
    /**
     * Get property as int.
     */
    public static String getProperty(String key) {
        return connectionWeights.getProperty(key);
    }

    /**
     * Get property as int.
     */
    public static int getIntProperty(String key, int defaultValue) {
        String property = connectionWeights.getProperty(key);

        if (isNullOrEmpty(property)) {
            return defaultValue;
        } else {
            return Integer.parseInt(property);
        }
    }

    /**
     * Get property as boolean.
     */
    public static boolean getBooleanProperty(String key, boolean defaultValue) {
        String property = connectionWeights.getProperty(key);

        if (isNullOrEmpty(property)) {
            return defaultValue;
        } else {
            return Boolean.parseBoolean(property);
        }
    }

    /**
     * Get property as double.
     */
    public static double getDoubleProperty(String key, double defaultValue) {
        String property = connectionWeights.getProperty(key);

        if (isNullOrEmpty(property)) {
            return defaultValue;
        } else {
            return Double.parseDouble(property);
        }
    }

    /**
     * Get property as long.
     */
    public static long getLongProperty(String key, long defaultValue) {
        String property = connectionWeights.getProperty(key);

        if (isNullOrEmpty(property)) {
            return defaultValue;
        } else {
            return Long.parseLong(property);
        }
    }
    
    /**
     * Get property as Pattern.
     */
    public static Pattern getPatternProperty(String key) {
        String property = connectionWeights.getProperty(key);

        if (isNullOrEmpty(property)) {
            return null;
        } else {
            return Pattern.compile(property);
        }
    }

    /**
     * Get property as long.
     */
    private static boolean isNullOrEmpty(String s) {
        return ((s == null) || s.length() == 0);
    }
}
