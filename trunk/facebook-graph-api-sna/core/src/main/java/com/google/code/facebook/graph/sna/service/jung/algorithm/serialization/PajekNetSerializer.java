/**
 * 
 */
package com.google.code.facebook.graph.sna.service.jung.algorithm.serialization;

import java.io.OutputStream;

import com.google.code.facebook.graph.sna.service.jung.algorithm.BaseJungAlgorithm;
import com.google.code.facebook.graph.sna.service.strategy.serialization.SerializationAlgorithm;

import edu.uci.ics.jung.graph.Graph;

/**
 * @author nmukhtar
 *
 */
public class PajekNetSerializer extends BaseJungAlgorithm implements
		SerializationAlgorithm<Graph<?, ?>> {

	@Override
	public void serialize(Graph<?, ?> graph, OutputStream out) {
		// TODO Auto-generated method stub
	}
}
