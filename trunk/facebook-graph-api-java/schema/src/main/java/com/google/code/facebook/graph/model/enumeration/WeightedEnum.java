/*
 * 
 */
package com.google.code.facebook.graph.model.enumeration;


/**
 * The Interface WeightedEnum.
 */
public interface WeightedEnum<T> {

	/**
	 * Weight.
	 * 
	 * @return the t
	 */
	public T weight();
	
	/**
	 * Weight.
	 * 
	 * @param weight the weight
	 */
	public void weight(T weight);
}