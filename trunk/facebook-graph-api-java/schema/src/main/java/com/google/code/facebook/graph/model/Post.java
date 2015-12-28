/*
 * 
 */
package com.google.code.facebook.graph.model;

import java.util.Date;
import java.util.List;

import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.enumeration.PostConnection;
import com.google.code.facebook.graph.model.enumeration.PostField;
import com.google.code.facebook.graph.model.enumeration.Privacy;

/**
 * The Interface Post.
 */
public interface Post extends Stream<PostField, PostConnection>, NamedEntity<PostField, PostConnection> {

	/**
	 * Gets the to.
	 * 
	 * @return the to
	 */
	public List<Author<?, ?>> getTo();

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public String getMessage();
	
	/**
	 * Gets the subject.
	 * 
	 * @return the subject
	 */
	public String getSubject();

	/**
	 * Gets the link.
	 * 
	 * @return the link
	 */
	public String getLink();

	/**
	 * Gets the caption.
	 * 
	 * @return the caption
	 */
	public String getCaption();

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription();

	/**
	 * Gets the source.
	 * 
	 * @return the source
	 */
	public String getSource();

	/**
	 * Gets the icon.
	 * 
	 * @return the icon
	 */
	public String getIcon();

	/**
	 * Gets the attribution.
	 * 
	 * @return the attribution
	 */
	public String getAttribution();

	/**
	 * Gets the actions.
	 * 
	 * @return the actions
	 */
	public List<PostAction> getActions();

	/**
	 * Gets the likes.
	 * 
	 * @return the likes
	 */
	public int getLikes();

	/**
	 * Gets the created time.
	 * 
	 * @return the created time
	 */
	public Date getCreatedTime();

	/**
	 * Gets the privacy.
	 * 
	 * @return the privacy
	 */
	public Privacy getPrivacy();

	/**
	 * Gets the comments.
	 * 
	 * @return the comments
	 */
	public PagedList<Post> getComments();
}