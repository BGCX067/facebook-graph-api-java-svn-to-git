/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.EnumSet;

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
import com.google.code.facebook.graph.model.User;
import com.google.code.facebook.graph.model.Video;

/**
 * The Enum ObjectType.
 */
public enum ObjectType implements ValueEnum, TypeEnum {
	
	/** The ALBUM. */
	ALBUM("album", Album.class, EnumSet.allOf(AlbumField.class), EnumSet.allOf(AlbumConnection.class), EnumSet.allOf(AlbumLink.class)),
	
	/** The EVENT. */
	EVENT("event", Event.class, EnumSet.allOf(EventField.class), EnumSet.allOf(EventConnection.class), EnumSet.allOf(EventLink.class)),
	
	/** The GROUP. */
	GROUP("group", Group.class, EnumSet.allOf(GroupField.class), EnumSet.allOf(GroupConnection.class), EnumSet.allOf(GroupLink.class)),
	
	/** The LINK. */
	LINK("link", Link.class, EnumSet.allOf(LinkField.class), EnumSet.allOf(LinkConnection.class), EnumSet.allOf(LinkLink.class)),
	
	/** The NOTE. */
	NOTE("note", Note.class, EnumSet.allOf(NoteField.class), EnumSet.allOf(NoteConnection.class), EnumSet.allOf(NoteLink.class)),
	
	/** The PAGE. */
	PAGE("page", Page.class, EnumSet.allOf(PageField.class), EnumSet.allOf(PageConnection.class), EnumSet.allOf(PageLink.class)),
	
	/** The PHOTO. */
	PHOTO("photo", Photo.class, EnumSet.allOf(PhotoField.class), EnumSet.allOf(PhotoConnection.class), EnumSet.allOf(PhotoLink.class)),
	
	/** The POST. */
	POST("post", Post.class, EnumSet.allOf(PostField.class), EnumSet.allOf(PostConnection.class), EnumSet.allOf(PostLink.class)),
	
	/** The STATUS. */
	STATUS("status", Status.class, EnumSet.allOf(StatusField.class), EnumSet.allOf(StatusConnection.class), EnumSet.allOf(StatusLink.class)),
	
	/** The USER. */
	USER("user", User.class, EnumSet.allOf(UserField.class), EnumSet.allOf(UserConnection.class), EnumSet.allOf(UserLink.class)),
	
	/** The VIDEO. */
	VIDEO("video", Video.class, EnumSet.allOf(VideoField.class), EnumSet.allOf(VideoConnection.class), EnumSet.allOf(VideoLink.class));

    /** The Constant stringToEnum. */
	private static final Map<String, ObjectType> stringToEnum = new HashMap<String, ObjectType>();

	static { // Initialize map from constant name to enum constant
		for (ObjectType op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /** The type. */
    private final Class<? extends Entity<?, ?>> type;
    
    private final Set<? extends FieldEnum> fields;
    
    private final Set<? extends ConnectionEnum> connections;
    
    private final Set<? extends ConnectionEnum> links;    
    
    /**
     * Instantiates a new object type.
     * 
     * @param value the value
     * @param type the type
     */
    ObjectType(String value, Class<? extends Entity<?, ?>> type, Set<? extends FieldEnum> fields, Set<? extends ConnectionEnum> connections, Set<? extends ConnectionEnum> links) {
        this.value = value;
        this.type = type;
        this.fields = fields;
        this.connections = connections;
        this.links = links;
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
	public Class<? extends Entity<?, ?>> type() {
		return type;
	}
	
	/**
	 * From value.
	 * 
	 * @param value the value
	 * 
	 * @return the object type
	 */
	public static ObjectType fromValue(String value) {
		return stringToEnum.get(value);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends FieldEnum> T field(String value) {
		for (FieldEnum field : fields) {
			if (field.value().equals(value)) {			
				return (T) field;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends ConnectionEnum> T connection(String value) {
		for (ConnectionEnum connection : connections) {
			if (connection.value().equals(value)) {			
				return (T) connection;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends ConnectionEnum> T link(String value) {
		for (ConnectionEnum link : links) {
			if (link.value().equals(value)) {			
				return (T) link;
			}
		}
		return null;
	}
}
