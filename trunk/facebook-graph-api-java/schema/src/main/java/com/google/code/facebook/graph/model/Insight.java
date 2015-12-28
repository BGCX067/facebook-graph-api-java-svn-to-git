package com.google.code.facebook.graph.model;

import java.util.List;

import com.google.code.facebook.graph.model.enumeration.ConnectionEnum;
import com.google.code.facebook.graph.model.enumeration.FieldEnum;
import com.google.code.facebook.graph.model.enumeration.Period;

public interface Insight extends NamedEntity<FieldEnum, ConnectionEnum> {

	/**
	 * @return the period
	 */
	public Period getPeriod();

	/**
	 * @return the values
	 */
	public List<InsightValue> getValues();

}