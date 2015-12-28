/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum LinkField.
 */
public enum LinkField implements FieldEnum {
	
	/** The ID. */
	ID("id"),
	
	/** The FROM. */
	FROM("from"),
	
	/** The LINK. */
	LINK("link"),
	
	/** The MESSAGE. */
	MESSAGE("message"),
	
	/** The UPDATE d_ time. */
	UPDATED_TIME("updated_time");

    /** The Constant stringToEnum. */
	private static final Map<String, LinkField> stringToEnum = new HashMap<String, LinkField>();

	static { // Initialize map from constant name to enum constant
		for (LinkField op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new link field.
     * 
     * @param value the value
     */
    LinkField(String value) {
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
	 * @return the link field
	 */
	public static LinkField fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
