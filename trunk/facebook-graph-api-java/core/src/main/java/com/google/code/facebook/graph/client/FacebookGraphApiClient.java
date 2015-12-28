/*
 * 
 */
package com.google.code.facebook.graph.client;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.code.facebook.graph.common.FacebookGraphAccessObject;
import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.Album;
import com.google.code.facebook.graph.model.Entity;
import com.google.code.facebook.graph.model.Event;
import com.google.code.facebook.graph.model.Group;
import com.google.code.facebook.graph.model.Insight;
import com.google.code.facebook.graph.model.Link;
import com.google.code.facebook.graph.model.Note;
import com.google.code.facebook.graph.model.Page;
import com.google.code.facebook.graph.model.Photo;
import com.google.code.facebook.graph.model.Post;
import com.google.code.facebook.graph.model.Status;
import com.google.code.facebook.graph.model.Subscription;
import com.google.code.facebook.graph.model.User;
import com.google.code.facebook.graph.model.Video;
import com.google.code.facebook.graph.model.enumeration.AlbumConnection;
import com.google.code.facebook.graph.model.enumeration.AlbumField;
import com.google.code.facebook.graph.model.enumeration.EventConnection;
import com.google.code.facebook.graph.model.enumeration.EventField;
import com.google.code.facebook.graph.model.enumeration.GroupConnection;
import com.google.code.facebook.graph.model.enumeration.GroupField;
import com.google.code.facebook.graph.model.enumeration.LinkConnection;
import com.google.code.facebook.graph.model.enumeration.LinkField;
import com.google.code.facebook.graph.model.enumeration.NoteConnection;
import com.google.code.facebook.graph.model.enumeration.NoteField;
import com.google.code.facebook.graph.model.enumeration.PageConnection;
import com.google.code.facebook.graph.model.enumeration.PageField;
import com.google.code.facebook.graph.model.enumeration.PhotoConnection;
import com.google.code.facebook.graph.model.enumeration.PhotoField;
import com.google.code.facebook.graph.model.enumeration.PostConnection;
import com.google.code.facebook.graph.model.enumeration.PostField;
import com.google.code.facebook.graph.model.enumeration.StatusConnection;
import com.google.code.facebook.graph.model.enumeration.StatusField;
import com.google.code.facebook.graph.model.enumeration.SubscriptionType;
import com.google.code.facebook.graph.model.enumeration.UserConnection;
import com.google.code.facebook.graph.model.enumeration.UserField;
import com.google.code.facebook.graph.model.enumeration.ValueEnum;
import com.google.code.facebook.graph.model.enumeration.VideoConnection;
import com.google.code.facebook.graph.model.enumeration.VideoField;


/**
 * The Interface FacebookGraphApiClient.
 */
public interface FacebookGraphApiClient extends FacebookGraphAccessObject, FacebookAuthenticationClient {
	
	/**
	 * Gets the album.
	 * 
	 * @param id the id
	 * 
	 * @return the album
	 */
	public Album getAlbum(String id);
	
	/**
	 * Gets the albums.
	 * 
	 * @param ids the ids
	 * 
	 * @return the albums
	 */
	public Map<String, Album> getAlbums(List<String> ids);
	
	/**
	 * Gets the album.
	 * 
	 * @param id the id
	 * @param fields the fields
	 * 
	 * @return the album
	 */
	public Album getAlbum(String id, Set<AlbumField> fields);
	
	/**
	 * Gets the albums.
	 * 
	 * @param ids the ids
	 * @param fields the fields
	 * 
	 * @return the albums
	 */
	public Map<String, Album> getAlbums(List<String> ids, Set<AlbumField> fields);
	
	/**
	 * Gets the album connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * 
	 * @return the album connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getAlbumConnections(String id, AlbumConnection connectionType);
	
	/**
	 * Gets the album connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * @param paging the paging
	 * @param timePeriod the time period
	 * 
	 * @return the album connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getAlbumConnections(String id, AlbumConnection connectionType, Paging paging, TimePeriod timePeriod);
	
	/**
	 * Gets the event.
	 * 
	 * @param id the id
	 * 
	 * @return the event
	 */
	public Event getEvent(String id);
	
	/**
	 * Gets the events.
	 * 
	 * @param ids the ids
	 * 
	 * @return the events
	 */
	public Map<String, Event> getEvents(List<String> ids);
	
	/**
	 * Gets the event.
	 * 
	 * @param id the id
	 * @param fields the fields
	 * 
	 * @return the event
	 */
	public Event getEvent(String id, Set<EventField> fields);
	
	/**
	 * Gets the events.
	 * 
	 * @param ids the ids
	 * @param fields the fields
	 * 
	 * @return the events
	 */
	public Map<String, Event> getEvents(List<String> ids, Set<EventField> fields);
	
	/**
	 * Gets the event connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * 
	 * @return the event connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getEventConnections(String id, EventConnection connectionType);
	
	/**
	 * Gets the event connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * @param paging the paging
	 * @param timePeriod the time period
	 * 
	 * @return the event connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getEventConnections(String id, EventConnection connectionType, Paging paging, TimePeriod timePeriod);
	
	/**
	 * Gets the group.
	 * 
	 * @param id the id
	 * 
	 * @return the group
	 */
	public Group getGroup(String id);
	
	/**
	 * Gets the groups.
	 * 
	 * @param ids the ids
	 * 
	 * @return the groups
	 */
	public Map<String, Group> getGroups(List<String> ids);
	
	/**
	 * Gets the group.
	 * 
	 * @param id the id
	 * @param fields the fields
	 * 
	 * @return the group
	 */
	public Group getGroup(String id, Set<GroupField> fields);
	
	/**
	 * Gets the groups.
	 * 
	 * @param ids the ids
	 * @param fields the fields
	 * 
	 * @return the groups
	 */
	public Map<String, Group> getGroups(List<String> ids, Set<GroupField> fields);
	
	/**
	 * Gets the group connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * 
	 * @return the group connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getGroupConnections(String id, GroupConnection connectionType);
	
	/**
	 * Gets the group connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * @param paging the paging
	 * @param timePeriod the time period
	 * 
	 * @return the group connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getGroupConnections(String id, GroupConnection connectionType, Paging paging, TimePeriod timePeriod);
	
	/**
	 * Gets the link.
	 * 
	 * @param id the id
	 * 
	 * @return the link
	 */
	public Link getLink(String id);
	
	/**
	 * Gets the links.
	 * 
	 * @param ids the ids
	 * 
	 * @return the links
	 */
	public Map<String, Link> getLinks(List<String> ids);
	
	/**
	 * Gets the link.
	 * 
	 * @param id the id
	 * @param fields the fields
	 * 
	 * @return the link
	 */
	public Link getLink(String id, Set<LinkField> fields);
	
	/**
	 * Gets the links.
	 * 
	 * @param ids the ids
	 * @param fields the fields
	 * 
	 * @return the links
	 */
	public Map<String, Link> getLinks(List<String> ids, Set<LinkField> fields);
	
	/**
	 * Gets the link connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * 
	 * @return the link connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getLinkConnections(String id, LinkConnection connectionType);
	
	/**
	 * Gets the link connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * @param paging the paging
	 * @param timePeriod the time period
	 * 
	 * @return the link connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getLinkConnections(String id, LinkConnection connectionType, Paging paging, TimePeriod timePeriod);
	
	/**
	 * Gets the note.
	 * 
	 * @param id the id
	 * 
	 * @return the note
	 */
	public Note getNote(String id);
	
	/**
	 * Gets the notes.
	 * 
	 * @param ids the ids
	 * 
	 * @return the notes
	 */
	public Map<String, Note> getNotes(List<String> ids);
	
	/**
	 * Gets the note.
	 * 
	 * @param id the id
	 * @param fields the fields
	 * 
	 * @return the note
	 */
	public Note getNote(String id, Set<NoteField> fields);
	
	/**
	 * Gets the notes.
	 * 
	 * @param ids the ids
	 * @param fields the fields
	 * 
	 * @return the notes
	 */
	public Map<String, Note> getNotes(List<String> ids, Set<NoteField> fields);
	
	/**
	 * Gets the note connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * 
	 * @return the note connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getNoteConnections(String id, NoteConnection connectionType);
	
	/**
	 * Gets the note connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * @param paging the paging
	 * @param timePeriod the time period
	 * 
	 * @return the note connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getNoteConnections(String id, NoteConnection connectionType, Paging paging, TimePeriod timePeriod);
	
	/**
	 * Gets the page.
	 * 
	 * @param id the id
	 * 
	 * @return the page
	 */
	public Page getPage(String id);
	
	/**
	 * Gets the pages.
	 * 
	 * @param ids the ids
	 * 
	 * @return the pages
	 */
	public Map<String, Page> getPages(List<String> ids);
	
	/**
	 * Gets the page.
	 * 
	 * @param id the id
	 * @param fields the fields
	 * 
	 * @return the page
	 */
	public Page getPage(String id, Set<PageField> fields);
	
	/**
	 * Gets the pages.
	 * 
	 * @param ids the ids
	 * @param fields the fields
	 * 
	 * @return the pages
	 */
	public Map<String, Page> getPages(List<String> ids, Set<PageField> fields);
	
	/**
	 * Gets the page connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * 
	 * @return the page connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getPageConnections(String id, PageConnection connectionType);
	
	/**
	 * Gets the page connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * @param paging the paging
	 * @param timePeriod the time period
	 * 
	 * @return the page connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getPageConnections(String id, PageConnection connectionType, Paging paging, TimePeriod timePeriod);
	
	/**
	 * Gets the photo.
	 * 
	 * @param id the id
	 * 
	 * @return the photo
	 */
	public Photo getPhoto(String id);
	
	/**
	 * Gets the photos.
	 * 
	 * @param ids the ids
	 * 
	 * @return the photos
	 */
	public Map<String, Photo> getPhotos(List<String> ids);
	
	/**
	 * Gets the photo.
	 * 
	 * @param id the id
	 * @param fields the fields
	 * 
	 * @return the photo
	 */
	public Photo getPhoto(String id, Set<PhotoField> fields);
	
	/**
	 * Gets the photos.
	 * 
	 * @param ids the ids
	 * @param fields the fields
	 * 
	 * @return the photos
	 */
	public Map<String, Photo> getPhotos(List<String> ids, Set<PhotoField> fields);
	
	/**
	 * Gets the photo connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * 
	 * @return the photo connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getPhotoConnections(String id, PhotoConnection connectionType);
	
	/**
	 * Gets the photo connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * @param paging the paging
	 * @param timePeriod the time period
	 * 
	 * @return the photo connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getPhotoConnections(String id, PhotoConnection connectionType, Paging paging, TimePeriod timePeriod);
	
	/**
	 * Gets the post.
	 * 
	 * @param id the id
	 * 
	 * @return the post
	 */
	public Post getPost(String id);
	
	/**
	 * Gets the posts.
	 * 
	 * @param ids the ids
	 * 
	 * @return the posts
	 */
	public Map<String, Post> getPosts(List<String> ids);
	
	/**
	 * Gets the post.
	 * 
	 * @param id the id
	 * @param fields the fields
	 * 
	 * @return the post
	 */
	public Post getPost(String id, Set<PostField> fields);
	
	/**
	 * Gets the posts.
	 * 
	 * @param ids the ids
	 * @param fields the fields
	 * 
	 * @return the posts
	 */
	public Map<String, Post> getPosts(List<String> ids, Set<PostField> fields);
	
	/**
	 * Gets the post connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * 
	 * @return the post connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getPostConnections(String id, PostConnection connectionType);
	
	/**
	 * Gets the post connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * @param paging the paging
	 * @param timePeriod the time period
	 * 
	 * @return the post connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getPostConnections(String id, PostConnection connectionType, Paging paging, TimePeriod timePeriod);
	
	/**
	 * Gets the status.
	 * 
	 * @param id the id
	 * 
	 * @return the status
	 */
	public Status getStatus(String id);
	
	/**
	 * Gets the statuses.
	 * 
	 * @param ids the ids
	 * 
	 * @return the statuses
	 */
	public Map<String, Status> getStatuses(List<String> ids);
	
	/**
	 * Gets the status.
	 * 
	 * @param id the id
	 * @param fields the fields
	 * 
	 * @return the status
	 */
	public Status getStatus(String id, Set<StatusField> fields);
	
	/**
	 * Gets the statuses.
	 * 
	 * @param ids the ids
	 * @param fields the fields
	 * 
	 * @return the statuses
	 */
	public Map<String, Status> getStatuses(List<String> ids, Set<StatusField> fields);
	
	/**
	 * Gets the status connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * 
	 * @return the status connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getStatusConnections(String id, StatusConnection connectionType);
	
	/**
	 * Gets the status connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * @param paging the paging
	 * @param timePeriod the time period
	 * 
	 * @return the status connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getStatusConnections(String id, StatusConnection connectionType, Paging paging, TimePeriod timePeriod);
	
	/**
	 * Gets the user.
	 * 
	 * @param id the id
	 * 
	 * @return the user
	 */
	public User getUser(String id);
	
	/**
	 * Gets the users.
	 * 
	 * @param ids the ids
	 * 
	 * @return the users
	 */
	public Map<String, User> getUsers(List<String> ids);
	
	/**
	 * Gets the user.
	 * 
	 * @param id the id
	 * @param fields the fields
	 * 
	 * @return the user
	 */
	public User getUser(String id, Set<UserField> fields);
	
	/**
	 * Gets the users.
	 * 
	 * @param ids the ids
	 * @param fields the fields
	 * 
	 * @return the users
	 */
	public Map<String, User> getUsers(List<String> ids, Set<UserField> fields);
	
	/**
	 * Gets the user connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * 
	 * @return the user connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getUserConnections(String id, UserConnection connectionType);
	
	/**
	 * Gets the user connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * @param paging the paging
	 * @param timePeriod the time period
	 * 
	 * @return the user connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getUserConnections(String id, UserConnection connectionType, Paging paging, TimePeriod timePeriod);
	
	/**
	 * Gets the video.
	 * 
	 * @param id the id
	 * 
	 * @return the video
	 */
	public Video getVideo(String id);
	
	/**
	 * Gets the videos.
	 * 
	 * @param ids the ids
	 * 
	 * @return the videos
	 */
	public Map<String, Video> getVideos(List<String> ids);
	
	/**
	 * Gets the video.
	 * 
	 * @param id the id
	 * @param fields the fields
	 * 
	 * @return the video
	 */
	public Video getVideo(String id, Set<VideoField> fields);
	
	/**
	 * Gets the videos.
	 * 
	 * @param ids the ids
	 * @param fields the fields
	 * 
	 * @return the videos
	 */
	public Map<String, Video> getVideos(List<String> ids, Set<VideoField> fields);
	
	/**
	 * Gets the video connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * 
	 * @return the video connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getVideoConnections(String id, VideoConnection connectionType);
	
	/**
	 * Gets the video connections.
	 * 
	 * @param id the id
	 * @param connectionType the connection type
	 * @param paging the paging
	 * @param timePeriod the time period
	 * 
	 * @return the video connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getVideoConnections(String id, VideoConnection connectionType, Paging paging, TimePeriod timePeriod);
	
	// Update Methods
	/**
	 * Post feed.
	 * 
	 * @param userId the user id
	 * @param message the message
	 * @param picture the picture
	 * @param link the link
	 * @param name the name
	 * @param description the description
	 * 
	 * @return the post
	 */
	public Post postFeed(String userId, String message, String picture, String link, String name, String description);
	
	/**
	 * Post comment.
	 * 
	 * @param postId the post id
	 * @param message the message
	 * 
	 * @return the post
	 */
	public Post postComment(String postId, String message);
	
	/**
	 * Like post.
	 * 
	 * @param postId the post id
	 */
	public void likePost(String postId);
	
	/**
	 * Unlike post.
	 * 
	 * @param postId the post id
	 */
	public void unlikePost(String postId);
	
	/**
	 * Post note.
	 * 
	 * @param userId the user id
	 * @param message the message
	 * @param subject the subject
	 * 
	 * @return the note
	 */
	public Note postNote(String userId, String message, String subject);
	
	/**
	 * Post link.
	 * 
	 * @param userId the user id
	 * @param link the link
	 * @param message the message
	 * 
	 * @return the link
	 */
	public Link postLink(String userId, String link, String message);
	
	/**
	 * Creates the event.
	 * 
	 * @param userId the user id
	 * @param name the name
	 * @param startTime the start time
	 * @param endTime the end time
	 * 
	 * @return the event
	 */
	public Event createEvent(String userId, String name, Date startTime, Date endTime);
	
	/**
	 * Attend event.
	 * 
	 * @param eventId the event id
	 */
	public void attendEvent(String eventId);
	
	/**
	 * Maybe attend event.
	 * 
	 * @param eventId the event id
	 */
	public void maybeAttendEvent(String eventId);
	
	/**
	 * Decline event.
	 * 
	 * @param eventId the event id
	 */
	public void declineEvent(String eventId);
	
	/**
	 * Creates the album.
	 * 
	 * @param userId the user id
	 * @param name the name
	 * @param message the message
	 * 
	 * @return the album
	 */
	public Album createAlbum(String userId, String name, String message);
	
	/**
	 * Upload photo.
	 * 
	 * @param albumId the album id
	 * @param message the message
	 * 
	 * @return the photo
	 */
	public Photo uploadPhoto(String albumId, String message);
	
	// Search Methods
	/**
	 * Search posts.
	 * 
	 * @param query the query
	 * 
	 * @return the list< post>
	 */
	public PagedList<Post> searchPosts(String query);
	
	/**
	 * Search posts.
	 * 
	 * @param query the query
	 * @param paging the paging
	 * @param timePeriod the time period
	 * 
	 * @return the list< post>
	 */
	public PagedList<Post> searchPosts(String query, Paging paging, TimePeriod timePeriod);
	
	/**
	 * Search people.
	 * 
	 * @param query the query
	 * 
	 * @return the list< user>
	 */
	public PagedList<User> searchPeople(String query);
	
	/**
	 * Search people.
	 * 
	 * @param query the query
	 * @param paging the paging
	 * @param timePeriod the time period
	 * 
	 * @return the list< user>
	 */
	public PagedList<User> searchPeople(String query, Paging paging, TimePeriod timePeriod);
	
	/**
	 * Search pages.
	 * 
	 * @param query the query
	 * 
	 * @return the list< page>
	 */
	public PagedList<Page> searchPages(String query);
	
	/**
	 * Search pages.
	 * 
	 * @param query the query
	 * @param paging the paging
	 * @param timePeriod the time period
	 * 
	 * @return the list< page>
	 */
	public PagedList<Page> searchPages(String query, Paging paging, TimePeriod timePeriod);
	
	/**
	 * Search events.
	 * 
	 * @param query the query
	 * 
	 * @return the list< event>
	 */
	public PagedList<Event> searchEvents(String query);
	
	/**
	 * Search events.
	 * 
	 * @param query the query
	 * @param paging the paging
	 * @param timePeriod the time period
	 * 
	 * @return the list< event>
	 */
	public PagedList<Event> searchEvents(String query, Paging paging, TimePeriod timePeriod);
	
	/**
	 * Search groups.
	 * 
	 * @param query the query
	 * 
	 * @return the list< group>
	 */
	public PagedList<Group> searchGroups(String query);
	
	/**
	 * Search groups.
	 * 
	 * @param query the query
	 * @param paging the paging
	 * @param timePeriod the time period
	 * 
	 * @return the list< group>
	 */
	public PagedList<Group> searchGroups(String query, Paging paging, TimePeriod timePeriod);
	
	/**
	 * Search news feed.
	 * 
	 * @param query the query
	 * 
	 * @return the list< post>
	 */
	public PagedList<Post> searchNewsFeed(String query);
	
	/**
	 * Search news feed.
	 * 
	 * @param query the query
	 * @param paging the paging
	 * @param timePeriod the time period
	 * 
	 * @return the list< post>
	 */
	public PagedList<Post> searchNewsFeed(String query, Paging paging, TimePeriod timePeriod);
	
	// Analytics Methods
	/**
	 * Gets the application insights.
	 * 
	 * @param applicationId the application id
	 * 
	 * @return the application insights
	 */
	public List<Insight> getApplicationInsights(String applicationId);
	
	/**
	 * Gets the application insights.
	 * 
	 * @param applicationId the application id
	 * @param timePeriod the time period
	 * 
	 * @return the application insights
	 */
	public List<Insight> getApplicationInsights(String applicationId, TimePeriod timePeriod);
	
	/**
	 * Gets the application insight.
	 * 
	 * @param insightId the insight id
	 * 
	 * @return the application insight
	 */
	public Insight getApplicationInsight(String insightId);
	
	/**
	 * Gets the application insight.
	 * 
	 * @param insightId the insight id
	 * @param timePeriod the time period
	 * 
	 * @return the application insight
	 */
	public Insight getApplicationInsight(String insightId, TimePeriod timePeriod);
	
	// Subscription Methods
	/**
	 * Subscribe.
	 * 
	 * @param applicationId the application id
	 * @param object the object
	 * @param fields the fields
	 * @param callbackUrl the callback url
	 * @param verifyToken the verify token
	 */
	public void subscribe(String applicationId, SubscriptionType object, Set<? extends ValueEnum> fields, String callbackUrl, String verifyToken);
	
	/**
	 * Gets the subscriptions.
	 * 
	 * @param applicationId the application id
	 * 
	 * @return the subscriptions
	 */
	public List<Subscription> getSubscriptions(String applicationId);
	
	/**
	 * Delete subscriptions.
	 * 
	 * @param applicationId the application id
	 */
	public void deleteSubscriptions(String applicationId);
	
	/**
	 * Delete subscription.
	 * 
	 * @param applicationId the application id
	 * @param object the object
	 */
	public void deleteSubscription(String applicationId, SubscriptionType object);
}
