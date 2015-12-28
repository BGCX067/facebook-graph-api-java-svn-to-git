/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum PictureType.
 */
public enum PictureType implements ValueEnum {
	
	/** The THUMBNAIL. */
	THUMBNAIL("thumbnail"),
	
	/** The SMALL. */
	SMALL("small"),
	
	/** The NORMAL. */
	NORMAL("normal"),
	
	/** The ALBUM. */
	ALBUM("album"),
	
	/** The LARGE. */
	LARGE("large"),
	
	/** The SQUARE. */
	SQUARE("square");

    /** The Constant stringToEnum. */
	private static final Map<String, PictureType> stringToEnum = new HashMap<String, PictureType>();

	static { // Initialize map from constant name to enum constant
		for (PictureType op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new picture type.
     * 
     * @param value the value
     */
    PictureType(String value) {
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
	 * @return the picture type
	 */
	public static PictureType fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
