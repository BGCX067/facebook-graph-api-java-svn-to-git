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
import com.google.code.facebook.graph.model.Page;
import com.google.code.facebook.graph.model.Photo;
import com.google.code.facebook.graph.model.Post;
import com.google.code.facebook.graph.model.Status;
import com.google.code.facebook.graph.model.Stream;
import com.google.code.facebook.graph.model.User;
import com.google.code.facebook.graph.model.Video;

/**
 * The Enum UserConnection.
 */
@SuppressWarnings("unchecked")
public enum UserConnection implements ConnectionEnum {
	
	/** The HOME. */
	HOME("home", Post.class),
	
	/** The FEED. */
	FEED("feed", Post.class),
	
	/** The TAGGED. */
	TAGGED("tagged", Stream.class),
	
	/** The POSTS. */
	POSTS("posts", Post.class),
//	PICTURE("picture"),
	/** The FRIENDS. */
	FRIENDS("friends", User.class),
	
	/** The FAMILY. */
	FAMILY("family", User.class),
	
	/** The ACTIVITIES. */
	ACTIVITIES("activities", Page.class),
	
	/** The INTERESTS. */
	INTERESTS("interests", Page.class),
	
	/** The MUSIC. */
	MUSIC("music", Page.class),
	
	/** The BOOKS. */
	BOOKS("books", Page.class),
	
	/** The MOVIES. */
	MOVIES("movies", Page.class),
	
	/** The TELEVISION. */
	TELEVISION("television", Page.class),
	
	/** The LIKES. */
	LIKES("likes", Page.class),
	
	/** The PHOTOS. */
	PHOTOS("photos", Photo.class),
	
	/** The ALBUMS. */
	ALBUMS("albums", Album.class),
	
	/** The VIDEOS. */
	VIDEOS("videos", Video.class),
	
	/** The GROUPS. */
	GROUPS("groups", Group.class),
	
	/** The STATUSES. */
	STATUSES("statuses", Status.class),
	
	/** The LINKS. */
	LINKS("links", Link.class),
	
	/** The NOTES. */
	NOTES("notes", Note.class),
	
	/** The EVENTS. */
	EVENTS("events", Event.class),
	
	/** The INBOX. */
	INBOX("inbox", Post.class),
	
	/** The OUTBOX. */
	OUTBOX("outbox", Post.class),
	
	/** The UPDATES. */
	UPDATES("updates", Post.class);

    /** The Constant stringToEnum. */
	private static final Map<String, UserConnection> stringToEnum = new HashMap<String, UserConnection>();

    /** The Constant weightsMap. */
	private static final Map<UserConnection, Double> weightsMap = new EnumMap<UserConnection, Double>(UserConnection.class);
	
	static { // Initialize map from constant name to enum constant
		for (UserConnection op : values()) {
			stringToEnum.put(op.value(), op);
			weightsMap.put(op, 1.0);
		}
	}
	
    /** The value. */
    private final String value;
    
    /** The type. */
    private final Class<? extends Entity> type;
    
    /**
     * Instantiates a new user connection.
     * 
     * @param value the value
     * @param type the type
     */
    UserConnection(String value, Class<? extends Entity> type) {
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
	 * @return the user connection
	 */
	public static UserConnection fromValue(String value) {
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
