/**
 * 
 */
package com.google.code.facebook.graph.sna.service.strategy.shortestpath;

import java.util.List;

import com.google.code.facebook.graph.model.GraphNode;

/**
 * @author nmukhtar
 *
 */
public interface ShortestPathAlgorithm<T> {

	List<GraphNode<?, ?>> shortestPath(T graph,
			GraphNode<?, ?> start, GraphNode<?, ?> end);

}
