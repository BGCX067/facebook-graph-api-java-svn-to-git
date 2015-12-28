/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import com.google.code.facebook.graph.model.Entity;
import com.google.code.facebook.graph.model.Post;
import com.google.code.facebook.graph.model.User;

/**
 * The Enum EventConnection.
 */
public enum EventConnection implements ConnectionEnum {
	
	/** The FEED. */
	FEED("feed", Post.class),
	
	/** The NOREPLY. */
	NOREPLY("noreply", User.class),
	
	/** The MAYBE. */
	MAYBE("maybe", User.class),
	
	/** The INVITED. */
	INVITED("invited", User.class),
	
	/** The ATTENDING. */
	ATTENDING("attending", User.class),
	
	/** The DECLINED. */
	DECLINED("declined", User.class);
//	PICTURE("picture");

    /** The Constant stringToEnum. */
	private static final Map<String, EventConnection> stringToEnum = new HashMap<String, EventConnection>();

    /** The Constant weightsMap. */
	private static final Map<EventConnection, Double> weightsMap = new EnumMap<EventConnection, Double>(EventConnection.class);
	
	static { // Initialize map from constant name to enum constant
		for (EventConnection op : values()) {
			stringToEnum.put(op.value(), op);
			weightsMap.put(op, 1.0);
		}
	}
	
    /** The value. */
    private final String value;

    /** The type. */
    private final Class<? extends Entity<?, ?>> type;
    
    /**
     * Instantiates a new event connection.
     * 
     * @param value the value
     * @param type the type
     */
    EventConnection(String value, Class<? extends Entity<?, ?>> type) {
        this.value = value;
        this.type = type;
    }

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.enumeration.ValueEnum#value()
	 */
	@Override
	public String value() {
		return value;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.enumeration.TypeEnum#type()
	 */
	@Override
	public Class<? extends Entity<?, ?>> type() {
		return type;
	}
	
	/**
	 * From value.
	 * 
	 * @param value the value
	 * 
	 * @return the event connection
	 */
	public static EventConnection fromValue(String value) {
		return stringToEnum.get(value);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.enumeration.WeightedEnum#weight()
	 */
	@Override
	public Double weight() {
		return weightsMap.get(this);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.enumeration.WeightedEnum#weight(java.lang.Object)
	 */
	@Override
	public void weight(Double weight) {
		weightsMap.put(this, weight);
	}
}
