/*
 * 
 */
package com.google.code.facebook.graph.common;

import java.util.ArrayList;


/**
 * The Class PagedList.
 */
public class PagedArrayList<E> extends ArrayList<E> implements ActiveRecord, PagedList<E> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5011544152511118680L;
	
	/** The graph access object. */
	private transient FacebookGraphAccessObject graphAccessObject;
	
	private String nextEndPoint;
	private String previousEndPoint;

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.ActiveRecord#getGraphAccessObject()
	 */
	@Override
	public FacebookGraphAccessObject getGraphAccessObject() {
		return graphAccessObject;
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.ActiveRecord#setGraphAccessObject(com.google.code.facebook.graph.client.FacebookGraphAccessObject)
	 */
	@Override
	public void setGraphAccessObject(FacebookGraphAccessObject graphAccessObject) {
		this.graphAccessObject = graphAccessObject;
	}

	/**
	 * @return the nextEndPoint
	 */
	public String getNextEndPoint() {
		return nextEndPoint;
	}

	/**
	 * @param nextEndPoint the nextEndPoint to set
	 */
	public void setNextEndPoint(String nextEndPoint) {
		this.nextEndPoint = nextEndPoint;
	}

	/**
	 * @return the previousEndPoint
	 */
	public String getPreviousEndPoint() {
		return previousEndPoint;
	}

	/**
	 * @param previousEndPoint the previousEndPoint to set
	 */
	public void setPreviousEndPoint(String previousEndPoint) {
		this.previousEndPoint = previousEndPoint;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int loadMoreData() {
		if (graphAccessObject == null) {
			throw new IllegalStateException("Cannot load data. Not in connected mode.");
		}
		if (getNextEndPoint() == null) {
			throw new IllegalStateException("No more data available.");
		}
		int index = size();
		if (index == 0) {
			throw new IllegalStateException("List is empty. The endpoint is invalid.");
		}
		PagedList<E> next = (PagedList<E>) graphAccessObject.fetchData(get(0).getClass(), getNextEndPoint());
		addAll(next) ;
		setNextEndPoint(next.getNextEndPoint());
		return index;
	}
}
