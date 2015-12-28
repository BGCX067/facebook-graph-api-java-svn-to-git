/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import com.google.code.facebook.graph.model.Entity;
import com.google.code.facebook.graph.model.Photo;
import com.google.code.facebook.graph.model.Post;

/**
 * The Enum AlbumConnection.
 */
public enum AlbumConnection implements ConnectionEnum {
	
	/** The PHOTOS. */
	PHOTOS("photos", Photo.class),
	
	/** The COMMENTS. */
	COMMENTS("comments", Post.class);

    /** The Constant stringToEnum. */
	private static final Map<String, AlbumConnection> stringToEnum = new HashMap<String, AlbumConnection>();

    /** The Constant weightsMap. */
	private static final Map<AlbumConnection, Double> weightsMap = new EnumMap<AlbumConnection, Double>(AlbumConnection.class);
	
	static { // Initialize map from constant name to enum constant
		for (AlbumConnection op : values()) {
			stringToEnum.put(op.value(), op);
	        weightsMap.put(op, 1.0);
		}
	}
	
    /** The value. */
    private final String value;
    
    /** The type. */
    private final Class<? extends Entity<?, ?>> type;
    
    /**
     * Instantiates a new album connection.
     * 
     * @param value the value
     * @param type the type
     */
    AlbumConnection(String value, Class<? extends Entity<?, ?>> type) {
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
	 * @return the album connection
	 */
	public static AlbumConnection fromValue(String value) {
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
