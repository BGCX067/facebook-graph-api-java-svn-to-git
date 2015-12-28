/*
 * 
 */
package com.google.code.facebook.graph.model;


import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.enumeration.LinkConnection;
import com.google.code.facebook.graph.model.enumeration.LinkField;

/**
 * The Interface Link.
 */
public interface Link extends Stream<LinkField, LinkConnection>, NamedEntity<LinkField, LinkConnection> {

	/**
	 * Gets the link.
	 * 
	 * @return the link
	 */
	public String getLink();

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public String getMessage();

	/**
	 * Gets the icon.
	 * 
	 * @return the icon
	 */
	public String getIcon();
	
	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription();
	
	/**
	 * Gets the comments.
	 * 
	 * @return the comments
	 */
	public PagedList<Post> getComments();
}