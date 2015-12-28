/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum Privacy.
 */
public enum Privacy implements ValueEnum {
	
	/** The OPEN. */
	OPEN("OPEN"),
	
	/** The CLOSED. */
	CLOSED("CLOSED"),
	
	/** The SECRET. */
	SECRET("SECRET"),
	
	/** The FRIEND s_ o f_ friends. */
	FRIENDS_OF_FRIENDS("friends-of-friends"),
	
	/** The NO t_ everyone. */
	NOT_EVERYONE("NOT_EVERYONE");

    /** The Constant stringToEnum. */
	private static final Map<String, Privacy> stringToEnum = new HashMap<String, Privacy>();

	static { // Initialize map from constant name to enum constant
		for (Privacy op : values()) {
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
    Privacy(String value) {
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
	public static Privacy fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
