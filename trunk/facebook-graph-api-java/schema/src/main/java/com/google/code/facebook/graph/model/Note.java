/*
 * 
 */
package com.google.code.facebook.graph.model;

import java.util.Date;

import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.enumeration.NoteConnection;
import com.google.code.facebook.graph.model.enumeration.NoteField;

/**
 * The Interface Note.
 */
public interface Note extends Stream<NoteField, NoteConnection> {

	/**
	 * Gets the subject.
	 * 
	 * @return the subject
	 */
	public String getSubject();

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public String getMessage();

	/**
	 * Gets the created time.
	 * 
	 * @return the created time
	 */
	public Date getCreatedTime();

	/**
	 * Gets the icon.
	 * 
	 * @return the icon
	 */
	public String getIcon();
	
	/**
	 * Gets the comments.
	 * 
	 * @return the comments
	 */
	public PagedList<Post> getComments();
}