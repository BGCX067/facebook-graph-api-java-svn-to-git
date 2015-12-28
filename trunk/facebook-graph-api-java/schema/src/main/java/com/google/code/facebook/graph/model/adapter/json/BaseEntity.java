/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import org.json.simple.JSONObject;

import com.google.code.facebook.graph.common.ActiveRecord;
import com.google.code.facebook.graph.common.FacebookGraphAccessObject;
import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.Entity;
import com.google.code.facebook.graph.model.GraphNode;
import com.google.code.facebook.graph.model.enumeration.ConnectionEnum;
import com.google.code.facebook.graph.model.enumeration.FieldEnum;
import com.google.code.facebook.graph.model.enumeration.ObjectType;
import com.google.code.facebook.graph.model.enumeration.PictureType;

/**
 * The Class BaseEntity.
 */
public abstract class BaseEntity extends BaseJsonAdapter implements ActiveRecord, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1919201915205300063L;
	
	/** The id. */
	private String id;
	
	/** The picture. */
	private String picture;
	
	/** The graph access object. */
	private transient FacebookGraphAccessObject graphAccessObject;
	
	/** The type. */
	private ObjectType type;
	
	/** The metadata. */
	private Map<ConnectionEnum, String> metadata = new HashMap<ConnectionEnum, String>();
	
	/** The connections map. */
	protected Map<ConnectionEnum, PagedList<? extends GraphNode<?, ?>>> connectionsMap = new HashMap<ConnectionEnum, PagedList<? extends GraphNode<?,?>>>();
	
	/** The properties map. */
	protected Map<FieldEnum, ?> propertiesMap = new HashMap<FieldEnum, Object>();
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.ActiveRecord#getGraphAccessObject()
	 */
	public FacebookGraphAccessObject getGraphAccessObject() {
		return graphAccessObject;
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.ActiveRecord#setGraphAccessObject(com.google.code.facebook.graph.client.FacebookGraphAccessObject)
	 */
	public void setGraphAccessObject(FacebookGraphAccessObject graphAccessObject) {
		this.graphAccessObject = graphAccessObject;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Gets the picture.
	 * 
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}
	
	/**
	 * Sets the picture.
	 * 
	 * @param picture the new picture
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	 * Gets the picture.
	 * 
	 * @param pictureType the picture type
	 * 
	 * @return the picture
	 */
	public String getPicture(PictureType pictureType) {
		return picture + "?type=" + pictureType.value();
	}
	
	/**
	 * Gets the connections.
	 * 
	 * @param connectionType the connection type
	 * 
	 * @return the connections
	 */
	@SuppressWarnings("unchecked")
	public <T extends GraphNode<?, ?>> PagedList<T> getConnections(ConnectionEnum connectionType) {
		PagedList<T> connections = (PagedList<T>) connectionsMap.get(connectionType);
		
		if (connections == null && getGraphAccessObject() != null) {
			connections = (PagedList<T>) getGraphAccessObject().getConnections(getType(), getId(), connectionType);
			connectionsMap.put(connectionType, connections);
		}
		return connections;
	}
	
	/**
	 * Gets the all connections.
	 * 
	 * @return the all connections
	 */
	@SuppressWarnings("unchecked")
	public <T extends GraphNode<?, ?>> Map<ConnectionEnum, PagedList<T>> getAllConnections() {
		Map<ConnectionEnum, PagedList<T>> retValue = new HashMap<ConnectionEnum, PagedList<T>>();
		for (ConnectionEnum connectionType : metadata.keySet()) {
			PagedList<T> connections = (PagedList<T>) connectionsMap.get(connectionType);
			
			if (connections == null && getGraphAccessObject() != null) {
				try {
					connections = (PagedList<T>) getGraphAccessObject().getConnections(getType(), getId(), connectionType);
//					((PagedArrayList<T>) connections).setGraphAccessObject(getGraphAccessObject());
					connectionsMap.put(connectionType, connections);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "Error while fetching connections of type:" + connectionType.value(), e);
				}
			}
			
			retValue.put(connectionType, connections);
		}
		return retValue;
	}
	
	/**
	 * Gets the all links.
	 * 
	 * @return the all links
	 */
	@SuppressWarnings("unchecked")
	public <T extends GraphNode<?, ?>> Map<ConnectionEnum, T> getAllLinks() {
		Map<String, GraphNode<?, ?>> entityLinks = getEntityLinks();
		Map<ConnectionEnum, T> links = new HashMap<ConnectionEnum, T>();
		for (Map.Entry<String, GraphNode<?, ?>> entry : entityLinks.entrySet()) {
			ConnectionEnum value = type.link(entry.getKey());
			if (value != null) {
				links.put(value, (T) entry.getValue());
			} else {
				logger.warning("Not handling link type:" + entry.getKey());
			}
		}
		return links;
	}
	
	
	/**
	 * Gets the property.
	 * 
	 * @param type the type
	 * 
	 * @return the property
	 */
	@SuppressWarnings("unchecked")
	public <T> T getProperty(FieldEnum type) {
		return (T) propertiesMap.get(type);
	}
	
	/**
	 * Gets the all properties.
	 * 
	 * @return the all properties
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getAllProperties() {
		return new ArrayList<T>((Collection<? extends T>) propertiesMap.values());
	}
	
	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public ObjectType getType() {
		return type;
	}

	/**
	 * Sets the type.
	 * 
	 * @param type the new type
	 */
	public void setType(ObjectType type) {
		this.type = type;
	}

	/**
	 * Gets the metadata.
	 * 
	 * @return the metadata
	 */
	public Map<ConnectionEnum, String> getMetadata() {
		return metadata;
	}

	/**
	 * Sets the metadata.
	 * 
	 * @param metadata the metadata
	 */
	public void setMetadata(Map<ConnectionEnum, String> metadata) {
		this.metadata = metadata;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.json.BaseJsonAdapter#adaptFrom(org.json.simple.JSONObject)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void adaptFrom(JSONObject adaptee) {
		super.adaptFrom(adaptee);
		JSONObject metadataJson = (JSONObject) adaptee.get("metadata");
		if (metadataJson != null) {
			JSONObject connectionsJson = (JSONObject) metadataJson.get("connections");
			if (connectionsJson != null) {
				for (Map.Entry<String, String> entry : (Set<Map.Entry<String, String>>) connectionsJson.entrySet()) {
					ConnectionEnum value = type.connection(entry.getKey());
					if (value != null) {
						metadata.put(value, entry.getValue());
					} else {
						logger.warning("Not handling connection type:" + entry.getKey());
					}
				}
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Entity))
			return false;
		final Entity<?, ?> other = (Entity<?, ?>) obj;
		if (getId() == null) {
			return false;
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		return true;
	}
}
