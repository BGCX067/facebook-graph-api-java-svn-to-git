/*
 * 
 */
package com.google.code.facebook.graph.model;

import java.util.Date;
import java.util.List;

import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.enumeration.Gender;
import com.google.code.facebook.graph.model.enumeration.UserConnection;
import com.google.code.facebook.graph.model.enumeration.UserField;

/**
 * The Interface User.
 */
public interface User extends Author<UserField, UserConnection> {
	
	/** The Constant ME. */
	public static final String ME = "me";

	/**
	 * Gets the first name.
	 * 
	 * @return the first name
	 */
	public String getFirstName();

	/**
	 * Gets the last name.
	 * 
	 * @return the last name
	 */
	public String getLastName();

	/**
	 * Gets the link.
	 * 
	 * @return the link
	 */
	public String getLink();

	/**
	 * Gets the about.
	 * 
	 * @return the about
	 */
	public String getAbout();

	/**
	 * Gets the birthday.
	 * 
	 * @return the birthday
	 */
	public String getBirthday();

	/**
	 * Gets the work.
	 * 
	 * @return the work
	 */
	public List<Work> getWork();

	/**
	 * Gets the education.
	 * 
	 * @return the education
	 */
	public List<Education> getEducation();

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail();

	/**
	 * Gets the website.
	 * 
	 * @return the website
	 */
	public String getWebsite();

	/**
	 * Gets the timezone.
	 * 
	 * @return the timezone
	 */
	public int getTimezone();
	
	/**
	 * Checks if is verified.
	 * 
	 * @return true, if is verified
	 */
	public boolean isVerified();
	
	/**
	 * Gets the updated time.
	 * 
	 * @return the updated time
	 */
	public Date getUpdatedTime();
	
	/**
	 * Gets the religion.
	 * 
	 * @return the religion
	 */
	public String getReligion();
	
	/**
	 * Gets the relationship status.
	 * 
	 * @return the relationship status
	 */
	public String getRelationshipStatus();
	
	/**
	 * @return the gender
	 */
	public Gender getGender();
	
	/**
	 * @return the location
	 */
	public Page getLocation();
	
	/**
	 * Gets the interested in.
	 * 
	 * @return the interested in
	 */
	public List<String> getInterestedIn();
	
	/**
	 * Gets the meeting for.
	 * 
	 * @return the meeting for
	 */
	public List<String> getMeetingFor();
	
	/**
	 * Gets the home.
	 * 
	 * @return the home
	 */
	public PagedList<Post> getHome();
	
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
	 * Gets the posts.
	 * 
	 * @return the posts
	 */
	public PagedList<Post> getPosts();
	
	/**
	 * Gets the friends.
	 * 
	 * @return the friends
	 */
	public PagedList<User> getFriends();
	
	/**
	 * Gets the family.
	 * 
	 * @return the family
	 */
	public PagedList<User> getFamily();
	
	/**
	 * Gets the activities.
	 * 
	 * @return the activities
	 */
	public PagedList<Page> getActivities();
	
	/**
	 * Gets the interests.
	 * 
	 * @return the interests
	 */
	public PagedList<Page> getInterests();
	
	/**
	 * Gets the music.
	 * 
	 * @return the music
	 */
	public PagedList<Page> getMusic();
	
	/**
	 * Gets the books.
	 * 
	 * @return the books
	 */
	public PagedList<Page> getBooks();
	
	/**
	 * Gets the movies.
	 * 
	 * @return the movies
	 */
	public PagedList<Page> getMovies();
	
	/**
	 * Gets the television.
	 * 
	 * @return the television
	 */
	public PagedList<Page> getTelevision();
	
	/**
	 * Gets the likes.
	 * 
	 * @return the likes
	 */
	public PagedList<Page> getLikes();
	
	/**
	 * Gets the photos.
	 * 
	 * @return the photos
	 */
	public PagedList<Photo> getPhotos();
	
	/**
	 * Gets the albums.
	 * 
	 * @return the albums
	 */
	public PagedList<Album> getAlbums();
	
	/**
	 * Gets the videos.
	 * 
	 * @return the videos
	 */
	public PagedList<Video> getVideos();
	
	/**
	 * Gets the groups.
	 * 
	 * @return the groups
	 */
	public PagedList<Group> getGroups();
	
	/**
	 * Gets the statuses.
	 * 
	 * @return the statuses
	 */
	public PagedList<Status> getStatuses();
	
	/**
	 * Gets the links.
	 * 
	 * @return the links
	 */
	public PagedList<Link> getLinks();
	
	/**
	 * Gets the notes.
	 * 
	 * @return the notes
	 */
	public PagedList<Note> getNotes();
	
	/**
	 * Gets the events.
	 * 
	 * @return the events
	 */
	public PagedList<Event> getEvents();
	
	/**
	 * Gets the inbox.
	 * 
	 * @return the inbox
	 */
	public PagedList<Post> getInbox();
	
	/**
	 * Gets the outbox.
	 * 
	 * @return the outbox
	 */
	public PagedList<Post> getOutbox();
	
	/**
	 * Gets the updates.
	 * 
	 * @return the updates
	 */
	public PagedList<Post> getUpdates();	
}