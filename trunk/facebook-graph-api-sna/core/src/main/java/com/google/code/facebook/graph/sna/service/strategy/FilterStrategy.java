/*
 * Copyright (c) 2009 Creative Chaos, Inc.
 * All rights reserved.
 *
 */

package com.google.code.facebook.graph.sna.service.strategy;

/**
 * The Enum FilterStrategy.
 */
public enum FilterStrategy implements StrategyEnum {
	
	/** The EDG e_ predicat e_ filter. */
	EDGE_PREDICATE_FILTER,
	/** The K_ neighborhoo d_ filter. */
	K_NEIGHBORHOOD_FILTER,
	/** The VERTE x_ predicat e_ filter. */
	VERTEX_PREDICATE_FILTER;
}
