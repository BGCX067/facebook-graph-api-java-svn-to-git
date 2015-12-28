/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum AlbumField.
 */
public enum AlbumField implements FieldEnum {
	
	/** The ID. */
	ID("id"),
	
	/** The FROM. */
	FROM("from"),
	
	/** The NAME. */
	NAME("name"),
	
	/** The DESCRIPTION. */
	DESCRIPTION("description"),
	
	/** The LOCATION. */
	LOCATION("location"),
	
	/** The LINK. */
	LINK("link"),
	
	/** The COUNT. */
	COUNT("count"),
	
	/** The CREATE d_ time. */
	CREATED_TIME("created_time"),
	
	/** The UPDATE d_ time. */
	UPDATED_TIME("updated_time");

    /** The Constant stringToEnum. */
	private static final Map<String, AlbumField> stringToEnum = new HashMap<String, AlbumField>();

	static { // Initialize map from constant name to enum constant
		for (AlbumField op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new album field.
     * 
     * @param value the value
     */
    AlbumField(String value) {
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
	 * @return the album field
	 */
	public static AlbumField fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
