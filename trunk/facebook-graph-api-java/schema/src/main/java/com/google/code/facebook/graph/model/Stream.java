/*
 * 
 */
package com.google.code.facebook.graph.model;

import java.util.Date;

import com.google.code.facebook.graph.model.enumeration.ConnectionEnum;
import com.google.code.facebook.graph.model.enumeration.FieldEnum;

/**
 * The Interface Stream.
 */
public interface Stream<PropertyType extends FieldEnum, ConnectionType extends ConnectionEnum> extends Entity<PropertyType, ConnectionType> {

	/**
	 * Gets the from.
	 * 
	 * @return the from
	 */
	public Author<?, ?> getFrom();
	
	/**
	 * Gets the updated time.
	 * 
	 * @return the updated time
	 */
	public Date getUpdatedTime();
}
