/**
 * 
 */
package com.google.code.facebook.graph.sna.service.jung;

import java.io.OutputStream;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.code.facebook.graph.model.GraphNode;
import com.google.code.facebook.graph.sna.service.FacebookSocialNetworkAnalyzer;
import com.google.code.facebook.graph.sna.service.GraphAdapter;
import com.google.code.facebook.graph.sna.service.jung.algorithm.cluster.BicomponentClusterer;
import com.google.code.facebook.graph.sna.service.jung.algorithm.cluster.EdgeBetweennessClusterer;
import com.google.code.facebook.graph.sna.service.jung.algorithm.cluster.VoltageClusterer;
import com.google.code.facebook.graph.sna.service.jung.algorithm.cluster.WeakComponentClusterer;
import com.google.code.facebook.graph.sna.service.jung.algorithm.filter.EdgePredicateFilter;
import com.google.code.facebook.graph.sna.service.jung.algorithm.filter.KNeighborhoodFilter;
import com.google.code.facebook.graph.sna.service.jung.algorithm.filter.VertexPredicateFilter;
import com.google.code.facebook.graph.sna.service.jung.algorithm.serialization.GraphMLSerializer;
import com.google.code.facebook.graph.sna.service.jung.algorithm.serialization.MatrixFileSerializer;
import com.google.code.facebook.graph.sna.service.jung.algorithm.serialization.PajekNetSerializer;
import com.google.code.facebook.graph.sna.service.jung.algorithm.shortestpath.DijkstraShortestPath;
import com.google.code.facebook.graph.sna.service.jung.algorithm.shortestpath.UnweightedShortestPath;
import com.google.code.facebook.graph.sna.service.jung.algorithm.transformation.DirectionTransformer;
import com.google.code.facebook.graph.sna.service.jung.algorithm.transformation.FoldingTransformer;
import com.google.code.facebook.graph.sna.service.jung.algorithm.transformation.VertexPartitionCollapser;
import com.google.code.facebook.graph.sna.service.strategy.ClusterStrategy;
import com.google.code.facebook.graph.sna.service.strategy.FilterStrategy;
import com.google.code.facebook.graph.sna.service.strategy.MetricStrategy;
import com.google.code.facebook.graph.sna.service.strategy.RankStrategy;
import com.google.code.facebook.graph.sna.service.strategy.SerializationStrategy;
import com.google.code.facebook.graph.sna.service.strategy.ShortestPathStrategy;
import com.google.code.facebook.graph.sna.service.strategy.TransformationStrategy;
import com.google.code.facebook.graph.sna.service.strategy.cluster.ClusterAlgorithm;
import com.google.code.facebook.graph.sna.service.strategy.filter.FilterAlgorithm;
import com.google.code.facebook.graph.sna.service.strategy.metric.MetricAlgorithm;
import com.google.code.facebook.graph.sna.service.strategy.rank.RankAlgorithm;
import com.google.code.facebook.graph.sna.service.strategy.serialization.SerializationAlgorithm;
import com.google.code.facebook.graph.sna.service.strategy.shortestpath.ShortestPathAlgorithm;
import com.google.code.facebook.graph.sna.service.strategy.transformation.TransformationAlgorithm;

import edu.uci.ics.jung.graph.Graph;

/**
 * The Class JungFacebookGraphAnalyzer.
 * 
 * @author nmukhtar
 */
public class JungFacebookGraphAnalyzer implements FacebookSocialNetworkAnalyzer {
	
	/** The graph transformer. */
	@SuppressWarnings("unchecked")
	private GraphAdapter<Graph<?, ?>, ?, ?> graphTransformer = new JungGraphAdapter();
	
	private Graph<?, ?> graph;
	
	/** The Constant CLUSTER_STRATEGIES. */
	private static final Map<ClusterStrategy, ClusterAlgorithm<Graph<?, ?>>> CLUSTER_STRATEGIES = new EnumMap<ClusterStrategy, ClusterAlgorithm<Graph<?, ?>>>(ClusterStrategy.class);
	
	/** The Constant FILTER_STRATEGIES. */
	private static final Map<FilterStrategy, FilterAlgorithm<Graph<?, ?>>> FILTER_STRATEGIES = new EnumMap<FilterStrategy, FilterAlgorithm<Graph<?, ?>>>(FilterStrategy.class);
	
	/** The Constant RANK_STRATEGIES. */
	private static final Map<RankStrategy, RankAlgorithm<Graph<?, ?>>> RANK_STRATEGIES = new EnumMap<RankStrategy, RankAlgorithm<Graph<?, ?>>>(RankStrategy.class);
	
	/** The Constant SERIALIZATION_STRATEGIES. */
	private static final Map<SerializationStrategy, SerializationAlgorithm<Graph<?, ?>>> SERIALIZATION_STRATEGIES = new EnumMap<SerializationStrategy, SerializationAlgorithm<Graph<?, ?>>>(SerializationStrategy.class);
	
	/** The Constant SHORTEST_PATH_STRATEGIES. */
	private static final Map<ShortestPathStrategy, ShortestPathAlgorithm<Graph<?, ?>>> SHORTEST_PATH_STRATEGIES = new EnumMap<ShortestPathStrategy, ShortestPathAlgorithm<Graph<?, ?>>>(ShortestPathStrategy.class);
	
	/** The Constant TRANSFORMATION_STRATEGIES. */
	private static final Map<TransformationStrategy, TransformationAlgorithm<Graph<?, ?>>> TRANSFORMATION_STRATEGIES = new EnumMap<TransformationStrategy, TransformationAlgorithm<Graph<?, ?>>>(TransformationStrategy.class);
	
	/** The Constant METRIC_STRATEGIES. */
	private static final Map<MetricStrategy, MetricAlgorithm<Graph<?, ?>>> METRIC_STRATEGIES = new EnumMap<MetricStrategy, MetricAlgorithm<Graph<?, ?>>>(MetricStrategy.class);
	
	static {
		loadStrategies();
	}
	
	/**
	 * Instantiates a new jung facebook graph analyzer.
	 * 
	 * @param client the client
	 */
	public JungFacebookGraphAnalyzer(Set<GraphNode<?, ?>> nodes) {
		// TODO-NM: Create a graph containing these nodes.
		graph = null;
	}
	
	/**
	 * Gets the graph transformer.
	 * 
	 * @return the graphTransformer
	 */
	public GraphAdapter<Graph<?, ?>, ?, ?> getGraphTransformer() {
		return graphTransformer;
	}

	/**
	 * Sets the graph transformer.
	 * 
	 * @param graphTransformer the graphTransformer to set
	 */
	public void setGraphTransformer(GraphAdapter<Graph<?, ?>, ?, ?> graphTransformer) {
		this.graphTransformer = graphTransformer;
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.sna.service.FacebookSocialNetworkAnalyzer#cluster(com.google.code.facebook.graph.model.GraphNode, com.google.code.facebook.graph.sna.service.strategy.ClusterStrategy)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Set<GraphNode<?, ?>>> cluster(ClusterStrategy strategy) {
		ClusterAlgorithm<Graph<?, ?>> algorithm = CLUSTER_STRATEGIES.get(strategy);
		return algorithm.cluster(graph);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.sna.service.FacebookSocialNetworkAnalyzer#filter(com.google.code.facebook.graph.model.GraphNode, com.google.code.facebook.graph.sna.service.strategy.FilterStrategy)
	 */
	@Override
	public GraphNode<?, ?> filter(FilterStrategy strategy) {
		FilterAlgorithm<Graph<?, ?>> algorithm = FILTER_STRATEGIES.get(strategy);
		return algorithm.filter(graph);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.sna.service.FacebookSocialNetworkAnalyzer#getRank(com.google.code.facebook.graph.model.GraphNode, com.google.code.facebook.graph.sna.service.strategy.RankStrategy)
	 */
	@Override
	public double getRank(GraphNode<?, ?> node, RankStrategy strategy) {
		RankAlgorithm<Graph<?, ?>> algorithm = RANK_STRATEGIES.get(strategy);
		return algorithm.rank(graph, node);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.sna.service.FacebookSocialNetworkAnalyzer#getShortestPath(com.google.code.facebook.graph.model.GraphNode, com.google.code.facebook.graph.model.GraphNode, com.google.code.facebook.graph.sna.service.strategy.ShortestPathStrategy)
	 */
	@Override
	public List<GraphNode<?, ?>> getShortestPath(GraphNode<?, ?> start,
			GraphNode<?, ?> end, ShortestPathStrategy strategy) {
		ShortestPathAlgorithm<Graph<?, ?>> algorithm = SHORTEST_PATH_STRATEGIES.get(strategy);
		return algorithm.shortestPath(graph, start, end);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.sna.service.FacebookSocialNetworkAnalyzer#serialize(com.google.code.facebook.graph.model.GraphNode, java.io.OutputStream, com.google.code.facebook.graph.sna.service.strategy.SerializationStrategy)
	 */
	@Override
	public void serialize(OutputStream out,
			SerializationStrategy strategy) {
		SerializationAlgorithm<Graph<?, ?>> algorithm = SERIALIZATION_STRATEGIES.get(strategy);
		algorithm.serialize(graph, out);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.sna.service.FacebookSocialNetworkAnalyzer#transform(com.google.code.facebook.graph.model.GraphNode, com.google.code.facebook.graph.sna.service.strategy.TransformationStrategy)
	 */
	@Override
	public GraphNode<?, ?> transform(TransformationStrategy strategy) {
		TransformationAlgorithm<Graph<?, ?>> algorithm = TRANSFORMATION_STRATEGIES.get(strategy);
		return algorithm.transform(graph);
	}

	@Override
	public double getGraphMetric(MetricStrategy strategy) {
		MetricAlgorithm<Graph<?, ?>> algorithm = METRIC_STRATEGIES.get(strategy);
		return algorithm.metric(graph);
	}
	
	
	private static void loadStrategies() {
		CLUSTER_STRATEGIES.put(ClusterStrategy.BICOMPONENT_CLUSTERER, new BicomponentClusterer());
		CLUSTER_STRATEGIES.put(ClusterStrategy.EDGE_BETWEENNESS_CLUSTERER, new EdgeBetweennessClusterer());
		CLUSTER_STRATEGIES.put(ClusterStrategy.VOLTAGE_CLUSTERER, new VoltageClusterer());
		CLUSTER_STRATEGIES.put(ClusterStrategy.WEAK_COMPONENT_CLUSTERER, new WeakComponentClusterer());
		
		FILTER_STRATEGIES.put(FilterStrategy.EDGE_PREDICATE_FILTER, new EdgePredicateFilter());
		FILTER_STRATEGIES.put(FilterStrategy.K_NEIGHBORHOOD_FILTER, new KNeighborhoodFilter());
		FILTER_STRATEGIES.put(FilterStrategy.VERTEX_PREDICATE_FILTER, new VertexPredicateFilter());
		
		RANK_STRATEGIES.put(RankStrategy.BARYCENTER_SCORER, null);
		RANK_STRATEGIES.put(RankStrategy.BETWEENNESS_CENTRALITY, null);
		RANK_STRATEGIES.put(RankStrategy.CLOSENESS_CENTRALITY, null);
		RANK_STRATEGIES.put(RankStrategy.CLOSENESS_CENTRALITY, null);
		RANK_STRATEGIES.put(RankStrategy.DEGREE_SCORER, null);
		RANK_STRATEGIES.put(RankStrategy.DISTANCE_CENTRALITY_SCORER, null);
		RANK_STRATEGIES.put(RankStrategy.EIGENVECTOR_CENTRALITY, null);
		RANK_STRATEGIES.put(RankStrategy.HITS, null);
		RANK_STRATEGIES.put(RankStrategy.K_STEP_MARKOV, null);
		RANK_STRATEGIES.put(RankStrategy.MARKOV_CENTRALITY, null);
		RANK_STRATEGIES.put(RankStrategy.PAGE_RANK, null);
		RANK_STRATEGIES.put(RankStrategy.RANDOM_WALK_BETWEENNESS, null);
		RANK_STRATEGIES.put(RankStrategy.RANDOM_WALKST_BETWEENNESS, null);
		RANK_STRATEGIES.put(RankStrategy.STRUCTURAL_HOLES_AGGREGATE_CONSTRAINT, null);
		RANK_STRATEGIES.put(RankStrategy.STRUCTURAL_HOLES_CONSTRAINT, null);
		RANK_STRATEGIES.put(RankStrategy.STRUCTURAL_HOLES_EFFECTIVE_SIZE, null);
		RANK_STRATEGIES.put(RankStrategy.STRUCTURAL_HOLES_EFFICIENCY, null);
		RANK_STRATEGIES.put(RankStrategy.STRUCTURAL_HOLES_HIERARCHY, null);
		RANK_STRATEGIES.put(RankStrategy.VOLTAGE_SCORER, null);
		RANK_STRATEGIES.put(RankStrategy.WEIGHTEDNI_PATHS, null);
		
		SERIALIZATION_STRATEGIES.put(SerializationStrategy.GRAPHML, new GraphMLSerializer());
		SERIALIZATION_STRATEGIES.put(SerializationStrategy.MATRIX_FILE, new MatrixFileSerializer());
		SERIALIZATION_STRATEGIES.put(SerializationStrategy.PAJEK_NET, new PajekNetSerializer());
		
		SHORTEST_PATH_STRATEGIES.put(ShortestPathStrategy.DIJKSTRA_SHORTEST_PATH, new DijkstraShortestPath());
		SHORTEST_PATH_STRATEGIES.put(ShortestPathStrategy.UNWEIGHTED_SHORTEST_PATH, new UnweightedShortestPath());
		
		TRANSFORMATION_STRATEGIES.put(TransformationStrategy.DIRECTION_TRANSFORMER, new DirectionTransformer());
		TRANSFORMATION_STRATEGIES.put(TransformationStrategy.FOLDING_TRANSFORMER, new FoldingTransformer());
		TRANSFORMATION_STRATEGIES.put(TransformationStrategy.VERTEX_PARTITION_COLLAPSER, new VertexPartitionCollapser());
		
		METRIC_STRATEGIES.put(MetricStrategy.EDGE_PREDICATE_FILTER, null);
		METRIC_STRATEGIES.put(MetricStrategy.K_NEIGHBORHOOD_FILTER, null);
		METRIC_STRATEGIES.put(MetricStrategy.VERTEX_PREDICATE_FILTER, null);
	}
}
