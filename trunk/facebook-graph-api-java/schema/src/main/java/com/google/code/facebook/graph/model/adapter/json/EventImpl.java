/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.util.Date;

import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.Event;
import com.google.code.facebook.graph.model.Post;
import com.google.code.facebook.graph.model.User;
import com.google.code.facebook.graph.model.enumeration.EventConnection;
import com.google.code.facebook.graph.model.enumeration.ObjectType;

/**
 * The Class EventImpl.
 */
public class EventImpl extends BaseAssociation implements Event {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7683562036600497425L;
	
	/** The start time. */
	private Date startTime;
	
	/** The end time. */
	private Date endTime;
	
	/** The location. */
	private String location;
//	private List<Post> feed;
//	private List<User> noreply;
//	private List<User> maybe;
//	private List<User> invited;
//	private List<User> attending;
//	private List<User> declined;
	
	public EventImpl() {
		super();
		setType(ObjectType.EVENT);
	}
	
	
	/**
 * Sets the start time.
 * 
 * @param startTime the new start time
 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * Sets the end time.
	 * 
	 * @param endTime the new end time
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * Sets the location.
	 * 
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Event#getStartTime()
	 */
	public Date getStartTime() {
		return startTime;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Event#getEndTime()
	 */
	public Date getEndTime() {
		return endTime;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Event#getLocation()
	 */
	public String getLocation() {
		return location;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Event#getFeed()
	 */
	public PagedList<Post> getFeed() {
		return getConnections(EventConnection.FEED);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Event#getNoreply()
	 */
	public PagedList<User> getNoreply() {
		return getConnections(EventConnection.NOREPLY);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Event#getMaybe()
	 */
	public PagedList<User> getMaybe() {
		return getConnections(EventConnection.MAYBE);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Event#getInvited()
	 */
	public PagedList<User> getInvited() {
		return getConnections(EventConnection.INVITED);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Event#getAttending()
	 */
	public PagedList<User> getAttending() {
		return getConnections(EventConnection.ATTENDING);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Event#getDeclined()
	 */
	public PagedList<User> getDeclined() {
		return getConnections(EventConnection.DECLINED);
	}

	@Override
	public String getLabel() {
		return getName();// + "[" + getId() + "]";
	}
}
