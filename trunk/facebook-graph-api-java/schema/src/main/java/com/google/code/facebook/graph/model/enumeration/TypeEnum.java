/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;

import com.google.code.facebook.graph.model.Entity;

/**
 * The Interface TypeEnum.
 */
@SuppressWarnings("unchecked")
public interface TypeEnum {

	/**
	 * Type.
	 * 
	 * @return the class<? extends entity>
	 */
	public Class<? extends Entity> type();
}