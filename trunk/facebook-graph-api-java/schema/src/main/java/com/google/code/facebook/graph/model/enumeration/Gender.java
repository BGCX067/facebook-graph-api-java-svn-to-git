/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum Privacy.
 */
public enum Gender implements ValueEnum {
	
	/** The MALE. */
	MALE("male"),
	
	/** The CLOSED. */
	FEMALE("female"),
	
	/** The NO t_ everyone. */
	NOT_SPECIFIED("unspecified");

    /** The Constant stringToEnum. */
	private static final Map<String, Gender> stringToEnum = new HashMap<String, Gender>();

	static { // Initialize map from constant name to enum constant
		for (Gender op : values()) {
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
    Gender(String value) {
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
	public static Gender fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
