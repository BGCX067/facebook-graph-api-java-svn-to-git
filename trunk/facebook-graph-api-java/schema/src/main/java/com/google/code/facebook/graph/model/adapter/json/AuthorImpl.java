/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import com.google.code.facebook.graph.model.Author;
import com.google.code.facebook.graph.model.enumeration.ConnectionEnum;
import com.google.code.facebook.graph.model.enumeration.FieldEnum;


/**
 * The Class AuthorImpl.
 */
public class AuthorImpl extends BaseEntity implements Author<FieldEnum, ConnectionEnum> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6776384885340787802L;

	/** The name. */
	private String name;
	
	/** The category. */
	private String category;

	/**
	 * Sets the name.
	 * 
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.NamedEntity#getName()
	 */
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Author#getCategory()
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * Sets the category.
	 * 
	 * @param category the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String getDescription() {
		return getLabel();
	}

	@Override
	public String getLabel() {
		return getName();// + "[" + getId() + "]";
	}
}
