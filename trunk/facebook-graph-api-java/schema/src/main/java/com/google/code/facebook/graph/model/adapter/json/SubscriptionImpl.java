/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.code.facebook.graph.model.Subscription;
import com.google.code.facebook.graph.model.adapter.Adapter;
import com.google.code.facebook.graph.model.enumeration.SubscriptionType;

/**
 * The Class LocationImpl.
 */
public class SubscriptionImpl extends BaseJsonAdapter implements Adapter<JSONObject>, Serializable, Subscription {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3112507792821438256L;
	private SubscriptionType object;
	private String callbackUrl;
	private List<String> fields = new ArrayList<String>();
	private boolean active;
	
	/**
	 * @return the object
	 */
	public SubscriptionType getObject() {
		return object;
	}

	/**
	 * @param object the object to set
	 */
	public void setObject(SubscriptionType object) {
		this.object = object;
	}

	/**
	 * @return the callbackUrl
	 */
	public String getCallbackUrl() {
		return callbackUrl;
	}

	/**
	 * @param callbackUrl the callbackUrl to set
	 */
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	/**
	 * @return the fields
	 */
	public List<String> getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(List<String> fields) {
		this.fields = fields;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void adaptFrom(JSONObject adaptee) {
		copyProperties(this, adaptee);
		JSONArray fieldsJson = (JSONArray) adaptee.get("fields");
		if (fieldsJson != null) {
			for (String field : (List<String>) fieldsJson) {
				fields.add(field);				
			}
		}
	}
}
