/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum PageField.
 */
public enum PageField implements FieldEnum {
	
	/** The ID. */
	ID("id"),
	
	/** The NAME. */
	NAME("name"),
	
	/** The CATEGORY. */
	CATEGORY("category");

    /** The Constant stringToEnum. */
	private static final Map<String, PageField> stringToEnum = new HashMap<String, PageField>();

	static { // Initialize map from constant name to enum constant
		for (PageField op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new page field.
     * 
     * @param value the value
     */
    PageField(String value) {
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
	 * @return the page field
	 */
	public static PageField fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
