/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;


import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.Group;
import com.google.code.facebook.graph.model.Post;
import com.google.code.facebook.graph.model.User;
import com.google.code.facebook.graph.model.enumeration.GroupConnection;
import com.google.code.facebook.graph.model.enumeration.ObjectType;

/**
 * The Class GroupImpl.
 */
public class GroupImpl extends BaseAssociation implements Group {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 966007695884860033L;
	
	/** The link. */
	private String link;
//	private List<Post> feed;
//	private List<User> members;
	
	public GroupImpl() {
		super();
		setType(ObjectType.GROUP);
	}
	
	/**
 * Sets the link.
 * 
 * @param link the new link
 */
	public void setLink(String link) {
		this.link = link;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Group#getLink()
	 */
	public String getLink() {
		return link;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Group#getFeed()
	 */
	public PagedList<Post> getFeed() {
		return getConnections(GroupConnection.FEED);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Group#getMembers()
	 */
	public PagedList<User> getMembers() {
		return getConnections(GroupConnection.MEMBERS);
	}

	@Override
	public String getLabel() {
		return getName();// + "[" + getId() + "]";
	}
}
