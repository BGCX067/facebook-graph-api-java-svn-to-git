/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum Permission.
 */
public enum Permission implements ValueEnum {
	
	/** The PUBLIS h_ stream. */
	PUBLISH_STREAM("publish_stream"),
	
	/** The CREAT e_ event. */
	CREATE_EVENT("create_event"),
	
	/** The RSV p_ event. */
	RSVP_EVENT("rsvp_event"),
	
	/** The SMS. */
	SMS("sms"),
	
	/** The OFFLIN e_ access. */
	OFFLINE_ACCESS("offline_access"),
	
	/** The EMAIL. */
	EMAIL("email"),
	
	/** The REA d_ stream. */
	READ_STREAM("read_stream"),
	
	/** The USE r_ abou t_ me. */
	USER_ABOUT_ME("user_about_me"),
	
	/** The FRIEND s_ abou t_ me. */
	FRIENDS_ABOUT_ME("friends_about_me"),
	
	/** The USE r_ activities. */
	USER_ACTIVITIES("user_activities"),
	
	/** The FRIEND s_ activities. */
	FRIENDS_ACTIVITIES("friends_activities"),
	
	/** The USE r_ birthday. */
	USER_BIRTHDAY("user_birthday"),
	
	/** The FRIEND s_ birthday. */
	FRIENDS_BIRTHDAY("friends_birthday"),
	
	/** The USE r_ educatio n_ history. */
	USER_EDUCATION_HISTORY("user_education_history"),
	
	/** The FRIEND s_ educatio n_ history. */
	FRIENDS_EDUCATION_HISTORY("friends_education_history"),
	
	/** The USE r_ events. */
	USER_EVENTS("user_events"),
	
	/** The FRIEND s_ events. */
	FRIENDS_EVENTS("friends_events"),
	
	/** The USE r_ groups. */
	USER_GROUPS("user_groups"),
	
	/** The FRIEND s_ groups. */
	FRIENDS_GROUPS("friends_groups"),
	
	/** The USE r_ hometown. */
	USER_HOMETOWN("user_hometown"),
	
	/** The FRIEND s_ hometown. */
	FRIENDS_HOMETOWN("friends_hometown"),
	
	/** The USE r_ interests. */
	USER_INTERESTS("user_interests"),
	
	/** The FRIEND s_ interests. */
	FRIENDS_INTERESTS("friends_interests"),
	
	/** The USE r_ likes. */
	USER_LIKES("user_likes"),
 	
	 /** The FRIEND s_ likes. */
	 FRIENDS_LIKES("friends_likes"),
 	
	 /** The USE r_ location. */
	 USER_LOCATION("user_location"),
 	
	 /** The FRIEND s_ location. */
	 FRIENDS_LOCATION("friends_location"),
 	
	 /** The USE r_ notes. */
	 USER_NOTES("user_notes"),
 	
	 /** The FRIEND s_ notes. */
	 FRIENDS_NOTES("friends_notes"),
 	
	 /** The USE r_ onlin e_ presence. */
	 USER_ONLINE_PRESENCE("user_online_presence"),
 	
	 /** The FRIEND s_ onlin e_ presence. */
	 FRIENDS_ONLINE_PRESENCE("friends_online_presence"),
 	
	 /** The USE r_ phot o_ vide o_ tags. */
	 USER_PHOTO_VIDEO_TAGS("user_photo_video_tags"),
 	
	 /** The FRIEND s_ phot o_ vide o_ tags. */
	 FRIENDS_PHOTO_VIDEO_TAGS("friends_photo_video_tags"),
 	
	 /** The USE r_ photos. */
	 USER_PHOTOS("user_photos"),
 	
	 /** The FRIEND s_ photos. */
	 FRIENDS_PHOTOS("friends_photos"),
 	
	 /** The USE r_ relationships. */
	 USER_RELATIONSHIPS("user_relationships"),
 	
	 /** The FRIEND s_ relationships. */
	 FRIENDS_RELATIONSHIPS("friends_relationships"),
 	
	 /** The USE r_ religio n_ politics. */
	 USER_RELIGION_POLITICS("user_religion_politics"),
 	
	 /** The FRIEND s_ religio n_ politics. */
	 FRIENDS_RELIGION_POLITICS("friends_religion_politics"),
 	
	 /** The USE r_ status. */
	 USER_STATUS("user_status"),
 	
	 /** The FRIEND s_ status. */
	 FRIENDS_STATUS("friends_status"),
 	
	 /** The USE r_ videos. */
	 USER_VIDEOS("user_videos"),
 	
	 /** The FRIEND s_ videos. */
	 FRIENDS_VIDEOS("friends_videos"),
 	
	 /** The USE r_ website. */
	 USER_WEBSITE("user_website"),
 	
	 /** The FRIEND s_ website. */
	 FRIENDS_WEBSITE("friends_website"),
 	
	 /** The USE r_ wor k_ history. */
	 USER_WORK_HISTORY("user_work_history"),
 	
	 /** The FRIEND s_ wor k_ history. */
	 FRIENDS_WORK_HISTORY("friends_work_history"),
 	
	 /** The REA d_ friendlists. */
	 READ_FRIENDLISTS("read_friendlists"),
	 
	 READ_MAILBOX("read_mailbox"),
 	
	 /** The REA d_ requests. */
	 READ_REQUESTS("read_requests");
	

    /** The Constant stringToEnum. */
	private static final Map<String, Permission> stringToEnum = new HashMap<String, Permission>();

	static { // Initialize map from constant name to enum constant
		for (Permission op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new permission.
     * 
     * @param value the value
     */
    Permission(String value) {
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
	 * @return the permission
	 */
	public static Permission fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
