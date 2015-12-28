/*
 * 
 */
package com.google.code.facebook.graph.model;

import java.util.Date;
import java.util.List;

import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.enumeration.PhotoConnection;
import com.google.code.facebook.graph.model.enumeration.PhotoField;

/**
 * The Interface Photo.
 */
public interface Photo extends Stream<PhotoField, PhotoConnection>, NamedEntity<PhotoField, PhotoConnection> {

	/**
	 * Gets the tags.
	 * 
	 * @return the tags
	 */
	public List<PhotoTag> getTags();

	/**
	 * Gets the source.
	 * 
	 * @return the source
	 */
	public String getSource();

	/**
	 * Gets the height.
	 * 
	 * @return the height
	 */
	public int getHeight();

	/**
	 * Gets the width.
	 * 
	 * @return the width
	 */
	public int getWidth();

	/**
	 * Gets the link.
	 * 
	 * @return the link
	 */
	public String getLink();

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