/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum PostField.
 */
public enum PostField implements FieldEnum {
	
	/** The ID. */
	ID("id"),
	
	/** The FROM. */
	FROM("from"),
	
	/** The NAME. */
	NAME("name"),
	
	/** The DESCRIPTION. */
	DESCRIPTION("description"),
	
	/** The TO. */
	TO("to"),
	
	/** The LINK. */
	LINK("link"),
	
	/** The MESSAGE. */
	MESSAGE("message"),
	
	/** The PICTURE. */
	PICTURE("picture"),
	
	/** The CAPTION. */
	CAPTION("caption"),
	
	/** The SOURCE. */
	SOURCE("source"),
	
	/** The ICON. */
	ICON("icon"),
	
	/** The ATTRIBUTION. */
	ATTRIBUTION("attribution"),
	
	/** The ACTIONS. */
	ACTIONS("actions"),
	
	/** The LIKES. */
	LIKES("likes"),
	
	/** The CREATE d_ time. */
	CREATED_TIME("created_time"),
	
	/** The UPDATE d_ time. */
	UPDATED_TIME("updated_time");

    /** The Constant stringToEnum. */
	private static final Map<String, PostField> stringToEnum = new HashMap<String, PostField>();

	static { // Initialize map from constant name to enum constant
		for (PostField op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new post field.
     * 
     * @param value the value
     */
    PostField(String value) {
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
	 * @return the post field
	 */
	public static PostField fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
