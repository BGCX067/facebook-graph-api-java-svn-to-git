/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.Photo;
import com.google.code.facebook.graph.model.PhotoTag;
import com.google.code.facebook.graph.model.Post;
import com.google.code.facebook.graph.model.enumeration.ObjectType;
import com.google.code.facebook.graph.model.enumeration.PhotoConnection;

/**
 * The Class PhotoImpl.
 */
public class PhotoImpl extends BaseStream implements Photo {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4589308818366457569L;
	
	/** The tags. */
	private List<PhotoTag> tags = new ArrayList<PhotoTag>();
	
	/** The name. */
	private String name;
	
	/** The source. */
	private String source;
	
	/** The height. */
	private int height;
	
	/** The width. */
	private int width;
	
	/** The link. */
	private String link;
	
	/** The created time. */
	private Date createdTime;
	
	/** The icon. */
	private String icon;
//	private List<Post> comments;
	
	public PhotoImpl() {
		super();
		setType(ObjectType.PHOTO);
	}
	
	/**
 * Sets the tags.
 * 
 * @param tags the new tags
 */
	public void setTags(List<PhotoTag> tags) {
		this.tags = tags;
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
	 * Sets the source.
	 * 
	 * @param source the new source
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * Sets the height.
	 * 
	 * @param height the new height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Sets the width.
	 * 
	 * @param width the new width
	 */
	public void setWidth(int width) {
		this.width = width;
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
	 * Sets the created time.
	 * 
	 * @param createdTime the new created time
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Photo#getTags()
	 */
	public List<PhotoTag> getTags() {
		return tags;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.NamedEntity#getName()
	 */
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Photo#getSource()
	 */
	public String getSource() {
		return source;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Photo#getHeight()
	 */
	public int getHeight() {
		return height;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Photo#getWidth()
	 */
	public int getWidth() {
		return width;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Photo#getLink()
	 */
	public String getLink() {
		return link;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Photo#getCreatedTime()
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Photo#getIcon()
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
	 * @see com.google.code.facebook.graph.model.Photo#getComments()
	 */
	public PagedList<Post> getComments() {
		return getConnections(PhotoConnection.COMMENTS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.json.BaseStream#adaptFrom(org.json.simple.JSONObject)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void adaptFrom(JSONObject adaptee) {
		super.adaptFrom(adaptee);
		JSONObject tagsJson = (JSONObject) adaptee.get("tags");
		if (tagsJson != null) {
			JSONArray tagsDataJson = (JSONArray) tagsJson.get("data");
			if (tagsDataJson != null) {
				for (JSONObject obj : (List<JSONObject>) tagsDataJson) {
					PhotoTagImpl photoTagImpl = new PhotoTagImpl();
					photoTagImpl.adaptFrom(obj);
					tags.add(photoTagImpl);				
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.json.BaseStream#adaptTo()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject adaptTo() {
		JSONObject adapter = super.adaptTo();
		return adapter;
	}

	@Override
	public String getDescription() {
		return getLabel();
	}

	@Override
	public String getLabel() {
		return getName();// + "[" + getId() + "]";
	}
}
