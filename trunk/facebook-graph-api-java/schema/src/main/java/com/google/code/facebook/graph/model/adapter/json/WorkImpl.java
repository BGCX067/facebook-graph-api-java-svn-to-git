/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.io.Serializable;

import org.json.simple.JSONObject;

import com.google.code.facebook.graph.model.Page;
import com.google.code.facebook.graph.model.Work;
import com.google.code.facebook.graph.model.adapter.Adapter;

/**
 * The Class WorkImpl.
 */
public class WorkImpl extends BaseJsonAdapter implements Adapter<JSONObject>, Work, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3112507792821438256L;
	
	/** The employer. */
	private Page employer;
	
	/** The position. */
	private Page position;
	
	/** The location. */
	private Page location;
	
	/** The start date. */
	private String startDate;
	
	/** The end date. */
	private String endDate;
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Work#getEmployer()
	 */
	public Page getEmployer() {
		return employer;
	}

	/**
	 * Sets the employer.
	 * 
	 * @param employer the new employer
	 */
	public void setEmployer(Page employer) {
		this.employer = employer;
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Work#getPosition()
	 */
	public Page getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 * 
	 * @param position the new position
	 */
	public void setPosition(Page position) {
		this.position = position;
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Work#getStartDate()
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 * 
	 * @param startDate the new start date
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Work#getLocation()
	 */
	public Page getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 * 
	 * @param location the new location
	 */
	public void setLocation(Page location) {
		this.location = location;
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Work#getEndDate()
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 * 
	 * @param endDate the new end date
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.json.BaseJsonAdapter#adaptFrom(org.json.simple.JSONObject)
	 */
	@Override
	public void adaptFrom(JSONObject adaptee) {
		copyProperties(this, adaptee);
		JSONObject employerJson = (JSONObject) adaptee.get("employer");
		if (employerJson != null) {
			this.employer = new PageImpl();
			((PageImpl) employer).adaptFrom(employerJson);
		}
		JSONObject positionJson = (JSONObject) adaptee.get("position");
		if (positionJson != null) {
			this.position = new PageImpl();
			((PageImpl) position).adaptFrom(positionJson);
		}
		JSONObject locationJson = (JSONObject) adaptee.get("location");
		if (locationJson != null) {
			this.location = new PageImpl();
			((PageImpl) location).adaptFrom(locationJson);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.json.BaseJsonAdapter#adaptTo()
	 */
	@Override
	public JSONObject adaptTo() {
		JSONObject object = new JSONObject();
		copyProperties(object, this);
		return object;
	}
}
