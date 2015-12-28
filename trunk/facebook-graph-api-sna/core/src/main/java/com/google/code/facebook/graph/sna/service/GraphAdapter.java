/**
 * 
 */
package com.google.code.facebook.graph.sna.service;

import com.google.code.facebook.graph.model.Entity;
import com.google.code.facebook.graph.model.GraphNode;
import com.google.code.facebook.graph.model.enumeration.ConnectionEnum;
import com.google.code.facebook.graph.model.enumeration.FieldEnum;

/**
 * The Interface GraphAdapter.
 * 
 * @author nmukhtar
 */
public interface GraphAdapter<T, V extends Entity<? extends FieldEnum, E>, E extends ConnectionEnum> {
	
	/**
	 * Adapt from.
	 * 
	 * @param adaptee the adaptee
	 * 
	 * @return the t
	 */
	public T adaptFrom(GraphNode<? extends FieldEnum, E> adaptee);
	
	/**
	 * Adapt to.
	 * 
	 * @param adapter the adapter
	 * 
	 * @return the graph node<? extends field enum, e>
	 */
	public GraphNode<? extends FieldEnum, E> adaptTo(T adapter);
}
