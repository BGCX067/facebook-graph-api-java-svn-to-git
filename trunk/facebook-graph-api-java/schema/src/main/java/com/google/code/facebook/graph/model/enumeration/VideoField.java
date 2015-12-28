/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum VideoField.
 */
public enum VideoField implements FieldEnum {
	
	/** The ID. */
	ID("id"),
	
	/** The FROM. */
	FROM("from"),
	
	/** The MESSAGE. */
	MESSAGE("message"),
	
	/** The DESCRIPTION. */
	DESCRIPTION("description"),
	
	/** The LENGTH. */
	LENGTH("length"),
	
	/** The CREATE d_ time. */
	CREATED_TIME("created_time"),
	
	/** The UPDATE d_ time. */
	UPDATED_TIME("updated_time");

    /** The Constant stringToEnum. */
	private static final Map<String, VideoField> stringToEnum = new HashMap<String, VideoField>();

	static { // Initialize map from constant name to enum constant
		for (VideoField op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new video field.
     * 
     * @param value the value
     */
    VideoField(String value) {
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
	 * @return the video field
	 */
	public static VideoField fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
