/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.util.Date;

import org.json.simple.JSONObject;

import com.google.code.facebook.graph.model.Location;
import com.google.code.facebook.graph.model.User;
import com.google.code.facebook.graph.model.enumeration.Privacy;

/**
 * The Class BaseAssociation.
 */
public abstract class BaseAssociation extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6802879239026971272L;

	/** The owner. */
	private User owner;
	
	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/** The venue. */
	private Location venue;
	
	/** The privacy. */
	private Privacy privacy;
	
	/** The updated time. */
	private Date updatedTime;

	/**
	 * Sets the owner.
	 * 
	 * @param owner the new owner
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	/**
	 * Sets the name.
	 * 
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the description.
	 * 
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Sets the venue.
	 * 
	 * @param venue the new venue
	 */
	public void setVenue(Location venue) {
		this.venue = venue;
	}
	
	/**
	 * Sets the privacy.
	 * 
	 * @param privacy the new privacy
	 */
	public void setPrivacy(Privacy privacy) {
		this.privacy = privacy;
	}
	
	/**
	 * Sets the updated time.
	 * 
	 * @param updatedTime the new updated time
	 */
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	/**
	 * Gets the owner.
	 * 
	 * @return the owner
	 */
	public User getOwner() {
		return owner;
	}
	
	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Gets the venue.
	 * 
	 * @return the venue
	 */
	public Location getVenue() {
		return venue;
	}
	
	/**
	 * Gets the privacy.
	 * 
	 * @return the privacy
	 */
	public Privacy getPrivacy() {
		return privacy;
	}
	
	/**
	 * Gets the updated time.
	 * 
	 * @return the updated time
	 */
	public Date getUpdatedTime() {
		return updatedTime;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.json.BaseEntity#adaptFrom(org.json.simple.JSONObject)
	 */
	@Override
	public void adaptFrom(JSONObject adaptee) {
		super.adaptFrom(adaptee);
		JSONObject ownerJson = (JSONObject) adaptee.get("owner");
		if (ownerJson != null) {
			owner = new UserImpl();
			((UserImpl) owner).adaptFrom(ownerJson);
		}
		JSONObject venueJson = (JSONObject) adaptee.get("venue");
		if (venueJson != null) {
			venue = new LocationImpl();
			((LocationImpl) venue).adaptFrom(venueJson);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.json.BaseJsonAdapter#adaptTo()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject adaptTo() {
		JSONObject adapter = super.adaptTo();
		if (owner != null) {
			JSONObject fromJson = ((UserImpl) owner).adaptTo();
			adapter.put("owner", fromJson);
		}
		if (venue != null) {
			JSONObject fromJson = ((LocationImpl) venue).adaptTo();
			adapter.put("venue", fromJson);
		}
		return adapter;
	}
}
