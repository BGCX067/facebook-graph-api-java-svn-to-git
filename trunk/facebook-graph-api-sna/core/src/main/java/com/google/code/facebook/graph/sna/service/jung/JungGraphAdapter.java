/**
 * 
 */
package com.google.code.facebook.graph.sna.service.jung;

import java.util.List;
import java.util.Map;

import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.Entity;
import com.google.code.facebook.graph.model.GraphNode;
import com.google.code.facebook.graph.model.enumeration.ConnectionEnum;
import com.google.code.facebook.graph.model.enumeration.FieldEnum;
import com.google.code.facebook.graph.sna.constant.ConnectionWeights;
import com.google.code.facebook.graph.sna.service.GraphAdapter;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * @author nmukhtar
 *
 */
public class JungGraphAdapter<V extends Entity<? extends FieldEnum, E>, E extends ConnectionEnum> implements GraphAdapter<Graph<V, EdgeAdapter<E>>, V, E> {
	
	@Override
	public Graph<V, EdgeAdapter<E>> adaptFrom(GraphNode<? extends FieldEnum, E> input) {
		Graph<V, EdgeAdapter<E>> graph = new DirectedSparseMultigraph<V, EdgeAdapter<E>>();
		populateGraph(graph, input);
		return graph;
	}

	/**
	 * @param graph
	 * @param input
	 */
	@SuppressWarnings("unchecked")
	private void populateGraph(Graph<V, EdgeAdapter<E>> graph,
			GraphNode<? extends FieldEnum, E> input) {
		graph.addVertex((V) input);
		Map<E, GraphNode<?, ?>> links = input.getAllLinks();
		for (E linkType : links.keySet()) {
			GraphNode<?, ?> child = links.get(linkType);
			populateGraph(graph, (GraphNode<? extends FieldEnum, E>) child);
			graph.addEdge(new EdgeAdapter<E>(linkType, ConnectionWeights.getConnectionWeight(linkType)), (V) input, (V) child, EdgeType.DIRECTED);
		}
		Map<E, PagedList<GraphNode<?, ?>>> connections = input.getAllConnections();
		for (E connectionType : connections.keySet()) {
			List<GraphNode<?, ?>> children = connections.get(connectionType);
			for (GraphNode<?, ?> child : children) {
				populateGraph(graph, (GraphNode<? extends FieldEnum, E>) child);
				graph.addEdge(new EdgeAdapter<E>(connectionType, ConnectionWeights.getConnectionWeight(connectionType)), (V) input, (V) child, EdgeType.DIRECTED);
			}
		}
	}

	@Override
	public GraphNode<? extends FieldEnum, E> adaptTo(
			Graph<V, EdgeAdapter<E>> adapter) {
		// TODO Auto-generated method stub
		return null;
	}
}
