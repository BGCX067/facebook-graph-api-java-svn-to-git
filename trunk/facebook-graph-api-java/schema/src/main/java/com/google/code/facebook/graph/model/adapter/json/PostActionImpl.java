/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.io.Serializable;

import org.json.simple.JSONObject;

import com.google.code.facebook.graph.model.PostAction;
import com.google.code.facebook.graph.model.adapter.Adapter;

/**
 * The Class PostActionImpl.
 */
public class PostActionImpl extends BaseJsonAdapter implements Adapter<JSONObject>, Serializable, PostAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3112507792821438256L;
	
	/** The name. */
	private String name;
	
	/** The link. */
	private String link;
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.PostAction#getName()
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
	 * @see com.google.code.facebook.graph.model.PostAction#getLink()
	 */
	public String getLink() {
		return link;
	}
	
	/**
	 * Sets the link.
	 * 
	 * @param link the new link
	 */
	public void setLink(String link) {
		this.link = link;
	}
}
