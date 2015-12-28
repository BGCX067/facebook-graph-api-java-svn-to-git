/*
 * 
 */
package com.google.code.facebook.graph.model;

import java.util.Date;

/**
 * The Interface PhotoTag.
 */
public interface PhotoTag {

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId();

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName();

	/**
	 * Gets the x.
	 * 
	 * @return the x
	 */
	public double getX();

	/**
	 * Gets the y.
	 * 
	 * @return the y
	 */
	public double getY();

	/**
	 * Gets the created time.
	 * 
	 * @return the created time
	 */
	public Date getCreatedTime();

}