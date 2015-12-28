/*
 * 
 */
package com.google.code.facebook.graph.model;

import java.util.Date;

import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.enumeration.EventConnection;
import com.google.code.facebook.graph.model.enumeration.EventField;

/**
 * The Interface Event.
 */
public interface Event extends Association<EventField, EventConnection> {

	/**
	 * Gets the start time.
	 * 
	 * @return the start time
	 */
	public Date getStartTime();

	/**
	 * Gets the end time.
	 * 
	 * @return the end time
	 */
	public Date getEndTime();

	/**
	 * Gets the location.
	 * 
	 * @return the location
	 */
	public String getLocation();

	/**
	 * Gets the feed.
	 * 
	 * @return the feed
	 */
	public PagedList<Post> getFeed();

	/**
	 * Gets the noreply.
	 * 
	 * @return the noreply
	 */
	public PagedList<User> getNoreply();
	
	/**
	 * Gets the maybe.
	 * 
	 * @return the maybe
	 */
	public PagedList<User> getMaybe();
	
	/**
	 * Gets the invited.
	 * 
	 * @return the invited
	 */
	public PagedList<User> getInvited();
	
	/**
	 * Gets the attending.
	 * 
	 * @return the attending
	 */
	public PagedList<User> getAttending();
	
	/**
	 * Gets the declined.
	 * 
	 * @return the declined
	 */
	public PagedList<User> getDeclined();
}