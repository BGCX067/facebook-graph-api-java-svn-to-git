/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum EventField.
 */
public enum EventField implements FieldEnum {
	
	/** The ID. */
	ID("id"),
	
	/** The OWNER. */
	OWNER("owner"),
	
	/** The NAME. */
	NAME("name"),
	
	/** The DESCRIPTION. */
	DESCRIPTION("description"),
	
	/** The STAR t_ time. */
	START_TIME("start_time"),
	
	/** The EN d_ time. */
	END_TIME("end_time"),
	
	/** The LOCATION. */
	LOCATION("location"),
	
	/** The VENUE. */
	VENUE("venue"),
	
	/** The PRIVACY. */
	PRIVACY("privacy"),
	
	/** The UPDATE d_ time. */
	UPDATED_TIME("updated_time");

    /** The Constant stringToEnum. */
	private static final Map<String, EventField> stringToEnum = new HashMap<String, EventField>();

	static { // Initialize map from constant name to enum constant
		for (EventField op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new event field.
     * 
     * @param value the value
     */
    EventField(String value) {
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
	 * @return the event field
	 */
	public static EventField fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
