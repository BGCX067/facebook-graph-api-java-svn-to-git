/*
 * 
 */
package com.google.code.facebook.graph.client;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.code.facebook.graph.client.constant.TestConstants;
import com.google.code.facebook.graph.client.oauth.FacebookApiConsumer;
import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.Album;
import com.google.code.facebook.graph.model.Event;
import com.google.code.facebook.graph.model.Group;
import com.google.code.facebook.graph.model.Insight;
import com.google.code.facebook.graph.model.Link;
import com.google.code.facebook.graph.model.Note;
import com.google.code.facebook.graph.model.Page;
import com.google.code.facebook.graph.model.Photo;
import com.google.code.facebook.graph.model.Post;
import com.google.code.facebook.graph.model.Status;
import com.google.code.facebook.graph.model.User;
import com.google.code.facebook.graph.model.Video;
import com.google.code.facebook.graph.model.enumeration.ObjectType;

/**
 * The Class FacebookGraphApiClientTest.
 */
public class FacebookGraphApiClientTest extends BaseFacebookGraphApiTestCase {

	/** The client. */
	private FacebookGraphApiClient client;
    
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.BaseFacebookGraphApiTestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test consumer key."), TestConstants.TEST_CONSUMER_KEY);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test consumer secret."), TestConstants.TEST_CONSUMER_SECRET);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Access Token."), TestConstants.TEST_ACCESS_TOKEN);
		
		client = FacebookGraphApiClientFactory.newInstance(new FacebookApiConsumer(TestConstants.TEST_CONSUMER_KEY, TestConstants.TEST_CONSUMER_SECRET)).createFacebookGraphApiClient(TestConstants.TEST_ACCESS_TOKEN);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.BaseFacebookGraphApiTestCase#tearDown()
	 */
	@After
	public void tearDown() throws Exception {
		client = null;
	}

	/**
	 * Test get album.
	 */
	@Test
	public void testGetAlbum() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test album id."), TestConstants.TEST_ALBUM_IDS);
		Album album = client.getAlbum(getIds(TestConstants.TEST_ALBUM_IDS)[0]);
		assertNotNull("Album should not be null.", album);
		assertNotNull("Album From should not be null.", album.getFrom());
	}

	/**
	 * Test get albums.
	 */
	@Test
	public void testGetAlbums() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test album id."), TestConstants.TEST_ALBUM_IDS);
		Map<String, Album> albums = client.getAlbums(Arrays.asList(getIds(TestConstants.TEST_ALBUM_IDS)) );
		assertNotNullOrEmpty("Albums should not be null.", albums);
		for (Album album : albums.values()) {
			assertNotNull("Album From should not be null.", album.getFrom());
		}
	}

	/**
	 * Test get event.
	 */
	@Test
	public void testGetEvent() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test event id."), TestConstants.TEST_EVENT_IDS);
		Event event = client.getEvent(getIds(TestConstants.TEST_EVENT_IDS)[0]);
		assertNotNull("Event should not be null.", event);
		assertNotNull("Event Owner should not be null.", event.getOwner());
		assertNotNull("Event Venue should not be null.", event.getVenue());
	}

	/**
	 * Test get events.
	 */
	@Test
	public void testGetEvents() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test event id."), TestConstants.TEST_EVENT_IDS);
		Map<String, Event> events = client.getEvents(Arrays.asList(getIds(TestConstants.TEST_EVENT_IDS)) );
		assertNotNullOrEmpty("Events should not be null.", events);
		for (Event event : events.values()) {
			assertNotNull("Event Owner should not be null.", event.getOwner());
			assertNotNull("Event Venue should not be null.", event.getVenue());
		}
	}

	/**
	 * Test get group.
	 */
	@Test
	public void testGetGroup() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test group id."), TestConstants.TEST_GROUP_IDS);
		Group group = client.getGroup(getIds(TestConstants.TEST_GROUP_IDS)[0]);
		assertNotNull("Group should not be null.", group);
		assertNotNull("Group Owner should not be null.", group.getOwner());
//		assertNotNull("Group Venue should not be null.", group.getVenue());
	}

	/**
	 * Test get groups.
	 */
	@Test
	public void testGetGroups() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test group id."), TestConstants.TEST_GROUP_IDS);
		Map<String, Group> groups = client.getGroups(Arrays.asList(getIds(TestConstants.TEST_GROUP_IDS)) );
		assertNotNullOrEmpty("Groups should not be null.", groups);
		for (Group group : groups.values()) {
			assertNotNull("Group Owner should not be null.", group.getOwner());
//			assertNotNull("Group Venue should not be null.", group.getVenue());
		}
	}

	/**
	 * Test get link.
	 */
	@Test
	public void testGetLink() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test link id."), TestConstants.TEST_LINK_IDS);
		Link link = client.getLink(getIds(TestConstants.TEST_LINK_IDS)[0]);
		assertNotNull("Link should not be null.", link);
		assertNotNull("Link From should not be null.", link.getFrom());
	}

	/**
	 * Test get links.
	 */
	@Test
	public void testGetLinks() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test link id."), TestConstants.TEST_LINK_IDS);
		Map<String, Link> links = client.getLinks(Arrays.asList(getIds(TestConstants.TEST_LINK_IDS)) );
		assertNotNullOrEmpty("Links should not be null.", links);
	}

	/**
	 * Test get note.
	 */
	@Test
	public void testGetNote() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test note id."), TestConstants.TEST_NOTE_IDS);
		Note note = client.getNote(getIds(TestConstants.TEST_NOTE_IDS)[0]);
		assertNotNull("Note should not be null.", note);
		assertNotNull("Note From should not be null.", note.getFrom());
	}

	/**
	 * Test get notes.
	 */
	@Test
	public void testGetNotes() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test note id."), TestConstants.TEST_NOTE_IDS);
		Map<String, Note> notes = client.getNotes(Arrays.asList(getIds(TestConstants.TEST_NOTE_IDS)) );
		assertNotNullOrEmpty("Notes should not be null.", notes);
	}

	/**
	 * Test get page.
	 */
	@Test
	public void testGetPage() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test page id."), TestConstants.TEST_PAGE_IDS);
		Page page = client.getPage(getIds(TestConstants.TEST_PAGE_IDS)[0]);
		assertNotNull("Page should not be null.", page);
//		assertNotNull("Page Location should not be null.", page.getLocation());
	}

	/**
	 * Test get pages.
	 */
	@Test
	public void testGetPages() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test page id."), TestConstants.TEST_PAGE_IDS);
		Map<String, Page> pages = client.getPages(Arrays.asList(getIds(TestConstants.TEST_PAGE_IDS)) );
		assertNotNullOrEmpty("Pages should not be null.", pages);
	}

	/**
	 * Test get photo.
	 */
	@Test
	public void testGetPhoto() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test photo id."), TestConstants.TEST_PHOTO_IDS);
		Photo photo = client.getPhoto(getIds(TestConstants.TEST_PHOTO_IDS)[0]);
		assertNotNull("Photo should not be null.", photo);
		assertNotNull("Photo From should not be null.", photo.getFrom());
	}

	/**
	 * Test get photos.
	 */
	@Test
	public void testGetPhotos() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test photo id."), TestConstants.TEST_PHOTO_IDS);
		Map<String, Photo> photos = client.getPhotos(Arrays.asList(getIds(TestConstants.TEST_PHOTO_IDS)) );
		assertNotNullOrEmpty("Photos should not be null.", photos);
	}

	/**
	 * Test get post.
	 */
	@Test
	public void testGetPost() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test post id."), TestConstants.TEST_POST_IDS);
		Post post = client.getPost(getIds(TestConstants.TEST_POST_IDS)[0]);
		assertNotNull("Post should not be null.", post);
		assertNotNull("Post From should not be null.", post.getFrom());
	}

	/**
	 * Test get posts.
	 */
	@Test
	public void testGetPosts() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test post id."), TestConstants.TEST_POST_IDS);
		Map<String, Post> posts = client.getPosts(Arrays.asList(getIds(TestConstants.TEST_POST_IDS)) );
		assertNotNullOrEmpty("Posts should not be null.", posts);
	}

	/**
	 * Test get status message.
	 */
	@Test
	public void testGetStatusMessage() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test status message id."), TestConstants.TEST_STATUS_MESSAGE_IDS);
		Status status = client.getStatus(getIds(TestConstants.TEST_STATUS_MESSAGE_IDS)[0]);
		assertNotNull("Status message should not be null.", status);
		assertNotNull("Status From should not be null.", status.getFrom());
	}

	/**
	 * Test get status messages.
	 */
	@Test
	public void testGetStatusMessages() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test status message id."), TestConstants.TEST_STATUS_MESSAGE_IDS);
		Map<String, Status> statuses = client.getStatuses(Arrays.asList(getIds(TestConstants.TEST_STATUS_MESSAGE_IDS)) );
		assertNotNullOrEmpty("Status messages should not be null.", statuses);
	}

	/**
	 * Test get user.
	 */
	@Test
	public void testGetUser() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test user id."), TestConstants.TEST_USER_IDS);
		User user = client.getUser(getIds(TestConstants.TEST_USER_IDS)[0]);
		assertNotNull("User should not be null.", user);
		assertNotNull("User name should not be null.", user.getName());
	}

	/**
	 * Test get users.
	 */
	@Test
	public void testGetUsers() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test user id."), TestConstants.TEST_USER_IDS);
		Map<String, User> users = client.getUsers(Arrays.asList(getIds(TestConstants.TEST_USER_IDS)) );
		assertNotNullOrEmpty("Users should not be null.", users);
	}

	/**
	 * Test get video.
	 */
	@Test
	public void testGetVideo() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test video id."), TestConstants.TEST_VIDEO_IDS);
		Video video = client.getVideo(getIds(TestConstants.TEST_VIDEO_IDS)[0]);
		assertNotNull("Video should not be null.", video);
		assertNotNull("Video From should not be null.", video.getFrom());
	}

	/**
	 * Test get videos.
	 */
	@Test
	public void testGetVideos() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test video id."), TestConstants.TEST_VIDEO_IDS);
		Map<String, Video> videos = client.getVideos(Arrays.asList(getIds(TestConstants.TEST_VIDEO_IDS)) );
		assertNotNullOrEmpty("Videos should not be null.", videos);
	}

	/**
	 * Test get string.
	 */
	@Test
	public void testGetString() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test user id."), TestConstants.TEST_USER_IDS);
		User user = client.get(getIds(TestConstants.TEST_USER_IDS)[0]);
		assertNotNull("User should not be null.", user);
		assertNotNull("User name should not be null.", user.getName());
	}

	/**
	 * Test get list of string.
	 */
	@Test
	public void testGetListOfString() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test user id."), TestConstants.TEST_USER_IDS);
		Map<String, User> users = client.get(Arrays.asList(getIds(TestConstants.TEST_USER_IDS)) );
		assertNotNullOrEmpty("Users should not be null.", users);
	}

	/**
	 * Test get object type string.
	 */
	@Test
	public void testGetObjectTypeString() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test video id."), TestConstants.TEST_VIDEO_IDS);
		Video video = client.get(ObjectType.VIDEO, getIds(TestConstants.TEST_VIDEO_IDS)[0]);
		assertNotNull("Video should not be null.", video);
		assertNotNull("Video From should not be null.", video.getFrom());
	}

	/**
	 * Test get object type list of string.
	 */
	@Test
	public void testGetObjectTypeListOfString() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test video id."), TestConstants.TEST_VIDEO_IDS);
		Map<String, Video> videos = client.get(ObjectType.VIDEO, Arrays.asList(getIds(TestConstants.TEST_VIDEO_IDS)) );
		assertNotNullOrEmpty("Videos should not be null.", videos);
	}
	
	/**
	 * Test like post.
	 */
	@Test
	public void testLikePost() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test post id."), TestConstants.TEST_POST_IDS);
//		client.likePost(getIds(TestConstants.TEST_POST_IDS)[0]);
//    	client.postFeed(User.ME, "Testing facebook graph api.", null, null, null, null);
	}
	
	/**
	 * Test load string.
	 */
	@Test
	public void testLoadString() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test user id."), TestConstants.TEST_USER_IDS);
		User user = client.load(getIds(TestConstants.TEST_USER_IDS)[0]);
		assertNotNull("User should not be null.", user);
		assertNotNull("User name should not be null.", user.getName());
		assertNotNullOrEmpty("User friends should not be empty.", user.getFriends());
		assertNotNullOrEmpty("User feed should not be empty.", user.getFeed());
	}
	
	/**
	 * Test search posts string.
	 */
	@Test
	public void testSearchPostsString() {
		PagedList<Post> result = client.searchPosts("watermelon");
		assertNotNullOrEmpty("Search result cannot be null or empty.", result);
	}
	
	/**
	 * Test search people string.
	 */
	@Test
	public void testSearchPeopleString() {
		PagedList<User> result = client.searchPeople("mark");
		assertNotNullOrEmpty("Search result cannot be null or empty.", result);
	}
	
	/**
	 * Test search pages string.
	 */
	@Test
	public void testSearchPagesString() {
		PagedList<Page> result = client.searchPages("platform");
		assertNotNullOrEmpty("Search result cannot be null or empty.", result);
	}
	
	/**
	 * Test search events string.
	 */
	@Test
	public void testSearchEventsString() {
		PagedList<Event> result = client.searchEvents("conference");
		assertNotNullOrEmpty("Search result cannot be null or empty.", result);
	}
	
	/**
	 * Test search groups string.
	 */
	@Test
	public void testSearchGroupsString() {
		PagedList<Group> result = client.searchGroups("programming");
		assertNotNullOrEmpty("Search result cannot be null or empty.", result);
	}
	
	/**
	 * Test search news feed string.
	 */
	@Test
	public void testSearchNewsFeedString() {
		PagedList<Post> result = client.searchNewsFeed("facebook");
		assertNotNullOrEmpty("Search result cannot be null or empty.", result);
	}
	
	@Test
	public void testGetApplicationInsightsString() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test application id."), TestConstants.TEST_APPLICATION_IDS);
		List<Insight> result = client.getApplicationInsights(getIds(TestConstants.TEST_APPLICATION_IDS)[0]);
		assertNotNullOrEmpty("Application insights cannot be null or empty.", result);
		for (Insight insight : result) {
			assertNotNullOrEmpty("Application insights cannot be null or empty.", insight.getName());
			assertNotNullOrEmpty("Application insights cannot be null or empty.", insight.getValues());
		}
	}
}
