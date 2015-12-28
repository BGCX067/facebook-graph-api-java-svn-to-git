/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum PhotoField.
 */
public enum PhotoField implements FieldEnum {
	
	/** The ID. */
	ID("id"),
	
	/** The FROM. */
	FROM("from"),
	
	/** The NAME. */
	NAME("name"),
	
	/** The TAGS. */
	TAGS("tags"),
	
	/** The PICTURE. */
	PICTURE("picture"),
	
	/** The SOURCE. */
	SOURCE("source"),
	
	/** The HEIGHT. */
	HEIGHT("height"),
	
	/** The WIDTH. */
	WIDTH("width"),
	
	/** The LINK. */
	LINK("link"),
	
	/** The CREATE d_ time. */
	CREATED_TIME("created_time"),
	
	/** The UPDATE d_ time. */
	UPDATED_TIME("updated_time");

    /** The Constant stringToEnum. */
	private static final Map<String, PhotoField> stringToEnum = new HashMap<String, PhotoField>();

	static { // Initialize map from constant name to enum constant
		for (PhotoField op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new photo field.
     * 
     * @param value the value
     */
    PhotoField(String value) {
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
	 * @return the photo field
	 */
	public static PhotoField fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
