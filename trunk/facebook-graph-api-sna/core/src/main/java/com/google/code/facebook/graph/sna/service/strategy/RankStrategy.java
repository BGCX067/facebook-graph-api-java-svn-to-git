package com.google.code.facebook.graph.sna.service.strategy;

/**
 * The Enum RankStrategy.
 */
public enum RankStrategy implements StrategyEnum {
	
	/** The BETWEENNES s_ centrality. */
	BETWEENNESS_CENTRALITY,
	
	/** The K_ ste p_ markov. */
	K_STEP_MARKOV,
	
	/** The MARKO v_ centrality. */
	MARKOV_CENTRALITY,
	
	/** The RANDO m_ wal k_ betweenness. */
	RANDOM_WALK_BETWEENNESS,
	
	/** The RANDO m_ walks t_ betweenness. */
	RANDOM_WALKST_BETWEENNESS,
	
	/** The WEIGHTEDN i_ paths. */
	WEIGHTEDNI_PATHS,
	
	/** The BARYCENTE r_ scorer. */
	BARYCENTER_SCORER,
	
	/** The CLOSENES s_ centrality. */
	CLOSENESS_CENTRALITY,
	
	/** The DEGRE e_ scorer. */
	DEGREE_SCORER,
	
	/** The DISTANC e_ centralit y_ scorer. */
	DISTANCE_CENTRALITY_SCORER,
	
	/** The EIGENVECTO r_ centrality. */
	EIGENVECTOR_CENTRALITY,
	
	/** The HITS. */
	HITS,
	
	/** The PAG e_ rank. */
	PAGE_RANK,
	
	/** The VOLTAG e_ scorer. */
	VOLTAGE_SCORER,
	
	/** The STRUCTURA l_ hole s_ constraint. */
	STRUCTURAL_HOLES_CONSTRAINT,
	
	/** The STRUCTURA l_ hole s_ aggregat e_ constraint. */
	STRUCTURAL_HOLES_AGGREGATE_CONSTRAINT,
	
	/** The STRUCTURA l_ hole s_ effectiv e_ size. */
	STRUCTURAL_HOLES_EFFECTIVE_SIZE,
	
	/** The STRUCTURA l_ hole s_ efficiency. */
	STRUCTURAL_HOLES_EFFICIENCY,
	
	/** The STRUCTURA l_ hole s_ hierarchy. */
	STRUCTURAL_HOLES_HIERARCHY;
}
