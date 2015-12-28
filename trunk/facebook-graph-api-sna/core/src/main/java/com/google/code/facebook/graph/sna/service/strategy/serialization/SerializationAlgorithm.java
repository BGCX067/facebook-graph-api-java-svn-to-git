/**
 * 
 */
package com.google.code.facebook.graph.sna.service.strategy.serialization;

import java.io.OutputStream;

/**
 * @author nmukhtar
 *
 */
public interface SerializationAlgorithm<T> {
	void serialize(T graph, OutputStream out);
}
