/**
 *
 */
package com.google.code.facebook.graph.sna.service;

import java.io.OutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.code.facebook.graph.model.GraphNode;
import com.google.code.facebook.graph.sna.service.strategy.ClusterStrategy;
import com.google.code.facebook.graph.sna.service.strategy.FilterStrategy;
import com.google.code.facebook.graph.sna.service.strategy.MetricStrategy;
import com.google.code.facebook.graph.sna.service.strategy.RankStrategy;
import com.google.code.facebook.graph.sna.service.strategy.SerializationStrategy;
import com.google.code.facebook.graph.sna.service.strategy.ShortestPathStrategy;
import com.google.code.facebook.graph.sna.service.strategy.TransformationStrategy;



/**
 * The Interface FacebookSocialNetworkAnalyzer..
 * 
 * @author Nabeel Mukhtar
 */
public interface FacebookSocialNetworkAnalyzer {
	
	/**
	 * Gets the shortest path.
	 * 
	 * @param start the start
	 * @param end the end
	 * @param strategy the strategy
	 * 
	 * @return the shortest path
	 */
	public List<GraphNode<?, ?>> getShortestPath(GraphNode<?, ?> start, GraphNode<?, ?> end, ShortestPathStrategy strategy);
	
	/**
	 * Cluster.
	 * @param strategy the strategy
	 * 
	 * @return the collection< set< graph node<?,?>>>
	 */
	public Collection<Set<GraphNode<?, ?>>> cluster(ClusterStrategy strategy);
	
	/**
	 * Filter.
	 * 
	 * @param root the root
	 * @param strategy the strategy
	 * 
	 * @return the graph node<?,?>
	 */
	public GraphNode<?, ?> filter(FilterStrategy strategy);
	
	/**
	 * Transform.
	 * 
	 * @param root the root
	 * @param strategy the strategy
	 * 
	 * @return the graph node<?,?>
	 */
	public GraphNode<?, ?> transform(TransformationStrategy strategy);
	
	/**
	 * Gets the rank.
	 * 
	 * @param node the node
	 * @param strategy the strategy
	 * 
	 * @return the rank
	 */
	public double getRank(GraphNode<?, ?> node, RankStrategy strategy);
	
	/**
	 * Gets the rank.
	 * 
	 * @param node the node
	 * @param strategy the strategy
	 * 
	 * @return the rank
	 */
	public double getGraphMetric(MetricStrategy strategy);
	
	/**
	 * Serialize.
	 * 
	 * @param root the root
	 * @param out the out
	 * @param strategy the strategy
	 */
	public void serialize(OutputStream out, SerializationStrategy strategy);
}
