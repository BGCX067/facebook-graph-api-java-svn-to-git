/*
 * 
 */
package com.google.code.facebook.graph.model;

import java.util.Date;

import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.enumeration.VideoConnection;
import com.google.code.facebook.graph.model.enumeration.VideoField;

/**
 * The Interface Video.
 */
public interface Video extends Stream<VideoField, VideoConnection>, NamedEntity<VideoField, VideoConnection> {

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public String getMessage();

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription();

	/**
	 * Gets the length.
	 * 
	 * @return the length
	 */
	public int getLength();

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
	 * Gets the embed html.
	 * 
	 * @return the embed html
	 */
	public String getEmbedHtml();
	
	/**
	 * Gets the comments.
	 * 
	 * @return the comments
	 */
	public PagedList<Post> getComments();
}