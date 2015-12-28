/*
 * 
 */
package com.google.code.facebook.graph.client;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * The Class AsyncFacebookGraphApiClientAdapter.
 */
public class AsyncFacebookGraphApiClientAdapter implements AsyncFacebookGraphApiClient {

    /** The client. */
    private FacebookGraphApiClient client;
    
    /** The task executor. */
    private ExecutorService taskExecutor;

    /**
     * Instantiates a new async facebook graph api client adapter.
     * 
     * @param client the client
     * @param taskExecutor the task executor
     */

    /**
     * Constructs ...
     *
     *
     * @param client
     */
    public AsyncFacebookGraphApiClientAdapter(FacebookGraphApiClient client, ExecutorService taskExecutor) {
        this.client  = client;
        this.taskExecutor = taskExecutor;
    }

    /**
     * Execute.
     * 
     * @param task the task
     * 
     * @return the future<?>
     */
    protected Future<?> execute(Runnable task) {
        return taskExecutor.submit(task);
    }

    /**
     * Execute.
     * 
     * @param task the task
     * 
     * @return the future< t>
     */
    protected <T> Future<T> execute(Callable<T> task) {
        return taskExecutor.submit(task);
    }
    
    /* (non-Javadoc)
     * @see com.google.code.facebook.graph.client.FacebookCommunicationClient#setRequestHeaders(java.util.Map)
     */
    public void setRequestHeaders(Map<String, String> requestHeaders) {
    	client.setRequestHeaders(requestHeaders);
    }

    /* (non-Javadoc)
     * @see com.google.code.facebook.graph.client.FacebookCommunicationClient#getRequestHeaders()
     */
    public Map<String, String> getRequestHeaders() {
        return client.getRequestHeaders();
    }

    /* (non-Javadoc)
     * @see com.google.code.facebook.graph.client.FacebookCommunicationClient#addRequestHeader(java.lang.String, java.lang.String)
     */
    public void addRequestHeader(String headerName, String headerValue) {
        client.addRequestHeader(headerName, headerValue);
    }

    /* (non-Javadoc)
     * @see com.google.code.facebook.graph.client.FacebookCommunicationClient#removeRequestHeader(java.lang.String)
     */
    public void removeRequestHeader(String headerName) {
        client.removeRequestHeader(headerName);
    }

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookAuthenticationClient#getAccessToken()
	 */
	@Override
	public String getAccessToken() {
		return client.getAccessToken();
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.FacebookAuthenticationClient#setAccessToken(java.lang.String)
	 */
	@Override
	public void setAccessToken(String accessToken) {
		client.setAccessToken(accessToken);
	}
}
