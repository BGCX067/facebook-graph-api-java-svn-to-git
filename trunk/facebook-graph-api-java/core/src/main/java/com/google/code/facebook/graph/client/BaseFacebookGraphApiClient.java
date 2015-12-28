/*
 * 
 */
package com.google.code.facebook.graph.client;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.code.facebook.graph.client.constant.FacebookGraphApiUrls;
import com.google.code.facebook.graph.client.constant.ParameterNames;
import com.google.code.facebook.graph.client.constant.FacebookGraphApiUrls.FacebookGraphApiUrlBuilder;
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
import com.google.code.facebook.graph.model.enumeration.ObjectType;
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
 * The Class BaseFacebookGraphApiClient.
 */
public abstract class BaseFacebookGraphApiClient extends BaseFacebookGraphAccessObject implements FacebookGraphApiClient {

	/** The access token. */
	private String accessToken;
	
    /**
     * Instantiates a new base facebook graph api client.
     */
    protected BaseFacebookGraphApiClient() {
    	super();
    }
    
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookAuthenticationClient#getAccessToken()
	 */
	@Override
	public String getAccessToken() {
		return accessToken;
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookAuthenticationClient#setAccessToken(java.lang.String)
	 */
	@Override
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getAlbum(java.lang.String)
	 */
	@Override
	public Album getAlbum(String id) {
		return get(ObjectType.ALBUM, id);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getAlbums(java.util.List)
	 */
	@Override
	public Map<String, Album> getAlbums(List<String> ids) {
		return get(ObjectType.ALBUM, ids);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getEvent(java.lang.String)
	 */
	@Override
	public Event getEvent(String id) {
		return get(ObjectType.EVENT, id);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getEvents(java.util.List)
	 */
	@Override
	public Map<String, Event> getEvents(List<String> ids) {
		return get(ObjectType.EVENT, ids);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getGroup(java.lang.String)
	 */
	@Override
	public Group getGroup(String id) {
		return get(ObjectType.GROUP, id);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getGroups(java.util.List)
	 */
	@Override
	public Map<String, Group> getGroups(List<String> ids) {
		return get(ObjectType.GROUP, ids);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getLink(java.lang.String)
	 */
	@Override
	public Link getLink(String id) {
		return get(ObjectType.LINK, id);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getLinks(java.util.List)
	 */
	@Override
	public Map<String, Link> getLinks(List<String> ids) {
		return get(ObjectType.LINK, ids);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getNote(java.lang.String)
	 */
	@Override
	public Note getNote(String id) {
		return get(ObjectType.NOTE, id);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getNotes(java.util.List)
	 */
	@Override
	public Map<String, Note> getNotes(List<String> ids) {
		return get(ObjectType.NOTE, ids);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getPage(java.lang.String)
	 */
	@Override
	public Page getPage(String id) {
		return get(ObjectType.PAGE, id);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getPages(java.util.List)
	 */
	@Override
	public Map<String, Page> getPages(List<String> ids) {
		return get(ObjectType.PAGE, ids);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getPhoto(java.lang.String)
	 */
	@Override
	public Photo getPhoto(String id) {
		return get(ObjectType.PHOTO, id);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getPhotos(java.util.List)
	 */
	@Override
	public Map<String, Photo> getPhotos(List<String> ids) {
		return get(ObjectType.PHOTO, ids);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getPost(java.lang.String)
	 */
	@Override
	public Post getPost(String id) {
		return get(ObjectType.POST, id);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getPosts(java.util.List)
	 */
	@Override
	public Map<String, Post> getPosts(List<String> ids) {
		return get(ObjectType.POST, ids);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getStatus(java.lang.String)
	 */
	@Override
	public Status getStatus(String id) {
		return get(ObjectType.STATUS, id);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getStatuses(java.util.List)
	 */
	@Override
	public Map<String, Status> getStatuses(List<String> ids) {
		return get(ObjectType.STATUS, ids);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getUser(java.lang.String)
	 */
	@Override
	public User getUser(String id) {
		return get(ObjectType.USER, id);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getUsers(java.util.List)
	 */
	@Override
	public Map<String, User> getUsers(List<String> ids) {
		return get(ObjectType.USER, ids);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getVideo(java.lang.String)
	 */
	@Override
	public Video getVideo(String id) {
		return get(ObjectType.VIDEO, id);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getVideos(java.util.List)
	 */
	@Override
	public Map<String, Video> getVideos(List<String> ids) {
		return get(ObjectType.VIDEO, ids);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getAlbum(java.lang.String, java.util.Set)
	 */
	@Override
	public Album getAlbum(String id, Set<AlbumField> fields) {
		return get(ObjectType.ALBUM, id, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getAlbums(java.util.List, java.util.Set)
	 */
	@Override
	public Map<String, Album> getAlbums(List<String> ids, Set<AlbumField> fields) {
		return get(ObjectType.ALBUM, ids, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getEvent(java.lang.String, java.util.Set)
	 */
	@Override
	public Event getEvent(String id, Set<EventField> fields) {
		return get(ObjectType.EVENT, id, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getEvents(java.util.List, java.util.Set)
	 */
	@Override
	public Map<String, Event> getEvents(List<String> ids, Set<EventField> fields) {
		return get(ObjectType.EVENT, ids, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getGroup(java.lang.String, java.util.Set)
	 */
	@Override
	public Group getGroup(String id, Set<GroupField> fields) {
		return get(ObjectType.GROUP, id, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getGroups(java.util.List, java.util.Set)
	 */
	@Override
	public Map<String, Group> getGroups(List<String> ids, Set<GroupField> fields) {
		return get(ObjectType.GROUP, ids, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getLink(java.lang.String, java.util.Set)
	 */
	@Override
	public Link getLink(String id, Set<LinkField> fields) {
		return get(ObjectType.LINK, id, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getLinks(java.util.List, java.util.Set)
	 */
	@Override
	public Map<String, Link> getLinks(List<String> ids, Set<LinkField> fields) {
		return get(ObjectType.LINK, ids, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getNote(java.lang.String, java.util.Set)
	 */
	@Override
	public Note getNote(String id, Set<NoteField> fields) {
		return get(ObjectType.NOTE, id, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getNotes(java.util.List, java.util.Set)
	 */
	@Override
	public Map<String, Note> getNotes(List<String> ids, Set<NoteField> fields) {
		return get(ObjectType.NOTE, ids, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getPage(java.lang.String, java.util.Set)
	 */
	@Override
	public Page getPage(String id, Set<PageField> fields) {
		return get(ObjectType.PAGE, id, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getPages(java.util.List, java.util.Set)
	 */
	@Override
	public Map<String, Page> getPages(List<String> ids, Set<PageField> fields) {
		return get(ObjectType.PAGE, ids, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getPhoto(java.lang.String, java.util.Set)
	 */
	@Override
	public Photo getPhoto(String id, Set<PhotoField> fields) {
		return get(ObjectType.PHOTO, id, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getPhotos(java.util.List, java.util.Set)
	 */
	@Override
	public Map<String, Photo> getPhotos(List<String> ids, Set<PhotoField> fields) {
		return get(ObjectType.PHOTO, ids, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getPost(java.lang.String, java.util.Set)
	 */
	@Override
	public Post getPost(String id, Set<PostField> fields) {
		return get(ObjectType.POST, id, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getPosts(java.util.List, java.util.Set)
	 */
	@Override
	public Map<String, Post> getPosts(List<String> ids, Set<PostField> fields) {
		return get(ObjectType.POST, ids, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getStatus(java.lang.String, java.util.Set)
	 */
	@Override
	public Status getStatus(String id, Set<StatusField> fields) {
		return get(ObjectType.STATUS, id, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getStatuses(java.util.List, java.util.Set)
	 */
	@Override
	public Map<String, Status> getStatuses(List<String> ids,
			Set<StatusField> fields) {
		return get(ObjectType.STATUS, ids, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getUser(java.lang.String, java.util.Set)
	 */
	@Override
	public User getUser(String id, Set<UserField> fields) {
		return get(ObjectType.USER, id, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getUsers(java.util.List, java.util.Set)
	 */
	@Override
	public Map<String, User> getUsers(List<String> ids, Set<UserField> fields) {
		return get(ObjectType.USER, ids, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getVideo(java.lang.String, java.util.Set)
	 */
	@Override
	public Video getVideo(String id, Set<VideoField> fields) {
		return get(ObjectType.VIDEO, id, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getVideos(java.util.List, java.util.Set)
	 */
	@Override
	public Map<String, Video> getVideos(List<String> ids, Set<VideoField> fields) {
		return get(ObjectType.VIDEO, ids, fields);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getAlbumConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.AlbumConnection)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getAlbumConnections(String id,
			AlbumConnection connectionType) {
		return getConnections(ObjectType.ALBUM, id, connectionType);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getAlbumConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.AlbumConnection, com.google.code.facebook.graph.common.FacebookGraphAccessObject.Paging, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getAlbumConnections(String id,
			AlbumConnection connectionType, Paging paging, TimePeriod timePeriod) {
		return getConnections(ObjectType.ALBUM, id, connectionType, paging, timePeriod);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getEventConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.EventConnection)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getEventConnections(String id,
			EventConnection connectionType) {
		return getConnections(ObjectType.EVENT, id, connectionType);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getEventConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.EventConnection, com.google.code.facebook.graph.common.FacebookGraphAccessObject.Paging, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getEventConnections(String id,
			EventConnection connectionType, Paging paging, TimePeriod timePeriod) {
		return getConnections(ObjectType.EVENT, id, connectionType, paging, timePeriod);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getGroupConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.GroupConnection)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getGroupConnections(String id,
			GroupConnection connectionType) {
		return getConnections(ObjectType.GROUP, id, connectionType);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getGroupConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.GroupConnection, com.google.code.facebook.graph.common.FacebookGraphAccessObject.Paging, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getGroupConnections(String id,
			GroupConnection connectionType, Paging paging, TimePeriod timePeriod) {
		return getConnections(ObjectType.GROUP, id, connectionType, paging, timePeriod);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getLinkConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.LinkConnection)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getLinkConnections(String id,
			LinkConnection connectionType) {
		return getConnections(ObjectType.LINK, id, connectionType);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getLinkConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.LinkConnection, com.google.code.facebook.graph.common.FacebookGraphAccessObject.Paging, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getLinkConnections(String id,
			LinkConnection connectionType, Paging paging, TimePeriod timePeriod) {
		return getConnections(ObjectType.LINK, id, connectionType, paging, timePeriod);
	}
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getNoteConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.NoteConnection)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getNoteConnections(String id,
			NoteConnection connectionType) {
		return getConnections(ObjectType.NOTE, id, connectionType);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getNoteConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.NoteConnection, com.google.code.facebook.graph.common.FacebookGraphAccessObject.Paging, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getNoteConnections(String id,
			NoteConnection connectionType, Paging paging, TimePeriod timePeriod) {
		return getConnections(ObjectType.NOTE, id, connectionType, paging, timePeriod);
	}
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getPageConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.PageConnection)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getPageConnections(String id,
			PageConnection connectionType) {
		return getConnections(ObjectType.PAGE, id, connectionType);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getPageConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.PageConnection, com.google.code.facebook.graph.common.FacebookGraphAccessObject.Paging, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getPageConnections(String id,
			PageConnection connectionType, Paging paging, TimePeriod timePeriod) {
		return getConnections(ObjectType.PAGE, id, connectionType, paging, timePeriod);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getPhotoConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.PhotoConnection)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getPhotoConnections(String id,
			PhotoConnection connectionType) {
		return getConnections(ObjectType.PHOTO, id, connectionType);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getPhotoConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.PhotoConnection, com.google.code.facebook.graph.common.FacebookGraphAccessObject.Paging, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getPhotoConnections(String id,
			PhotoConnection connectionType, Paging paging, TimePeriod timePeriod) {
		return getConnections(ObjectType.PHOTO, id, connectionType, paging, timePeriod);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getPostConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.PostConnection)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getPostConnections(String id,
			PostConnection connectionType) {
		return getConnections(ObjectType.POST, id, connectionType);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getPostConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.PostConnection, com.google.code.facebook.graph.common.FacebookGraphAccessObject.Paging, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getPostConnections(String id,
			PostConnection connectionType, Paging paging, TimePeriod timePeriod) {
		return getConnections(ObjectType.POST, id, connectionType, paging, timePeriod);
	}
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getStatusConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.StatusConnection)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getStatusConnections(String id,
			StatusConnection connectionType) {
		return getConnections(ObjectType.STATUS, id, connectionType);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getStatusConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.StatusConnection, com.google.code.facebook.graph.common.FacebookGraphAccessObject.Paging, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getStatusConnections(String id,
			StatusConnection connectionType, Paging paging, TimePeriod timePeriod) {
		return getConnections(ObjectType.STATUS, id, connectionType, paging, timePeriod);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getUserConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.UserConnection)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getUserConnections(String id,
			UserConnection connectionType) {
		return getConnections(ObjectType.USER, id, connectionType);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getUserConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.UserConnection, com.google.code.facebook.graph.common.FacebookGraphAccessObject.Paging, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getUserConnections(String id,
			UserConnection connectionType, Paging paging, TimePeriod timePeriod) {
		return getConnections(ObjectType.USER, id, connectionType, paging, timePeriod);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getVideoConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.VideoConnection)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getVideoConnections(String id,
			VideoConnection connectionType) {
		return getConnections(ObjectType.VIDEO, id, connectionType);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getVideoConnections(java.lang.String, com.google.code.facebook.graph.model.enumeration.VideoConnection, com.google.code.facebook.graph.common.FacebookGraphAccessObject.Paging, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	@Override
	public <T extends Entity<?, ?>> PagedList<T> getVideoConnections(String id,
			VideoConnection connectionType, Paging paging, TimePeriod timePeriod) {
		return getConnections(ObjectType.VIDEO, id, connectionType, paging, timePeriod);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#attendEvent(java.lang.String)
	 */
	@Override
	public void attendEvent(String eventId) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_ATTEND_EVENT_URL);
		builder.withId(eventId);
		Map<String, String> parameters = createPostParameters();
		callApiPost(builder.buildUrl(), parameters);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#createAlbum(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Album createAlbum(String userId, String name, String message) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_CREATE_ALBUM_URL);
		builder.withId(userId);
		Map<String, String> parameters = createPostParameters();
		parameters.put(ParameterNames.NAME, name);
		parameters.put(ParameterNames.MESSAGE, message);
		return readResponse(Album.class, callApiPost(builder.buildUrl(), parameters));
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#createEvent(java.lang.String, java.lang.String, java.util.Date, java.util.Date)
	 */
	@Override
	public Event createEvent(String userId, String name, Date startTime,
			Date endTime) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_CREATE_EVENT_URL);
		builder.withId(userId);
		Map<String, String> parameters = createPostParameters();
		parameters.put(ParameterNames.NAME, name);
		parameters.put(ParameterNames.START_TIME, String.valueOf(startTime.getTime() / 1000L));
		parameters.put(ParameterNames.END_TIME, String.valueOf(endTime.getTime() / 1000L));
		return readResponse(Event.class, callApiPost(builder.buildUrl(), parameters));
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#declineEvent(java.lang.String)
	 */
	@Override
	public void declineEvent(String eventId) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_DECLINE_EVENT_URL);
		builder.withId(eventId);
		Map<String, String> parameters = createPostParameters();
		callApiPost(builder.buildUrl(), parameters);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#likePost(java.lang.String)
	 */
	@Override
	public void likePost(String postId) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_LIKE_POST_URL);
		builder.withId(postId);
		Map<String, String> parameters = createPostParameters();
		callApiPost(builder.buildUrl(), parameters);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#maybeAttendEvent(java.lang.String)
	 */
	@Override
	public void maybeAttendEvent(String eventId) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_MAYBE_ATTEND_EVENT_URL);
		builder.withId(eventId);
		Map<String, String> parameters = createPostParameters();
		callApiPost(builder.buildUrl(), parameters);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#postComment(java.lang.String, java.lang.String)
	 */
	@Override
	public Post postComment(String postId, String message) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_POST_COMMENT_URL);
		builder.withId(postId);
		Map<String, String> parameters = createPostParameters();
		parameters.put(ParameterNames.MESSAGE, message);
		return readResponse(Post.class, callApiPost(builder.buildUrl(), parameters));
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#postFeed(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Post postFeed(String userId, String message, String picture,
			String link, String name, String description) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_POST_FEED_URL);
		builder.withId(userId);
		Map<String, String> parameters = createPostParameters();
		parameters.put(ParameterNames.MESSAGE, message);
		parameters.put(ParameterNames.PICTURE, picture);
		parameters.put(ParameterNames.LINK, link);
		parameters.put(ParameterNames.NAME, name);
		parameters.put(ParameterNames.DESCRIPTION, description);
		return readResponse(Post.class, callApiPost(builder.buildUrl(), parameters));
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#postLink(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Link postLink(String userId, String link, String message) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_POST_LINK_URL);
		builder.withId(userId);
		Map<String, String> parameters = createPostParameters();
		parameters.put(ParameterNames.MESSAGE, message);
		parameters.put(ParameterNames.LINK, link);
		return readResponse(Link.class, callApiPost(builder.buildUrl(), parameters));
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#postNote(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Note postNote(String userId, String message, String subject) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_POST_NOTE_URL);
		builder.withId(userId);
		Map<String, String> parameters = createPostParameters();
		parameters.put(ParameterNames.MESSAGE, message);
		parameters.put(ParameterNames.SUBJECT, subject);
		return readResponse(Note.class, callApiPost(builder.buildUrl(), parameters));
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#unlikePost(java.lang.String)
	 */
	@Override
	public void unlikePost(String postId) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_LIKE_POST_URL);
		builder.withId(postId);
		callApiDelete(builder.buildUrl());
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#uploadPhoto(java.lang.String, java.lang.String)
	 */
	@Override
	public Photo uploadPhoto(String albumId, String message) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_UPLOAD_PHOTO_URL);
		builder.withId(albumId);
		Map<String, String> parameters = createPostParameters();
		parameters.put(ParameterNames.MESSAGE, message);
		return readResponse(Photo.class, callApiPost(builder.buildUrl(), parameters));
	}
	
	/**
	 * Creates the post parameters.
	 * 
	 * @return the map< string, string>
	 */
	protected Map<String, String> createPostParameters() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(ParameterNames.ACCESS_TOKEN, getAccessToken());
		return parameters;
	}
	
	/**
	 * Search.
	 * 
	 * @param query the query
	 * @param type the type
	 * @param paging the paging
	 * @param timePeriod the time period
	 * 
	 * @return the list< t>
	 */
	@SuppressWarnings("unchecked")
	protected <T extends Entity<?, ?>> PagedList<T> search(String query, ObjectType type, Paging paging, TimePeriod timePeriod) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_SEARCH_URL);
		builder.withParameter(ParameterNames.QUERY, query).withParameterEnum(ParameterNames.TYPE, type);
		builder.withPaging(paging).withTimePeriod(timePeriod);
		return (PagedList<T>) readListResponse(type.type(), callApiGet(builder.buildUrl()));
	}
	
	// Search Methods
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#searchPosts(java.lang.String)
	 */
	public PagedList<Post> searchPosts(String query) {
		return search(query, ObjectType.POST, null, null);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#searchPosts(java.lang.String, com.google.code.facebook.graph.common.FacebookGraphAccessObject.Paging, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	public PagedList<Post> searchPosts(String query, Paging paging, TimePeriod timePeriod) {
		return search(query, ObjectType.POST, paging, timePeriod);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#searchPeople(java.lang.String)
	 */
	public PagedList<User> searchPeople(String query) {
		return search(query, ObjectType.USER, null, null);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#searchPeople(java.lang.String, com.google.code.facebook.graph.common.FacebookGraphAccessObject.Paging, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	public PagedList<User> searchPeople(String query, Paging paging, TimePeriod timePeriod) {
		return search(query, ObjectType.USER, paging, timePeriod);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#searchPages(java.lang.String)
	 */
	public PagedList<Page> searchPages(String query) {
		return search(query, ObjectType.PAGE, null, null);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#searchPages(java.lang.String, com.google.code.facebook.graph.common.FacebookGraphAccessObject.Paging, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	public PagedList<Page> searchPages(String query, Paging paging, TimePeriod timePeriod) {
		return search(query, ObjectType.PAGE, paging, timePeriod);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#searchEvents(java.lang.String)
	 */
	public PagedList<Event> searchEvents(String query) {
		return search(query, ObjectType.EVENT, null, null);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#searchEvents(java.lang.String, com.google.code.facebook.graph.common.FacebookGraphAccessObject.Paging, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	public PagedList<Event> searchEvents(String query, Paging paging, TimePeriod timePeriod) {
		return search(query, ObjectType.EVENT, paging, timePeriod);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#searchGroups(java.lang.String)
	 */
	public PagedList<Group> searchGroups(String query) {
		return search(query, ObjectType.GROUP, null, null);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#searchGroups(java.lang.String, com.google.code.facebook.graph.common.FacebookGraphAccessObject.Paging, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	public PagedList<Group> searchGroups(String query, Paging paging, TimePeriod timePeriod) {
		return search(query, ObjectType.GROUP, paging, timePeriod);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#searchNewsFeed(java.lang.String)
	 */
	public PagedList<Post> searchNewsFeed(String query) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_SEARCH_NEWS_FEED_URL);
		builder.withParameter(ParameterNames.QUERY, query);
		return readListResponse(Post.class, callApiGet(builder.buildUrl()));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#searchNewsFeed(java.lang.String, com.google.code.facebook.graph.common.FacebookGraphAccessObject.Paging, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	public PagedList<Post> searchNewsFeed(String query, Paging paging, TimePeriod timePeriod) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_SEARCH_NEWS_FEED_URL);
		builder.withParameter(ParameterNames.QUERY, query).withPaging(paging).withTimePeriod(timePeriod);
		return readListResponse(Post.class, callApiGet(builder.buildUrl()));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.common.FacebookGraphAccessObject#fetchData(java.lang.Class, java.lang.String)
	 */
	public <T> List<T> fetchData(Class<T> clazz, String url) {
		return readListResponse(clazz, callApiGet(url));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getApplicationInsights(java.lang.String)
	 */
	public List<Insight> getApplicationInsights(String applicationId) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_ANALYTICS_URL);
		builder.withId(applicationId);
		return readListResponse(Insight.class, callApiGet(builder.buildUrl()));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getApplicationInsights(java.lang.String, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	public List<Insight> getApplicationInsights(String applicationId, TimePeriod timePeriod) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_ANALYTICS_URL);
		builder.withId(applicationId).withTimePeriod(timePeriod);
		return readListResponse(Insight.class, callApiGet(builder.buildUrl()));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getApplicationInsight(java.lang.String)
	 */
	public Insight getApplicationInsight(String insightId) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_OBJECT_URL);
		builder.withId(insightId);
		return readResponse(Insight.class, callApiGet(builder.buildUrl()));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getApplicationInsight(java.lang.String, com.google.code.facebook.graph.common.FacebookGraphAccessObject.TimePeriod)
	 */
	public Insight getApplicationInsight(String insightId, TimePeriod timePeriod) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_OBJECT_URL);
		builder.withId(insightId).withTimePeriod(timePeriod);
		return readResponse(Insight.class, callApiGet(builder.buildUrl()));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#subscribe(java.lang.String, com.google.code.facebook.graph.model.enumeration.SubscriptionType, java.util.Set, java.lang.String, java.lang.String)
	 */
	public void subscribe(String applicationId, SubscriptionType object, Set<? extends ValueEnum> fields, String callbackUrl, String verifyToken) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_SUBSCRIPTIONS_URL);
		builder.withId(applicationId);
		StringBuilder buffer = new StringBuilder();
		for (Iterator<? extends ValueEnum> iterator = fields.iterator(); iterator.hasNext();) {
			buffer.append(iterator.next().value());
			if (iterator.hasNext()) {
				buffer.append(",");
			}
		}
		Map<String, String> parameters = createPostParameters();
		parameters.put(ParameterNames.OBJECT, object.value());
		parameters.put(ParameterNames.FIELDS, buffer.toString());
		parameters.put(ParameterNames.CALLBACK_URL, callbackUrl);
		parameters.put(ParameterNames.VERIFY_TOKEN, verifyToken);
		callApiPost(builder.buildUrl(), parameters);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#getSubscriptions(java.lang.String)
	 */
	public List<Subscription> getSubscriptions(String applicationId) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_SUBSCRIPTIONS_URL);
		builder.withId(applicationId);
		return readListResponse(Subscription.class, callApiGet(builder.buildUrl()));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#deleteSubscriptions(java.lang.String)
	 */
	public void deleteSubscriptions(String applicationId) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_SUBSCRIPTIONS_URL);
		builder.withId(applicationId);
		callApiDelete(builder.buildUrl());
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookGraphApiClient#deleteSubscription(java.lang.String, com.google.code.facebook.graph.model.enumeration.SubscriptionType)
	 */
	public void deleteSubscription(String applicationId, SubscriptionType object) {
		FacebookGraphApiUrlBuilder builder = createFacebookGraphApiUrlBuilder(FacebookGraphApiUrls.FACEBOOK_GRAPH_API_SUBSCRIPTIONS_URL);
		builder.withId(applicationId).withParameterEnum(ParameterNames.OBJECT, object);
		callApiDelete(builder.buildUrl());
	}
}
