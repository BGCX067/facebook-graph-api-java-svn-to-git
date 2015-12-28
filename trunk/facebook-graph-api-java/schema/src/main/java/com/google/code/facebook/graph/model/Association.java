/*
 * 
 */
package com.google.code.facebook.graph.model;

import java.util.Date;

import com.google.code.facebook.graph.model.enumeration.ConnectionEnum;
import com.google.code.facebook.graph.model.enumeration.FieldEnum;
import com.google.code.facebook.graph.model.enumeration.Privacy;

/**
 * The Interface Association.
 */
public interface Association<PropertyType extends FieldEnum, ConnectionType extends ConnectionEnum> extends NamedEntity<PropertyType, ConnectionType> {

	/**
	 * Gets the owner.
	 * 
	 * @return the owner
	 */
	public User getOwner();

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription();

	/**
	 * Gets the venue.
	 * 
	 * @return the venue
	 */
	public Location getVenue();

	/**
	 * Gets the privacy.
	 * 
	 * @return the privacy
	 */
	public Privacy getPrivacy();

	/**
	 * Gets the updated time.
	 * 
	 * @return the updated time
	 */
	public Date getUpdatedTime();
}
