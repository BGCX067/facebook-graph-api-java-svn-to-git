/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.code.facebook.graph.common.PagedArrayList;
import com.google.code.facebook.graph.common.PagedList;
import com.google.code.facebook.graph.model.Author;
import com.google.code.facebook.graph.model.Post;
import com.google.code.facebook.graph.model.PostAction;
import com.google.code.facebook.graph.model.enumeration.ObjectType;
import com.google.code.facebook.graph.model.enumeration.PostConnection;
import com.google.code.facebook.graph.model.enumeration.Privacy;

/**
 * The Class PostImpl.
 */
public class PostImpl extends BaseStream implements Post {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 532962288916775440L;
	
	/** The to. */
	private List<Author<?, ?>> to = new ArrayList<Author<?,?>>();
	
	/** The message. */
	private String message;
	
	/** The subject. */
	private String subject;
	
	/** The link. */
	private String link;
	
	/** The name. */
	private String name;
	
	/** The caption. */
	private String caption;
	
	/** The description. */
	private String description;
	
	/** The source. */
	private String source;
	
	/** The icon. */
	private String icon;
	
	/** The attribution. */
	private String attribution;
	
	/** The actions. */
	private List<PostAction> actions = new ArrayList<PostAction>();
	
	/** The likes. */
	private int likes;
	
	/** The created time. */
	private Date createdTime;
	
	/** The privacy. */
	private Privacy privacy;
	
	/** The comments. */
	private PagedList<Post> comments = new PagedArrayList<Post>();
	
	public PostImpl() {
		super();
		setType(ObjectType.POST);
	}
	
	/**
	 * Sets the comments.
	 * 
	 * @param comments the new comments
	 */
	public void setComments(PagedList<Post> comments) {
		this.comments = comments;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Post#getComments()
	 */
	public PagedList<Post> getComments() {
		PagedList<Post> conn = getConnections(PostConnection.COMMENTS);
		return (conn == null)? comments : conn;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Post#getPrivacy()
	 */
	public Privacy getPrivacy() {
		return privacy;
	}
	
	/**
	 * Sets the privacy.
	 * 
	 * @param privacy the new privacy
	 */
	public void setPrivacy(Privacy privacy) {
		this.privacy = privacy;
	}
	
	/**
	 * Sets the to.
	 * 
	 * @param to the to
	 */
	public void setTo(List<Author<?, ?>> to) {
		this.to = to;
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
	 * Sets the link.
	 * 
	 * @param link the new link
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
	/**
	 * Sets the name.
	 * 
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the caption.
	 * 
	 * @param caption the new caption
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	/**
	 * Sets the description.
	 * 
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Sets the source.
	 * 
	 * @param source the new source
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * Sets the icon.
	 * 
	 * @param icon the new icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	/**
	 * Sets the attribution.
	 * 
	 * @param attribution the new attribution
	 */
	public void setAttribution(String attribution) {
		this.attribution = attribution;
	}
	
	/**
	 * Sets the actions.
	 * 
	 * @param actions the new actions
	 */
	public void setActions(List<PostAction> actions) {
		this.actions = actions;
	}
	
	/**
	 * Sets the likes.
	 * 
	 * @param likes the new likes
	 */
	public void setLikes(int likes) {
		this.likes = likes;
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
	 * @see com.google.code.facebook.graph.model.Post#getTo()
	 */
	public List<Author<?, ?>> getTo() {
		return to;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Post#getMessage()
	 */
	public String getMessage() {
		return message;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Post#getLink()
	 */
	public String getLink() {
		return link;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.NamedEntity#getName()
	 */
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Post#getCaption()
	 */
	public String getCaption() {
		return caption;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Post#getDescription()
	 */
	public String getDescription() {
		return description;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Post#getSource()
	 */
	public String getSource() {
		return source;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Post#getIcon()
	 */
	public String getIcon() {
		return icon;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Post#getAttribution()
	 */
	public String getAttribution() {
		return attribution;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Post#getActions()
	 */
	public List<PostAction> getActions() {
		return actions;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Post#getLikes()
	 */
	public int getLikes() {
		return likes;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Post#getCreatedTime()
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Post#getSubject()
	 */
	public String getSubject() {
		return subject;
	}
	
	/**
	 * Sets the subject.
	 * 
	 * @param subject the new subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.json.BaseStream#adaptFrom(org.json.simple.JSONObject)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void adaptFrom(JSONObject adaptee) {
		super.adaptFrom(adaptee);
		JSONArray actionsJson = (JSONArray) adaptee.get("actions");
		if (actionsJson != null) {
			for (JSONObject obj : (List<JSONObject>) actionsJson) {
				PostActionImpl actionImpl = new PostActionImpl();
				actionImpl.adaptFrom(obj);
				actions.add(actionImpl);				
			}
		}
		JSONObject commentsDataJson = (JSONObject) adaptee.get("comments");
		if (commentsDataJson != null) {
			JSONArray commentsJson = (JSONArray) commentsDataJson.get("data");
			if (commentsJson != null) {
				for (JSONObject obj : (List<JSONObject>) commentsJson) {
					PostImpl postImpl = new PostImpl();
					postImpl.adaptFrom(obj);
					comments.add(postImpl);				
				}
			}
		}
		JSONObject toDataJson = (JSONObject) adaptee.get("to");
		if (toDataJson != null) {
			JSONArray toJson = (JSONArray) toDataJson.get("data");
			if (toJson != null) {
				for (JSONObject obj : (List<JSONObject>) toJson) {
					AuthorImpl toImpl = new AuthorImpl();
					toImpl.adaptFrom(obj);
					to.add(toImpl);				
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.json.BaseStream#adaptTo()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject adaptTo() {
		JSONObject adapter = super.adaptTo();
		return adapter;
	}

	@Override
	public String getLabel() {
		return getName();// + "[" + getId() + "]";
	}
}
