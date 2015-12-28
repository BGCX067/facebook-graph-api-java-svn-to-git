/*
 * 
 */
package com.google.code.facebook.graph.model;


import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.enumeration.PageConnection;
import com.google.code.facebook.graph.model.enumeration.PageField;

/**
 * The Interface Page.
 */
public interface Page extends Author<PageField, PageConnection> {

	/**
	 * Gets the fan count.
	 * 
	 * @return the fan count
	 */
	public int getFanCount();
	
	/**
	 * Gets the birthday.
	 * 
	 * @return the birthday
	 */
	public String getBirthday();
	
	/**
	 * Gets the personal interests.
	 * 
	 * @return the personal interests
	 */
	public String getPersonalInterests();
	
	/**
	 * Gets the location.
	 * 
	 * @return the location
	 */
	public Location getLocation();
	
	/**
	 * Gets the personal info.
	 * 
	 * @return the personal info
	 */
	public String getPersonalInfo();
	
	/**
	 * Gets the affiliation.
	 * 
	 * @return the affiliation
	 */
	public String getAffiliation();
	
	/**
	 * Gets the founded.
	 * 
	 * @return the founded
	 */
	public String getFounded();
	
	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername();
	
	/**
	 * Gets the mission.
	 * 
	 * @return the mission
	 */
	public String getMission();
	
	/**
	 * Gets the link.
	 * 
	 * @return the link
	 */
	public String getLink();
	
	/**
	 * Gets the products.
	 * 
	 * @return the products
	 */
	public String getProducts();
	
	/**
	 * Gets the company overview.
	 * 
	 * @return the company overview
	 */
	public String getCompanyOverview();
	
	/**
	 * Gets the feed.
	 * 
	 * @return the feed
	 */
	public PagedList<Post> getFeed();
	
	/**
	 * Gets the tagged.
	 * 
	 * @return the tagged
	 */
	public PagedList<? extends Stream<?, ?>> getTagged();
	
	/**
	 * Gets the links.
	 * 
	 * @return the links
	 */
	public PagedList<Link> getLinks();
	
	/**
	 * Gets the photos.
	 * 
	 * @return the photos
	 */
	public PagedList<Photo> getPhotos();
	
	/**
	 * Gets the groups.
	 * 
	 * @return the groups
	 */
	public PagedList<Group> getGroups();
	
	/**
	 * Gets the albums.
	 * 
	 * @return the albums
	 */
	public PagedList<Album> getAlbums();
	
	/**
	 * Gets the statuses.
	 * 
	 * @return the statuses
	 */
	public PagedList<Status> getStatuses();
	
	/**
	 * Gets the videos.
	 * 
	 * @return the videos
	 */
	public PagedList<Video> getVideos();
	
	/**
	 * Gets the notes.
	 * 
	 * @return the notes
	 */
	public PagedList<Note> getNotes();
	
	/**
	 * Gets the posts.
	 * 
	 * @return the posts
	 */
	public PagedList<Post> getPosts();
	
	/**
	 * Gets the events.
	 * 
	 * @return the events
	 */
	public PagedList<Event> getEvents();
}