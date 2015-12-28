/*
 * 
 */
package com.google.code.facebook.graph.model;

import java.util.List;
import java.util.Map;

import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.enumeration.ConnectionEnum;
import com.google.code.facebook.graph.model.enumeration.FieldEnum;
import com.google.code.facebook.graph.model.enumeration.ObjectType;

/**
 * The Interface GraphNode.
 */
public interface GraphNode<PropertyType extends FieldEnum, ConnectionType extends ConnectionEnum> {
	
	/**
	 * Gets the connections.
	 * 
	 * @param type the type
	 * 
	 * @return the connections
	 */
	public <T extends GraphNode<?, ?>> PagedList<T> getConnections(ConnectionType type);
	
	/**
	 * Gets the all connections.
	 * 
	 * @return the all connections
	 */
	public <T extends GraphNode<?, ?>> Map<ConnectionType, PagedList<T>> getAllConnections();
	
	/**
	 * Gets the all links.
	 * 
	 * @return the all links
	 */
	public <T extends GraphNode<?, ?>> Map<ConnectionType, T> getAllLinks();
	
	/**
	 * Gets the property.
	 * 
	 * @param type the type
	 * 
	 * @return the property
	 */
	public <T> T getProperty(PropertyType type);
	
	/**
	 * Gets the all properties.
	 * 
	 * @return the all properties
	 */
	public <T> List<T> getAllProperties();
	
	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public ObjectType getType();
	
	/**
	 * Gets the metadata.
	 * 
	 * @return the metadata
	 */
	public Map<ConnectionType, String> getMetadata();
	
	public String getLabel();
	
	public String getDescription();
}
