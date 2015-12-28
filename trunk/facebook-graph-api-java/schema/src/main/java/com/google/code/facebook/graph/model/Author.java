/*
 * 
 */
package com.google.code.facebook.graph.model;

import com.google.code.facebook.graph.model.enumeration.ConnectionEnum;
import com.google.code.facebook.graph.model.enumeration.FieldEnum;

/**
 * The Interface Author.
 */
public interface Author<PropertyType extends FieldEnum, ConnectionType extends ConnectionEnum> extends NamedEntity<PropertyType, ConnectionType> {
	
	/**
	 * Gets the category.
	 * 
	 * @return the category
	 */
	public String getCategory();
}
