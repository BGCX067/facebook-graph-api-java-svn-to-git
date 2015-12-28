/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum Privacy.
 */
public enum SubscriptionType implements ValueEnum {
	
	/** The USER. */
	USER("user"),
	
	/** The PERMISSIONS. */
	PERMISSIONS("permissions"),
	
	/** The ERRORS. */
	ERRORS("errors");

    /** The Constant stringToEnum. */
	private static final Map<String, SubscriptionType> stringToEnum = new HashMap<String, SubscriptionType>();

	static { // Initialize map from constant name to enum constant
		for (SubscriptionType op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new privacy.
     * 
     * @param value the value
     */
    SubscriptionType(String value) {
        this.value = value;
    }

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.enumeration.ValueEnum#value()
	 */
	@Override
	public String value() {
		return value;
	}
	
	/**
	 * From value.
	 * 
	 * @param value the value
	 * 
	 * @return the privacy
	 */
	public static SubscriptionType fromValue(String value) {
		return stringToEnum.get(value);
	}
}
