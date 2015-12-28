/**
 * 
 */
package com.google.code.facebook.graph.sna.service.jung.algorithm.shortestpath;

import java.util.List;

import com.google.code.facebook.graph.model.GraphNode;
import com.google.code.facebook.graph.sna.service.jung.algorithm.BaseJungAlgorithm;
import com.google.code.facebook.graph.sna.service.strategy.shortestpath.ShortestPathAlgorithm;

import edu.uci.ics.jung.graph.Graph;

/**
 * @author nmukhtar
 *
 */
public class UnweightedShortestPath extends BaseJungAlgorithm implements
		ShortestPathAlgorithm<Graph<?, ?>> {

	@Override
	public List<GraphNode<?, ?>> shortestPath(Graph<?, ?> graph,
			GraphNode<?, ?> start, GraphNode<?, ?> end) {
		// TODO Auto-generated method stub
		return null;
	}
}
