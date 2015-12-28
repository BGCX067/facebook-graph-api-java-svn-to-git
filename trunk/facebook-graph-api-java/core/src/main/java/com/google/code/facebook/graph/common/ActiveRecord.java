/*
 * 
 */
package com.google.code.facebook.graph.common;


/**
 * The Interface ActiveRecord.
 */
public interface ActiveRecord {
	
	/**
	 * Sets the graph access object.
	 * 
	 * @param graphAccessObject the new graph access object
	 */
	public void setGraphAccessObject(FacebookGraphAccessObject graphAccessObject);
	
	/**
	 * Gets the graph access object.
	 * 
	 * @return the graph access object
	 */
	public FacebookGraphAccessObject getGraphAccessObject();
}
