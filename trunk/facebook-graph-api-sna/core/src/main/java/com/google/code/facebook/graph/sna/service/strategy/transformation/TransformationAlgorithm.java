/**
 * 
 */
package com.google.code.facebook.graph.sna.service.strategy.transformation;

import com.google.code.facebook.graph.model.GraphNode;

/**
 * @author nmukhtar
 *
 */
public interface TransformationAlgorithm<T> {
	GraphNode<?, ?> transform(T graph);
}
