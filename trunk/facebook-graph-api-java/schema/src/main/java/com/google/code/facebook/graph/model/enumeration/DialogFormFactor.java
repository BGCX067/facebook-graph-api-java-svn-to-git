/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum DialogFormFactor.
 */
public enum DialogFormFactor implements ValueEnum {
	
	/** The PAGE. */
	PAGE("page"),
	
	/** The POPUP. */
	POPUP("popup"),
	
	/** The WAP. */
	WAP("wap"),
	
	/** The TOUCH. */
	TOUCH("touch");

    /** The Constant stringToEnum. */
	private static final Map<String, DialogFormFactor> stringToEnum = new HashMap<String, DialogFormFactor>();

	static { // Initialize map from constant name to enum constant
		for (DialogFormFactor op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new dialog form factor.
     * 
     * @param value the value
     */
    DialogFormFactor(String value) {
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
	 * @return the dialog form factor
	 */
	public static DialogFormFactor fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
