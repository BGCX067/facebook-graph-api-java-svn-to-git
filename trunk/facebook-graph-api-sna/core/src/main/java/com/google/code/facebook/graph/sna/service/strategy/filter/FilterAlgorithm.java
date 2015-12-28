/**
 * 
 */
package com.google.code.facebook.graph.sna.service.strategy.filter;

import com.google.code.facebook.graph.model.GraphNode;

/**
 * @author nmukhtar
 *
 */
public interface FilterAlgorithm<T> {

	GraphNode<?, ?> filter(T graph);

}
