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
 * The Enum GroupConnection.
 */
public enum GroupConnection implements ConnectionEnum {
	
	/** The FEED. */
	FEED("feed", Post.class),
	
	/** The MEMBERS. */
	MEMBERS("members", User.class);
//	PICTURE("picture");

    /** The Constant stringToEnum. */
	private static final Map<String, GroupConnection> stringToEnum = new HashMap<String, GroupConnection>();

    /** The Constant weightsMap. */
	private static final Map<GroupConnection, Double> weightsMap = new EnumMap<GroupConnection, Double>(GroupConnection.class);
	
	static { // Initialize map from constant name to enum constant
		for (GroupConnection op : values()) {
			stringToEnum.put(op.value(), op);
			weightsMap.put(op, 1.0);
		}
	}
	
    /** The value. */
    private final String value;
    
    /** The type. */
    private final Class<? extends Entity<?, ?>> type;
    
    /**
     * Instantiates a new group connection.
     * 
     * @param value the value
     * @param type the type
     */
    GroupConnection(String value, Class<? extends Entity<?, ?>> type) {
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
	 * @return the group connection
	 */
	public static GroupConnection fromValue(String value) {
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
