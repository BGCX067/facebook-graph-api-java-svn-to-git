/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;


/**
 * The Class BaseAuthor.
 */
public abstract class BaseAuthor extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6776384885340787802L;

	/** The name. */
	private String name;

	/**
	 * Sets the name.
	 * 
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
