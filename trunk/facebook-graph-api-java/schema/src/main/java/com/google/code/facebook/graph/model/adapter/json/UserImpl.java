/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.Album;
import com.google.code.facebook.graph.model.Education;
import com.google.code.facebook.graph.model.Event;
import com.google.code.facebook.graph.model.GraphObserver;
import com.google.code.facebook.graph.model.Group;
import com.google.code.facebook.graph.model.Link;
import com.google.code.facebook.graph.model.Note;
import com.google.code.facebook.graph.model.Page;
import com.google.code.facebook.graph.model.Photo;
import com.google.code.facebook.graph.model.Post;
import com.google.code.facebook.graph.model.Status;
import com.google.code.facebook.graph.model.Stream;
import com.google.code.facebook.graph.model.User;
import com.google.code.facebook.graph.model.UserChange;
import com.google.code.facebook.graph.model.Video;
import com.google.code.facebook.graph.model.Work;
import com.google.code.facebook.graph.model.enumeration.Gender;
import com.google.code.facebook.graph.model.enumeration.ObjectType;
import com.google.code.facebook.graph.model.enumeration.UserConnection;

/**
 * The Class UserImpl.
 */
public class UserImpl extends BaseAuthor implements User, GraphObserver<UserChange> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5919335274028692108L;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The link. */
	private String link;
	
	/** The about. */
	private String about;
	
	/** The birthday. */
	private String birthday;
	
	/** The work. */
	private List<Work> work = new ArrayList<Work>();
	
	/** The education. */
	private List<Education> education = new ArrayList<Education>();
	
	/** The email. */
	private String email;
	
	/** The website. */
	private String website;
	
	/** The timezone. */
	private int timezone;
	
	/** The verified. */
	private boolean verified;
	
	/** The updated time. */
	private Date updatedTime;
	
	/** The religion. */
	private String religion;
	
	/** The relationship status. */
	private String relationshipStatus;
	
	private Gender gender;
	
	private Page location;
	
	/** The interested in. */
	private List<String> interestedIn = new ArrayList<String>();
	
	/** The meeting for. */
	private List<String> meetingFor = new ArrayList<String>();
	
//	private List<Post> home;
//	private List<Post> feed;
//	private List<? extends Stream<?, ?>> tagged;
//	private List<Post> posts;
//	private List<User> friends;
//	private List<Page> activities;
//	private List<Page> interests;
//	private List<Page> music;
//	private List<Page> books;
//	private List<Page> movies;
//	private List<Page> television;
//	private List<Page> likes;
//	private List<Photo> photos;
//	private List<Album> albums;
//	private List<Video> videos;
//	private List<Group> groups;
//	private List<Status> statuses;
//	private List<Link> links;
//	private List<Note> notes;
//	private List<Event> events;
//	private List<Post> inbox;
//	private List<Post> outbox;
//	private List<Post> updates;
	
	public UserImpl() {
		super();
		setType(ObjectType.USER);
	}
	
	/**
 * Sets the first name.
 * 
 * @param firstName the new first name
 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Sets the last name.
	 * 
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Sets the link.
	 * 
	 * @param link the new link
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
	/**
	 * Sets the about.
	 * 
	 * @param about the new about
	 */
	public void setAbout(String about) {
		this.about = about;
	}
	
	/**
	 * Sets the birthday.
	 * 
	 * @param birthday the new birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * Sets the work.
	 * 
	 * @param work the new work
	 */
	public void setWork(List<Work> work) {
		this.work = work;
	}
	
	/**
	 * Sets the education.
	 * 
	 * @param education the new education
	 */
	public void setEducation(List<Education> education) {
		this.education = education;
	}
	
	/**
	 * Sets the email.
	 * 
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Sets the website.
	 * 
	 * @param website the new website
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getFirstName()
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getLastName()
	 */
	public String getLastName() {
		return lastName;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getLink()
	 */
	public String getLink() {
		return link;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getAbout()
	 */
	public String getAbout() {
		return about;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getBirthday()
	 */
	public String getBirthday() {
		return birthday;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getWork()
	 */
	public List<Work> getWork() {
		return work;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getEducation()
	 */
	public List<Education> getEducation() {
		return education;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getEmail()
	 */
	public String getEmail() {
		return email;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getWebsite()
	 */
	public String getWebsite() {
		return website;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getTimezone()
	 */
	public int getTimezone() {
		return timezone;
	}
	
	/**
	 * Sets the timezone.
	 * 
	 * @param timezone the new timezone
	 */
	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#isVerified()
	 */
	public boolean isVerified() {
		return verified;
	}
	
	/**
	 * Sets the verified.
	 * 
	 * @param verified the new verified
	 */
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getUpdatedTime()
	 */
	public Date getUpdatedTime() {
		return updatedTime;
	}
	
	/**
	 * Sets the updated time.
	 * 
	 * @param updatedTime the new updated time
	 */
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getReligion()
	 */
	public String getReligion() {
		return religion;
	}
	
	/**
	 * Sets the religion.
	 * 
	 * @param religion the new religion
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getRelationshipStatus()
	 */
	public String getRelationshipStatus() {
		return relationshipStatus;
	}
	
	/**
	 * Sets the relationship status.
	 * 
	 * @param relationshipStatus the new relationship status
	 */
	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getInterestedIn()
	 */
	public List<String> getInterestedIn() {
		return interestedIn;
	}
	
	/**
	 * Sets the interested in.
	 * 
	 * @param interestedIn the new interested in
	 */
	public void setInterestedIn(List<String> interestedIn) {
		this.interestedIn = interestedIn;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getMeetingFor()
	 */
	public List<String> getMeetingFor() {
		return meetingFor;
	}
	
	/**
	 * Sets the meeting for.
	 * 
	 * @param meetingFor the new meeting for
	 */
	public void setMeetingFor(List<String> meetingFor) {
		this.meetingFor = meetingFor;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getHome()
	 */
	public PagedList<Post> getHome() {
		return getConnections(UserConnection.HOME);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getFeed()
	 */
	public PagedList<Post> getFeed() {
		return getConnections(UserConnection.FEED);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getTagged()
	 */
	public PagedList<? extends Stream<?, ?>> getTagged() {
		return getConnections(UserConnection.TAGGED);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getPosts()
	 */
	public PagedList<Post> getPosts() {
		return getConnections(UserConnection.POSTS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getFriends()
	 */
	public PagedList<User> getFriends() {
		return getConnections(UserConnection.FRIENDS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getFamily()
	 */
	public PagedList<User> getFamily() {
		return getConnections(UserConnection.FAMILY);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getActivities()
	 */
	public PagedList<Page> getActivities() {
		return getConnections(UserConnection.ACTIVITIES);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getInterests()
	 */
	public PagedList<Page> getInterests() {
		return getConnections(UserConnection.INTERESTS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getMusic()
	 */
	public PagedList<Page> getMusic() {
		return getConnections(UserConnection.MUSIC);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getBooks()
	 */
	public PagedList<Page> getBooks() {
		return getConnections(UserConnection.BOOKS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getMovies()
	 */
	public PagedList<Page> getMovies() {
		return getConnections(UserConnection.MOVIES);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getTelevision()
	 */
	public PagedList<Page> getTelevision() {
		return getConnections(UserConnection.TELEVISION);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getLikes()
	 */
	public PagedList<Page> getLikes() {
		return getConnections(UserConnection.LIKES);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getPhotos()
	 */
	public PagedList<Photo> getPhotos() {
		return getConnections(UserConnection.PHOTOS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getAlbums()
	 */
	public PagedList<Album> getAlbums() {
		return getConnections(UserConnection.ALBUMS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getVideos()
	 */
	public PagedList<Video> getVideos() {
		return getConnections(UserConnection.VIDEOS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getGroups()
	 */
	public PagedList<Group> getGroups() {
		return getConnections(UserConnection.GROUPS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getStatuses()
	 */
	public PagedList<Status> getStatuses() {
		return getConnections(UserConnection.STATUSES);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getLinks()
	 */
	public PagedList<Link> getLinks() {
		return getConnections(UserConnection.LINKS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getNotes()
	 */
	public PagedList<Note> getNotes() {
		return getConnections(UserConnection.NOTES);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getEvents()
	 */
	public PagedList<Event> getEvents() {
		return getConnections(UserConnection.EVENTS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getInbox()
	 */
	public PagedList<Post> getInbox() {
		return getConnections(UserConnection.INBOX);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getOutbox()
	 */
	public PagedList<Post> getOutbox() {
		return getConnections(UserConnection.OUTBOX);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.User#getUpdates()
	 */
	public PagedList<Post> getUpdates() {
		return getConnections(UserConnection.UPDATES);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.json.BaseEntity#adaptFrom(org.json.simple.JSONObject)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void adaptFrom(JSONObject adaptee) {
		super.adaptFrom(adaptee);
		JSONArray interestedJson = (JSONArray) adaptee.get("interested_in");
		if (interestedJson != null) {
			for (String interest : (List<String>) interestedJson) {
				interestedIn.add(interest);				
			}
		}
		JSONArray meetingJson = (JSONArray) adaptee.get("meeting_for");
		if (meetingJson != null) {
			for (String meeting : (List<String>) meetingJson) {
				meetingFor.add(meeting);				
			}
		}
		JSONArray workJson = (JSONArray) adaptee.get("work");
		if (workJson != null) {
			for (JSONObject obj : (List<JSONObject>) workJson) {
				WorkImpl workImpl = new WorkImpl();
				workImpl.adaptFrom(obj);
				work.add(workImpl);				
			}
		}
		JSONArray educationJson = (JSONArray) adaptee.get("education");
		if (educationJson != null) {
			for (JSONObject obj : (List<JSONObject>) educationJson) {
				EducationImpl educationImpl = new EducationImpl();
				educationImpl.adaptFrom(obj);
				education.add(educationImpl);				
			}
		}
		JSONObject locationJson = (JSONObject) adaptee.get("location");
		if (locationJson != null) {
			this.location = new PageImpl();
			((PageImpl) location).adaptFrom(locationJson);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.json.BaseJsonAdapter#adaptTo()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject adaptTo() {
		JSONObject adapter = super.adaptTo();
		JSONArray interestedJson = new JSONArray();
		for (String interest : interestedIn) {
			interestedJson.add(interest);
		}
		adapter.put("interested_in", interestedJson);
		JSONArray meetingJson = new JSONArray();
		for (String meeting : meetingFor) {
			meetingJson.add(meeting);
		}
		adapter.put("meeting_for", meetingJson);
		return adapter;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Author#getCategory()
	 */
	@Override
	public String getCategory() {
		return null;
	}

	@Override
	public void update(UserChange change) {
		// TODO Auto-generated method stub
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the location
	 */
	public Page getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Page location) {
		this.location = location;
	}

	@Override
	public String getDescription() {
		return getAbout();
	}

	@Override
	public String getLabel() {
		return getName();// + "[" + getId() + "]";
	}
}
