/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;


import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.Album;
import com.google.code.facebook.graph.model.Event;
import com.google.code.facebook.graph.model.Group;
import com.google.code.facebook.graph.model.Link;
import com.google.code.facebook.graph.model.Location;
import com.google.code.facebook.graph.model.Note;
import com.google.code.facebook.graph.model.Page;
import com.google.code.facebook.graph.model.Photo;
import com.google.code.facebook.graph.model.Post;
import com.google.code.facebook.graph.model.Status;
import com.google.code.facebook.graph.model.Stream;
import com.google.code.facebook.graph.model.Video;
import com.google.code.facebook.graph.model.enumeration.ObjectType;
import com.google.code.facebook.graph.model.enumeration.PageConnection;

/**
 * The Class PageImpl.
 */
public class PageImpl extends BaseAuthor implements Page {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1753995701132894027L;
	
	/** The category. */
	private String category;
	
	/** The fan count. */
	private int fanCount;
	
	/** The birthday. */
	private String birthday;
	
	/** The personal interests. */
	private String personalInterests;
	
	/** The location. */
	private Location location;
	
	/** The personal info. */
	private String personalInfo;
	
	/** The affiliation. */
	private String affiliation;
	
	/** The founded. */
	private String founded;
	
	/** The username. */
	private String username;
	
	/** The mission. */
	private String mission;
	
	/** The link. */
	private String link;
	
	/** The products. */
	private String products;
	
	/** The company overview. */
	private String companyOverview;
//	private List<Post> feed;
//	private List<? extends Stream<?, ?>> tagged;
//	private List<Link> links;
//	private List<Photo> photos;
//	private List<Group> groups;
//	private List<Album> albums;
//	private List<Status> statuses;
//	private List<Video> videos;
//	private List<Note> notes;
//	private List<Post> posts;
//	private List<Event> events;
	
	public PageImpl() {
		super();
		setType(ObjectType.PAGE);
	}
	
	/**
 * Sets the category.
 * 
 * @param category the new category
 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Author#getCategory()
	 */
	public String getCategory() {
		return category;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getFanCount()
	 */
	public int getFanCount() {
		return fanCount;
	}
	
	/**
	 * Sets the fan count.
	 * 
	 * @param fanCount the new fan count
	 */
	public void setFanCount(int fanCount) {
		this.fanCount = fanCount;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getBirthday()
	 */
	public String getBirthday() {
		return birthday;
	}
	
	/**
	 * Sets the birthday.
	 * 
	 * @param birthday the new birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getPersonalInterests()
	 */
	public String getPersonalInterests() {
		return personalInterests;
	}
	
	/**
	 * Sets the personal interests.
	 * 
	 * @param personalInterests the new personal interests
	 */
	public void setPersonalInterests(String personalInterests) {
		this.personalInterests = personalInterests;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getLocation()
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * Sets the location.
	 * 
	 * @param location the new location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getPersonalInfo()
	 */
	public String getPersonalInfo() {
		return personalInfo;
	}
	
	/**
	 * Sets the personal info.
	 * 
	 * @param personalInfo the new personal info
	 */
	public void setPersonalInfo(String personalInfo) {
		this.personalInfo = personalInfo;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getAffiliation()
	 */
	public String getAffiliation() {
		return affiliation;
	}
	
	/**
	 * Sets the affiliation.
	 * 
	 * @param affiliation the new affiliation
	 */
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getFounded()
	 */
	public String getFounded() {
		return founded;
	}
	
	/**
	 * Sets the founded.
	 * 
	 * @param founded the new founded
	 */
	public void setFounded(String founded) {
		this.founded = founded;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getUsername()
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets the username.
	 * 
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getMission()
	 */
	public String getMission() {
		return mission;
	}
	
	/**
	 * Sets the mission.
	 * 
	 * @param mission the new mission
	 */
	public void setMission(String mission) {
		this.mission = mission;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getLink()
	 */
	public String getLink() {
		return link;
	}
	
	/**
	 * Sets the link.
	 * 
	 * @param link the new link
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getProducts()
	 */
	public String getProducts() {
		return products;
	}
	
	/**
	 * Sets the products.
	 * 
	 * @param products the new products
	 */
	public void setProducts(String products) {
		this.products = products;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getCompanyOverview()
	 */
	public String getCompanyOverview() {
		return companyOverview;
	}
	
	/**
	 * Sets the company overview.
	 * 
	 * @param companyOverview the new company overview
	 */
	public void setCompanyOverview(String companyOverview) {
		this.companyOverview = companyOverview;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getFeed()
	 */
	public PagedList<Post> getFeed() {
		return getConnections(PageConnection.FEED);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getTagged()
	 */
	public PagedList<? extends Stream<?, ?>> getTagged() {
		return getConnections(PageConnection.TAGGED);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getLinks()
	 */
	public PagedList<Link> getLinks() {
		return getConnections(PageConnection.LINKS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getPhotos()
	 */
	public PagedList<Photo> getPhotos() {
		return getConnections(PageConnection.PHOTOS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getGroups()
	 */
	public PagedList<Group> getGroups() {
		return getConnections(PageConnection.GROUPS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getAlbums()
	 */
	public PagedList<Album> getAlbums() {
		return getConnections(PageConnection.ALBUMS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getStatuses()
	 */
	public PagedList<Status> getStatuses() {
		return getConnections(PageConnection.STATUSES);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getVideos()
	 */
	public PagedList<Video> getVideos() {
		return getConnections(PageConnection.VIDEOS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getNotes()
	 */
	public PagedList<Note> getNotes() {
		return getConnections(PageConnection.NOTES);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getPosts()
	 */
	public PagedList<Post> getPosts() {
		return getConnections(PageConnection.POSTS);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Page#getEvents()
	 */
	public PagedList<Event> getEvents() {
		return getConnections(PageConnection.EVENTS);
	}

	@Override
	public String getDescription() {
		return getLabel();
	}

	@Override
	public String getLabel() {
		return getName();// + "[" + getId() + "]";
	}
}
