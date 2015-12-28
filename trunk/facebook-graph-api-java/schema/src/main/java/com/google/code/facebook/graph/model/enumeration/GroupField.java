/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum GroupField.
 */
public enum GroupField implements FieldEnum {
	
	/** The ID. */
	ID("id"),
	
	/** The OWNER. */
	OWNER("owner"),
	
	/** The NAME. */
	NAME("name"),
	
	/** The DESCRIPTION. */
	DESCRIPTION("description"),
	
	/** The LINK. */
	LINK("link"),
	
	/** The VENUE. */
	VENUE("venue"),
	
	/** The PRIVACY. */
	PRIVACY("privacy"),
	
	/** The UPDATE d_ time. */
	UPDATED_TIME("updated_time");

    /** The Constant stringToEnum. */
	private static final Map<String, GroupField> stringToEnum = new HashMap<String, GroupField>();

	static { // Initialize map from constant name to enum constant
		for (GroupField op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new group field.
     * 
     * @param value the value
     */
    GroupField(String value) {
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
	 * @return the group field
	 */
	public static GroupField fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
