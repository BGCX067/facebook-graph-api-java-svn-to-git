/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import com.google.code.facebook.graph.model.Album;
import com.google.code.facebook.graph.model.Entity;
import com.google.code.facebook.graph.model.Event;
import com.google.code.facebook.graph.model.Group;
import com.google.code.facebook.graph.model.Link;
import com.google.code.facebook.graph.model.Note;
import com.google.code.facebook.graph.model.Photo;
import com.google.code.facebook.graph.model.Post;
import com.google.code.facebook.graph.model.Status;
import com.google.code.facebook.graph.model.Stream;
import com.google.code.facebook.graph.model.Video;

/**
 * The Enum PageConnection.
 */
@SuppressWarnings("unchecked")
public enum PageConnection implements ConnectionEnum {
	
	/** The FEED. */
	FEED("feed", Post.class),
//	PICTURE("picture"),
	/** The TAGGED. */
TAGGED("tagged", Stream.class),
	
	/** The LINKS. */
	LINKS("links", Link.class),
	
	/** The PHOTOS. */
	PHOTOS("photos", Photo.class),
	
	/** The GROUPS. */
	GROUPS("groups", Group.class),
	
	/** The ALBUMS. */
	ALBUMS("albums", Album.class),
	
	/** The STATUSES. */
	STATUSES("statuses", Status.class),
	
	/** The VIDEOS. */
	VIDEOS("videos", Video.class),
	
	/** The NOTES. */
	NOTES("notes", Note.class),
	
	/** The POSTS. */
	POSTS("posts", Post.class),
	
	/** The EVENTS. */
	EVENTS("events", Event.class);

    /** The Constant stringToEnum. */
	private static final Map<String, PageConnection> stringToEnum = new HashMap<String, PageConnection>();

    /** The Constant weightsMap. */
	private static final Map<PageConnection, Double> weightsMap = new EnumMap<PageConnection, Double>(PageConnection.class);
	
	static { // Initialize map from constant name to enum constant
		for (PageConnection op : values()) {
			stringToEnum.put(op.value(), op);
			weightsMap.put(op, 1.0);
		}
	}
	
    /** The value. */
    private final String value;
    
    /** The type. */
	private final Class<? extends Entity> type;
    
    /**
     * Instantiates a new page connection.
     * 
     * @param value the value
     * @param type the type
     */
    PageConnection(String value, Class<? extends Entity> type) {
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
	public Class<? extends Entity> type() {
		return type;
	}
	
	/**
	 * From value.
	 * 
	 * @param value the value
	 * 
	 * @return the page connection
	 */
	public static PageConnection fromValue(String value) {
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
