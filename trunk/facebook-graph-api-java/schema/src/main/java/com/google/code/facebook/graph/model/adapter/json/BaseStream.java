/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.util.Date;

import org.json.simple.JSONObject;

import com.google.code.facebook.graph.model.Author;

/**
 * The Class BaseStream.
 */
public abstract class BaseStream extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 660578473776919064L;

	/** The from. */
	private Author<?, ?> from;
	
	/** The updated time. */
	private Date updatedTime;

	/**
	 * Sets the from.
	 * 
	 * @param from the from
	 */
	public void setFrom(Author<?, ?> from) {
		this.from = from;
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
	 * Gets the from.
	 * 
	 * @return the from
	 */
	public Author<?, ?> getFrom() {
		return from;
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
		JSONObject fromJson = (JSONObject) adaptee.get("from");
		if (fromJson != null) {
			from = new AuthorImpl();
			((AuthorImpl) from).adaptFrom(fromJson);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.json.BaseJsonAdapter#adaptTo()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject adaptTo() {
		JSONObject adapter = super.adaptTo();
		if (from != null) {
			JSONObject fromJson = ((AuthorImpl) from).adaptTo();
			adapter.put("from", fromJson);
		}
		return adapter;
	}
}
