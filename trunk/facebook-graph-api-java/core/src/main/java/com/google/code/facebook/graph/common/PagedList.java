/*
 * 
 */
package com.google.code.facebook.graph.common;

import java.util.List;

/**
 * The Interface PagedList.
 */
public interface PagedList<E> extends List<E> {
	
	/**
	 * Load more data.
	 */
	public int loadMoreData();
	
	/**
	 * Gets the next end point.
	 * 
	 * @return the next end point
	 */
	public String getNextEndPoint();
	
	/**
	 * Sets the next end point.
	 * 
	 * @param nextEndPoint the new next end point
	 */
	public void setNextEndPoint(String nextEndPoint);
	
	/**
	 * Gets the previous end point.
	 * 
	 * @return the previous end point
	 */
	public String getPreviousEndPoint();
	
	/**
	 * Sets the previous end point.
	 * 
	 * @param previousEndPoint the new previous end point
	 */
	public void setPreviousEndPoint(String previousEndPoint);
}
