/*
 * 
 */
package com.google.code.facebook.graph.model;


import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.enumeration.StatusConnection;
import com.google.code.facebook.graph.model.enumeration.StatusField;

/**
 * The Interface Status.
 */
public interface Status extends Stream<StatusField, StatusConnection> {

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public String getMessage();

	/**
	 * Gets the comments.
	 * 
	 * @return the comments
	 */
	public PagedList<Post> getComments();
}