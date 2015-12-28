/**
 * 
 */
package com.google.code.facebook.graph.sna.service.strategy.metric;


/**
 * @author nmukhtar
 *
 */
public interface MetricAlgorithm<T> {
	double metric(T graph);
}
