/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.io.Serializable;
import java.util.Date;

import org.json.simple.JSONObject;

import com.google.code.facebook.graph.model.PhotoTag;
import com.google.code.facebook.graph.model.adapter.Adapter;

/**
 * The Class PhotoTagImpl.
 */
public class PhotoTagImpl extends BaseJsonAdapter implements Adapter<JSONObject>, Serializable, PhotoTag {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3112507792821438256L;
	
	/** The id. */
	private String id;
	
	/** The name. */
	private String name;
	
	/** The x. */
	private double x;
	
	/** The y. */
	private double y;
	
	/** The created time. */
	private Date createdTime;
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.PhotoTag#getId()
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 * 
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.PhotoTag#getName()
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 * 
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.PhotoTag#getX()
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Sets the x.
	 * 
	 * @param x the new x
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.PhotoTag#getY()
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Sets the y.
	 * 
	 * @param y the new y
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.PhotoTag#getCreatedTime()
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	
	/**
	 * Sets the created time.
	 * 
	 * @param createdTime the new created time
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
}
