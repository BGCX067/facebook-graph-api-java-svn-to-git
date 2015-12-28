/**
 * 
 */
package com.google.code.facebook.graph.sna.service.strategy.rank;

import com.google.code.facebook.graph.model.GraphNode;

/**
 * @author nmukhtar
 *
 */
public interface RankAlgorithm<T> {
	double rank(T graph, GraphNode<?, ?> node);
}
