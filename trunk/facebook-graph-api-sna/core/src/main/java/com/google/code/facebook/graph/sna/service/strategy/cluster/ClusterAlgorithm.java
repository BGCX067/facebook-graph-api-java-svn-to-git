/**
 * 
 */
package com.google.code.facebook.graph.sna.service.strategy.cluster;

import java.util.Collection;
import java.util.Set;

import com.google.code.facebook.graph.model.GraphNode;

/**
 * @author nmukhtar
 *
 */
public interface ClusterAlgorithm<T> {
	Collection<Set<GraphNode<?, ?>>> cluster(T graph);
}
