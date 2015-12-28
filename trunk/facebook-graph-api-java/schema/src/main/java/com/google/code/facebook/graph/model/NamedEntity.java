/*
 * 
 */
package com.google.code.facebook.graph.model;

import com.google.code.facebook.graph.model.enumeration.ConnectionEnum;
import com.google.code.facebook.graph.model.enumeration.FieldEnum;


/**
 * The Interface NamedEntity.
 */
public interface NamedEntity<PropertyType extends FieldEnum, ConnectionType extends ConnectionEnum> extends Entity<PropertyType, ConnectionType> {

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName();
}
