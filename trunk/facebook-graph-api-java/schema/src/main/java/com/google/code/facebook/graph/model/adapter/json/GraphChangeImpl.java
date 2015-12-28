/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.util.Set;

import org.json.simple.JSONObject;

import com.google.code.facebook.graph.model.UserChange;
import com.google.code.facebook.graph.model.adapter.Adapter;
import com.google.code.facebook.graph.model.enumeration.ConnectionEnum;

/**
 * The Class GraphChangeImpl.
 */
public class GraphChangeImpl extends BaseJsonAdapter implements Adapter<JSONObject>, UserChange {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3112507792821438256L;
	
	/** The uid. */
	private String uid;
	
	/** The time. */
	private int time;
	
	/** The changed fields. */
	private Set<ConnectionEnum> changedFields;
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.GraphChange#getUid()
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * Sets the uid.
	 * 
	 * @param uid the new uid
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.GraphChange#getTime()
	 */
	public int getTime() {
		return time;
	}

	/**
	 * Sets the time.
	 * 
	 * @param time the new time
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.GraphChange#getChangedFields()
	 */
	public Set<ConnectionEnum> getChangedFields() {
		return changedFields;
	}

	/**
	 * Sets the changed fields.
	 * 
	 * @param changedFields the new changed fields
	 */
	public void setChangedFields(Set<ConnectionEnum> changedFields) {
		this.changedFields = changedFields;
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.json.BaseJsonAdapter#adaptFrom(org.json.simple.JSONObject)
	 */
	@Override
	public void adaptFrom(JSONObject adaptee) {
		copyProperties(this, adaptee);
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
