/*
 * 
 */
package com.google.code.facebook.graph.model;

import com.google.code.facebook.graph.model.enumeration.ConnectionEnum;
import com.google.code.facebook.graph.model.enumeration.FieldEnum;
import com.google.code.facebook.graph.model.enumeration.PictureType;

/**
 * The Interface Entity.
 */
public interface Entity<PropertyType extends FieldEnum, ConnectionType extends ConnectionEnum> extends GraphNode<FieldEnum, ConnectionEnum> {

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId();
	
	/**
	 * Gets the picture.
	 * 
	 * @return the picture
	 */
	public String getPicture();
	
	/**
	 * Gets the picture.
	 * 
	 * @param pictureType the picture type
	 * 
	 * @return the picture
	 */
	public String getPicture(PictureType pictureType);
}
