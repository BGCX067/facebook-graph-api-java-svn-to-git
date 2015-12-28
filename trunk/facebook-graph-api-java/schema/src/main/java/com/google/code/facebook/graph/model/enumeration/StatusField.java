/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum StatusField.
 */
public enum StatusField implements FieldEnum {
	
	/** The ID. */
	ID("id"),
	
	/** The FROM. */
	FROM("from"),
	
	/** The MESSAGE. */
	MESSAGE("message"),
	
	/** The UPDATE d_ time. */
	UPDATED_TIME("updated_time");

    /** The Constant stringToEnum. */
	private static final Map<String, StatusField> stringToEnum = new HashMap<String, StatusField>();

	static { // Initialize map from constant name to enum constant
		for (StatusField op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new status field.
     * 
     * @param value the value
     */
    StatusField(String value) {
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
	 * @return the status field
	 */
	public static StatusField fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
