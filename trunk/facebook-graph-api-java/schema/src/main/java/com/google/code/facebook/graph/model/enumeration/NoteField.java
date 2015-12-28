/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum NoteField.
 */
public enum NoteField implements FieldEnum {
	
	/** The ID. */
	ID("id"),
	
	/** The FROM. */
	FROM("from"),
	
	/** The SUBJECT. */
	SUBJECT("subject"),
	
	/** The MESSAGE. */
	MESSAGE("message"),
	
	/** The CREATE d_ time. */
	CREATED_TIME("created_time"),
	
	/** The UPDATE d_ time. */
	UPDATED_TIME("updated_time");

    /** The Constant stringToEnum. */
	private static final Map<String, NoteField> stringToEnum = new HashMap<String, NoteField>();

	static { // Initialize map from constant name to enum constant
		for (NoteField op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new note field.
     * 
     * @param value the value
     */
    NoteField(String value) {
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
	 * @return the note field
	 */
	public static NoteField fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
