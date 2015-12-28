/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;


import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.Link;
import com.google.code.facebook.graph.model.Post;
import com.google.code.facebook.graph.model.enumeration.LinkConnection;
import com.google.code.facebook.graph.model.enumeration.ObjectType;

/**
 * The Class LinkImpl.
 */
public class LinkImpl extends BaseStream implements Link {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5476064248241743351L;
	
	/** The link. */
	private String link;
	
	/** The message. */
	private String message;
	
	/** The icon. */
	private String icon;
	
	/** The description. */
	private String description;
	
	/** The name. */
	private String name;
//	private List<Post> comments;
	
	public LinkImpl() {
		super();
		setType(ObjectType.LINK);
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
	 * Sets the message.
	 * 
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Link#getLink()
	 */
	public String getLink() {
		return link;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Link#getMessage()
	 */
	public String getMessage() {
		return message;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Link#getIcon()
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
	 * @see com.google.code.facebook.graph.model.Link#getDescription()
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 * 
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @see com.google.code.facebook.graph.model.Link#getComments()
	 */
	public PagedList<Post> getComments() {
		return getConnections(LinkConnection.COMMENTS);
	}

	@Override
	public String getLabel() {
		return getName();// + "[" + getId() + "]";
	}
}
