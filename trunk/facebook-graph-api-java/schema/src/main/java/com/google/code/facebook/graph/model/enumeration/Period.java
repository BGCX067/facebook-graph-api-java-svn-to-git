/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum Privacy.
 */
public enum Period implements ValueEnum {
	
	/** The NO t_ everyone. */
	DAY("day");

    /** The Constant stringToEnum. */
	private static final Map<String, Period> stringToEnum = new HashMap<String, Period>();

	static { // Initialize map from constant name to enum constant
		for (Period op : values()) {
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
    Period(String value) {
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
	public static Period fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
