/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.io.Serializable;
import java.util.Date;

import org.json.simple.JSONObject;

import com.google.code.facebook.graph.model.InsightValue;
import com.google.code.facebook.graph.model.adapter.Adapter;

/**
 * The Class EducationImpl.
 */
public class InsightValueImpl extends BaseJsonAdapter implements Adapter<JSONObject>, Serializable, InsightValue {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3112507792821438256L;
	
	private int value;
	private Date endTime;
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
