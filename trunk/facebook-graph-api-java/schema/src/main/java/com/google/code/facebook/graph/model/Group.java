/*
 * 
 */
package com.google.code.facebook.graph.model;


import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.enumeration.GroupConnection;
import com.google.code.facebook.graph.model.enumeration.GroupField;

/**
 * The Interface Group.
 */
public interface Group extends Association<GroupField, GroupConnection> {

	/**
	 * Gets the link.
	 * 
	 * @return the link
	 */
	public String getLink();

	/**
	 * Gets the feed.
	 * 
	 * @return the feed
	 */
	public PagedList<Post> getFeed();
	
	/**
	 * Gets the members.
	 * 
	 * @return the members
	 */
	public PagedList<User> getMembers();
}