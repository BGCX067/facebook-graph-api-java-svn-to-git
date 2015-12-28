package com.google.code.facebook.graph.sna.service.strategy;

/**
 * The Enum ClusterStrategy.
 */
public enum ClusterStrategy implements StrategyEnum {
	
	/** The BICOMPONEN t_ clusterer. */
	BICOMPONENT_CLUSTERER,
	
	/** The EDG e_ betweennes s_ clusterer. */
	EDGE_BETWEENNESS_CLUSTERER,
	
	/** The VOLTAG e_ clusterer. */
	VOLTAGE_CLUSTERER,
	
	/** The WEA k_ componen t_ clusterer. */
	WEAK_COMPONENT_CLUSTERER;
}
