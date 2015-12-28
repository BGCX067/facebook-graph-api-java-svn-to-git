/**
 * 
 */
package com.google.code.facebook.graph.model;

/**
 * @author nmukhtar
 *
 */
public interface GraphObserver<T extends GraphChange> {
	public void update(T change);
}
