package com.google.code.facebook.graph.model;

import java.util.List;

import com.google.code.facebook.graph.model.enumeration.SubscriptionType;

public interface Subscription {

	/**
	 * @return the object
	 */
	public SubscriptionType getObject();

	/**
	 * @return the callbackUrl
	 */
	public String getCallbackUrl();

	/**
	 * @return the fields
	 */
	public List<String> getFields();

	/**
	 * @return the active
	 */
	public boolean isActive();

}