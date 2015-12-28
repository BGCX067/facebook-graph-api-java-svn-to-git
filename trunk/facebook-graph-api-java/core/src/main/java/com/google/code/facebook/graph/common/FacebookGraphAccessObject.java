/*
 * 
 */
package com.google.code.facebook.graph.common;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.code.facebook.graph.client.AccessTokenProvider;
import com.google.code.facebook.graph.client.ConnectedModeCallback;
import com.google.code.facebook.graph.client.FacebookAuthenticationClient;
import com.google.code.facebook.graph.model.Entity;
import com.google.code.facebook.graph.model.enumeration.ConnectionEnum;
import com.google.code.facebook.graph.model.enumeration.FieldEnum;
import com.google.code.facebook.graph.model.enumeration.ObjectType;

/**
 * The Interface FacebookGraphAccessObject.
 */
public interface FacebookGraphAccessObject extends FacebookAuthenticationClient {
	
	/**
	 * The Class Paging.
	 */
	public final class Paging {
		
		/** The offset. */
		private int offset;
		
		/** The limit. */
		private int limit;
		
		/**
		 * Instantiates a new paging.
		 * 
		 * @param offset the offset
		 * @param limit the limit
		 */
		public Paging(int offset, int limit) {
			this.offset = offset;
			this.limit = limit;
		}
		
		/**
		 * Gets the offset.
		 * 
		 * @return the offset
		 */
		public int getOffset() {
			return offset;
		}
		
		/**
		 * Gets the limit.
		 * 
		 * @return the limit
		 */
		public int getLimit() {
			return limit;
		}
	}
	
	/**
	 * The Class TimePeriod.
	 */
	public class TimePeriod {
		
		/** The since. */
		private String since;
		
		/** The until. */
		private String until;
		
		/**
		 * Instantiates a new time period.
		 * 
		 * @param since the since
		 * @param until the until
		 */
		public TimePeriod(Date since, Date until) {
			this.since = (since == null)? null : String.valueOf(since.getTime() / 1000L);
			this.until = (until == null)? null : String.valueOf(until.getTime() / 1000L);
		}
		
		/**
		 * Instantiates a new time period.
		 * 
		 * @param since the since
		 * @param until the until
		 */
		public TimePeriod(String since, String until) {
			this.since = since;
			this.until = until;
		}
		
		/**
		 * Gets the since.
		 * 
		 * @return the since
		 */
		public String getSince() {
			return since;
		}
		
		/**
		 * Gets the until.
		 * 
		 * @return the until
		 */
		public String getUntil() {
			return until;
		}
	}
	
	/**
	 * Gets the.
	 * 
	 * @param id the id
	 * 
	 * @return the t
	 */
	public <T extends Entity<?, ?>> T get(String id);
	
	/**
	 * Load.
	 * 
	 * @param id the id
	 * 
	 * @return the t
	 */
	public <T extends Entity<?, ?>> T load(String id);
	
	/**
	 * Reload.
	 * 
	 * @param entity the entity
	 * 
	 * @return the t
	 */
	public <T extends Entity<?, ?>> T reload(T entity);
	
	/**
	 * Load.
	 * 
	 * @param id the id
	 * @param accessTokenProvider the access token provider
	 * 
	 * @return the t
	 */
	public <T extends Entity<?, ?>> T load(String id, AccessTokenProvider accessTokenProvider);

	/**
	 * Gets the.
	 * 
	 * @param ids the ids
	 * 
	 * @return the map< string, t>
	 */
	public <T extends Entity<?, ?>> Map<String, T> get(List<String> ids);

	/**
	 * Gets the.
	 * 
	 * @param type the type
	 * @param id the id
	 * 
	 * @return the t
	 */
	public <T extends Entity<?, ?>> T get(ObjectType type, String id);

	/**
	 * Gets the.
	 * 
	 * @param type the type
	 * @param ids the ids
	 * 
	 * @return the map< string, t>
	 */
	public <T extends Entity<?, ?>> Map<String, T> get(ObjectType type,
			List<String> ids);

	/**
	 * Gets the.
	 * 
	 * @param type the type
	 * @param id the id
	 * @param fields the fields
	 * 
	 * @return the t
	 */
	public <T extends Entity<?, ?>> T get(ObjectType type, String id,
			Set<? extends FieldEnum> fields);

	/**
	 * Gets the.
	 * 
	 * @param type the type
	 * @param ids the ids
	 * @param fields the fields
	 * 
	 * @return the map< string, t>
	 */
	public <T extends Entity<?, ?>> Map<String, T> get(ObjectType type,
			List<String> ids, Set<? extends FieldEnum> fields);

	/**
	 * Gets the connections.
	 * 
	 * @param type the type
	 * @param id the id
	 * @param connectionType the connection type
	 * 
	 * @return the connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getConnections(ObjectType type,
			String id, ConnectionEnum connectionType);

	/**
	 * Gets the connections.
	 * 
	 * @param type the type
	 * @param id the id
	 * @param connectionType the connection type
	 * 
	 * @return the connections
	 */
	public <T extends Entity<?, ?>> PagedList<T> getConnections(ObjectType type,
			String id, ConnectionEnum connectionType, Paging paging, TimePeriod timePeriod);
	
	/**
	 * Delete.
	 * 
	 * @param id the id
	 */
	public void delete(String id);
	
	// Graph Methods
	/**
	 * Run as connected.
	 * 
	 * @param entities the entities
	 * @param callback the callback
	 * @param accessTokenProvider the access token provider
	 * 
	 * @return the t
	 */
	public <T> T runAsConnected(List<? extends ActiveRecord> entities, ConnectedModeCallback<T> callback, AccessTokenProvider accessTokenProvider);
	
    public <T> List<T> fetchData(Class<T> clazz, String url);
}