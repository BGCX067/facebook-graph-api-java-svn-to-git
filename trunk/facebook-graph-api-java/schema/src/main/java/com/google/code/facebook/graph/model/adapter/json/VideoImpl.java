/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.util.Date;

import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.Post;
import com.google.code.facebook.graph.model.Video;
import com.google.code.facebook.graph.model.enumeration.ObjectType;
import com.google.code.facebook.graph.model.enumeration.VideoConnection;

/**
 * The Class VideoImpl.
 */
public class VideoImpl extends BaseStream implements Video {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 421479792052538045L;
	
	/** The message. */
	private String message;
	
	/** The description. */
	private String description;
	
	/** The length. */
	private int length;
	
	/** The created time. */
	private Date createdTime;
	
	/** The icon. */
	private String icon;
	
	/** The embed html. */
	private String embedHtml;
	
	/** The name. */
	private String name;
//	private List<Post> comments;
	
	public VideoImpl() {
		super();
		setType(ObjectType.VIDEO);
	}
	
	
	/**
 * Sets the message.
 * 
 * @param message the new message
 */
	public void setMessage(String message) {
		this.message = message;
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
	 * Sets the length.
	 * 
	 * @param length the new length
	 */
	public void setLength(int length) {
		this.length = length;
	}
	
	/**
	 * Sets the created time.
	 * 
	 * @param createdTime the new created time
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Video#getMessage()
	 */
	public String getMessage() {
		return message;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Video#getDescription()
	 */
	public String getDescription() {
		return description;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Video#getLength()
	 */
	public int getLength() {
		return length;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Video#getCreatedTime()
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Video#getIcon()
	 */
	public String getIcon() {
		return icon;
	}
	
	/**
	 * Sets the icon.
	 * 
	 * @param icon the new icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Video#getEmbedHtml()
	 */
	public String getEmbedHtml() {
		return embedHtml;
	}
	
	/**
	 * Sets the embed html.
	 * 
	 * @param embedHtml the new embed html
	 */
	public void setEmbedHtml(String embedHtml) {
		this.embedHtml = embedHtml;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.NamedEntity#getName()
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 * 
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Video#getComments()
	 */
	public PagedList<Post> getComments() {
		return getConnections(VideoConnection.COMMENTS);
	}

	@Override
	public String getLabel() {
		return getName();// + "[" + getId() + "]";
	}
}
