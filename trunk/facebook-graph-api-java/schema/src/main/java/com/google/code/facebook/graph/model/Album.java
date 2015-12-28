/*
 * 
 */
package com.google.code.facebook.graph.model;

import java.util.Date;

import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.enumeration.AlbumConnection;
import com.google.code.facebook.graph.model.enumeration.AlbumField;
import com.google.code.facebook.graph.model.enumeration.Privacy;

/**
 * The Interface Album.
 */
public interface Album extends NamedEntity<AlbumField, AlbumConnection> {

	/**
	 * Gets the from.
	 * 
	 * @return the from
	 */
	public Author<?, ?> getFrom();

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription();

	/**
	 * Gets the location.
	 * 
	 * @return the location
	 */
	public String getLocation();

	/**
	 * Gets the link.
	 * 
	 * @return the link
	 */
	public String getLink();

	/**
	 * Gets the count.
	 * 
	 * @return the count
	 */
	public int getCount();

	/**
	 * Gets the created time.
	 * 
	 * @return the created time
	 */
	public Date getCreatedTime();

	/**
	 * Gets the updated time.
	 * 
	 * @return the updated time
	 */
	public Date getUpdatedTime();
	
	/**
	 * Gets the photos.
	 * 
	 * @return the photos
	 */
	public PagedList<Photo> getPhotos();
	
	/**
	 * Gets the comments.
	 * 
	 * @return the comments
	 */
	public PagedList<Post> getComments();
	
	/**
	 * Gets the privacy.
	 * 
	 * @return the privacy
	 */
	public Privacy getPrivacy();
}