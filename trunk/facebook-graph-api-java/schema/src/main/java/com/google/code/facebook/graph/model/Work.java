/*
 * 
 */
package com.google.code.facebook.graph.model;


/**
 * The Interface Work.
 */
public interface Work {

	/**
	 * Gets the employer.
	 * 
	 * @return the employer
	 */
	public Page getEmployer();

	/**
	 * Gets the position.
	 * 
	 * @return the position
	 */
	public Page getPosition();

	/**
	 * Gets the start date.
	 * 
	 * @return the start date
	 */
	public String getStartDate();

	/**
	 * Gets the location.
	 * 
	 * @return the location
	 */
	public Page getLocation();
	
	/**
	 * Gets the end date.
	 * 
	 * @return the end date
	 */
	public String getEndDate();
	
}