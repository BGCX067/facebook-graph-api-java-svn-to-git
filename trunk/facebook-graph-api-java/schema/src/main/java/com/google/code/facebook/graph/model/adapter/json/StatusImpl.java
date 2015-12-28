/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;


import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.Post;
import com.google.code.facebook.graph.model.Status;
import com.google.code.facebook.graph.model.enumeration.ObjectType;
import com.google.code.facebook.graph.model.enumeration.StatusConnection;

/**
 * The Class StatusImpl.
 */
public class StatusImpl extends BaseStream implements Status {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7239150260983257521L;
	
	/** The message. */
	private String message;
//	private List<Post> comments;
	
	public StatusImpl() {
		super();
		setType(ObjectType.STATUS);
	}
	
	/**
 * Sets the message.
 * 
 * @param message the new message
 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Status#getMessage()
	 */
	public String getMessage() {
		return message;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Status#getComments()
	 */
	public PagedList<Post> getComments() {
		return getConnections(StatusConnection.COMMENTS);
	}

	@Override
	public String getDescription() {
		return getLabel();
	}

	@Override
	public String getLabel() {
		return getMessage();
	}
}
