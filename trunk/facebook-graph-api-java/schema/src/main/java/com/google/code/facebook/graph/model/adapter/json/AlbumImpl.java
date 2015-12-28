/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.util.Date;

import org.json.simple.JSONObject;

import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.Album;
import com.google.code.facebook.graph.model.Author;
import com.google.code.facebook.graph.model.Photo;
import com.google.code.facebook.graph.model.Post;
import com.google.code.facebook.graph.model.enumeration.AlbumConnection;
import com.google.code.facebook.graph.model.enumeration.ObjectType;
import com.google.code.facebook.graph.model.enumeration.Privacy;

/**
 * The Class AlbumImpl.
 */
public class AlbumImpl extends BaseEntity implements Album {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -347880815599155333L;
	
	/** The from. */
	private Author<?, ?> from;
	
	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/** The location. */
	private String location;
	
	/** The link. */
	private String link;
	
	/** The count. */
	private int count;
	
	/** The created time. */
	private Date createdTime;
	
	/** The updated time. */
	private Date updatedTime;
	
	/** The privacy. */
	private Privacy privacy;
//	private List<Photo> photos;
//	private List<Post> comments;
	
	
	public AlbumImpl() {
		super();
		setType(ObjectType.ALBUM);
	}

	/**
 * Sets the from.
 * 
 * @param from the from
 */
	public void setFrom(Author<?, ?> from) {
		this.from = from;
	}
	
	/**
	 * Sets the name.
	 * 
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the description.
	 * 
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Sets the location.
	 * 
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Sets the link.
	 * 
	 * @param link the new link
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
	/**
	 * Sets the count.
	 * 
	 * @param count the new count
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	/**
	 * Sets the created time.
	 * 
	 * @param createdTime the new created time
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	/**
	 * Sets the updated time.
	 * 
	 * @param updatedTime the new updated time
	 */
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Album#getFrom()
	 */
	public Author<?, ?> getFrom() {
		return from;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.NamedEntity#getName()
	 */
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Album#getDescription()
	 */
	public String getDescription() {
		return description;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Album#getLocation()
	 */
	public String getLocation() {
		return location;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Album#getLink()
	 */
	public String getLink() {
		return link;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Album#getCount()
	 */
	public int getCount() {
		return count;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Album#getCreatedTime()
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Album#getUpdatedTime()
	 */
	public Date getUpdatedTime() {
		return updatedTime;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Album#getPrivacy()
	 */
	public Privacy getPrivacy() {
		return privacy;
	}
	
	/**
	 * Sets the privacy.
	 * 
	 * @param privacy the new privacy
	 */
	public void setPrivacy(Privacy privacy) {
		this.privacy = privacy;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Album#getPhotos()
	 */
	public PagedList<Photo> getPhotos() {
		return getConnections(AlbumConnection.PHOTOS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Album#getComments()
	 */
	public PagedList<Post> getComments() {
		return getConnections(AlbumConnection.COMMENTS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.json.BaseEntity#adaptFrom(org.json.simple.JSONObject)
	 */
	@Override
	public void adaptFrom(JSONObject adaptee) {
		super.adaptFrom(adaptee);
		JSONObject fromJson = (JSONObject) adaptee.get("from");
		if (fromJson != null) {
			from = new AuthorImpl();
			((AuthorImpl) from).adaptFrom(fromJson);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.json.BaseJsonAdapter#adaptTo()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject adaptTo() {
		JSONObject adapter = super.adaptTo();
		if (from != null) {
			JSONObject fromJson = ((AuthorImpl) from).adaptTo();
			adapter.put("from", fromJson);
		}
		return adapter;
	}

	@Override
	public String getLabel() {
		return getName();// + "[" + getId() + "]";
	}
}
