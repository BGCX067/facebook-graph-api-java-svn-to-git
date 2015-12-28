/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum UserField.
 */
public enum UserField implements FieldEnum {
	
	/** The ID. */
	ID("id"),
	
	/** The FIRS t_ name. */
	FIRST_NAME("first_name"),
	
	/** The LAS t_ name. */
	LAST_NAME("last_name"),
	
	/** The NAME. */
	NAME("name"),
	
	/** The LINK. */
	LINK("link"),
	
	/** The ABOUT. */
	ABOUT("about"),
	
	/** The BIRTHDAY. */
	BIRTHDAY("birthday"),
	
	/** The WORK. */
	WORK("work"),
	
	/** The EDUCATION. */
	EDUCATION("education"),
	
	/** The EMAIL. */
	EMAIL("email"),
	
	/** The WEBSITE. */
	WEBSITE("website"),
	
	/** The CREATE d_ time. */
	CREATED_TIME("created_time"),
	
	/** The UPDATE d_ time. */
	UPDATED_TIME("updated_time");

    /** The Constant stringToEnum. */
	private static final Map<String, UserField> stringToEnum = new HashMap<String, UserField>();

	static { // Initialize map from constant name to enum constant
		for (UserField op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new user field.
     * 
     * @param value the value
     */
    UserField(String value) {
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
	 * @return the user field
	 */
	public static UserField fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
