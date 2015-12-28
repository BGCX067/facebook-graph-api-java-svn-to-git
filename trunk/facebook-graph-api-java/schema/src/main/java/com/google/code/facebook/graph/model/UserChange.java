/*
 * 
 */
package com.google.code.facebook.graph.model;

import java.util.Set;

import com.google.code.facebook.graph.model.enumeration.ConnectionEnum;

/**
 * The Interface GraphChange.
 */
public interface UserChange extends GraphChange {

	/**
	 * Gets the uid.
	 * 
	 * @return the uid
	 */
	public String getUid();

	/**
	 * Gets the time.
	 * 
	 * @return the time
	 */
	public int getTime();

	/**
	 * Gets the changed fields.
	 * 
	 * @return the changed fields
	 */
	public Set<ConnectionEnum> getChangedFields();

}