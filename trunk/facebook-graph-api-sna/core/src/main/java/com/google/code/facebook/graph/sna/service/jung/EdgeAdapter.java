/**
 * 
 */
package com.google.code.facebook.graph.sna.service.jung;

import com.google.code.facebook.graph.model.enumeration.ConnectionEnum;

/**
 * @author nmukhtar
 *
 */
public class EdgeAdapter<T extends ConnectionEnum> {
	private T connection;
	private Double weight;
	
	public EdgeAdapter(T connection) {
		this.connection = connection;
		this.weight = connection.weight();
	}
	
	public EdgeAdapter(T connection, Double weight) {
		this.connection = connection;
		this.weight = weight;
	}
	
	/**
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	/**
	 * @return the connection
	 */
	public T getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(T connection) {
		this.connection = connection;
	}

	@Override
	public String toString() {
		return connection.value();
	}
}
