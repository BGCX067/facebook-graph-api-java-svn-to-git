/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.util.Date;

import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.Note;
import com.google.code.facebook.graph.model.Post;
import com.google.code.facebook.graph.model.enumeration.NoteConnection;
import com.google.code.facebook.graph.model.enumeration.ObjectType;

/**
 * The Class NoteImpl.
 */
public class NoteImpl extends BaseStream implements Note {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5725806202841864875L;
	
	/** The subject. */
	private String subject;
	
	/** The message. */
	private String message;
	
	/** The icon. */
	private String icon;
	
	/** The created time. */
	private Date createdTime;
//	private List<Post> comments;
	
	public NoteImpl() {
		super();
		setType(ObjectType.NOTE);
	}
	
	/**
 * Sets the subject.
 * 
 * @param subject the new subject
 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * Sets the message.
	 * 
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Sets the created time.
	 * 
	 * @param createdTime the new created time
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Note#getSubject()
	 */
	public String getSubject() {
		return subject;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Note#getMessage()
	 */
	public String getMessage() {
		return message;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Note#getCreatedTime()
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Note#getIcon()
	 */
	public String getIcon() {
		return icon;
	}
	
	/**
	 * Sets the icon.
	 * 
	 * @param icon the new icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Note#getComments()
	 */
	public PagedList<Post> getComments() {
		return getConnections(NoteConnection.COMMENTS);
	}

	@Override
	public String getDescription() {
		return getMessage();
	}

	@Override
	public String getLabel() {
		return getSubject();// + "[" + getId() + "]";
	}
}
