/*
 * 
 */
package com.google.code.facebook.graph.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

import com.google.code.facebook.graph.client.constant.ApplicationConstants;
import com.google.code.facebook.graph.client.exception.FacebookGraphApiException;

/**
 * The Class FacebookGraphApiGateway.
 */
public abstract class FacebookGraphApiGateway {

	/** The LOG. */
	protected final Logger LOG = Logger
			.getLogger(getClass().getCanonicalName());

	/** The Constant GZIP_ENCODING. */
	private static final String GZIP_ENCODING = "gzip";
	
	/** The request headers. */
	protected Map<String, String> requestHeaders = new HashMap<String, String>();
	
	/** The max rate limit. */
	private int maxRateLimit = -1;
	
	/** The current rate limit. */
	private int currentRateLimit = -1;

	/**
	 * Sets the request headers.
	 * 
	 * @param requestHeaders the request headers
	 */
	public void setRequestHeaders(Map<String, String> requestHeaders) {
		this.requestHeaders = requestHeaders;
	}

	/**
	 * Gets the request headers.
	 * 
	 * @return the request headers
	 */
	public Map<String, String> getRequestHeaders() {
		return requestHeaders;
	}

	/**
	 * Adds the request header.
	 * 
	 * @param headerName the header name
	 * @param headerValue the header value
	 */
	public void addRequestHeader(String headerName, String headerValue) {
		requestHeaders.put(headerName, headerValue);
	}

	/**
	 * Removes the request header.
	 * 
	 * @param headerName the header name
	 */
	public void removeRequestHeader(String headerName) {
		requestHeaders.remove(headerName);
	}

	/**
	 * Gets the max rate limit.
	 * 
	 * @return the max rate limit
	 */
	public int getMaxRateLimit() {
		return maxRateLimit;
	}

	/**
	 * Gets the current rate limit.
	 * 
	 * @return the current rate limit
	 */
	public int getCurrentRateLimit() {
		return currentRateLimit;
	}

	/**
	 * Convert stream to string.
	 * 
	 * @param is the is
	 * 
	 * @return the string
	 */
	protected static String convertStreamToString(InputStream is) {
		/*
		 * To convert the InputStream to String we use the
		 * BufferedReader.readLine() method. We iterate until the BufferedReader
		 * return null which means there's no more data to read. Each line will
		 * appended to a StringBuilder and returned as String.
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sb.toString();
	}

	/**
	 * Call api get.
	 * 
	 * @param apiUrl the api url
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiGet(String apiUrl) {
		return callApiGet(apiUrl, HttpURLConnection.HTTP_OK);
	}

	/**
	 * Call api get.
	 * 
	 * @param apiUrl the api url
	 * @param expected the expected
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiGet(String apiUrl, int expected) {
		try {
            URL               url     = new URL(apiUrl);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            
            if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
                request.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
            }

            if (ApplicationConstants.READ_TIMEOUT > -1) {
                request.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
            }
            
            for (String headerName : requestHeaders.keySet()) {
                request.setRequestProperty(headerName, requestHeaders.get(headerName));
            }
            
            request.connect();
            
            if (request.getResponseCode() == HttpURLConnection.HTTP_INTERNAL_ERROR) {
                return getWrappedInputStream(request.getErrorStream(),
                        GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
            } else {
                return getWrappedInputStream(request.getInputStream(),
                        GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
            }
		} catch (IOException e) {
			throw new FacebookGraphApiException(e);
		} finally {
//			httpclient.getConnectionManager().shutdown();
		}
	}

	/**
	 * Call api delete.
	 * 
	 * @param apiUrl the api url
	 */
	protected void callApiDelete(String apiUrl) {
		callApiDelete(apiUrl, HttpURLConnection.HTTP_OK);
	}
	
	/**
	 * Call api delete.
	 * 
	 * @param apiUrl the api url
	 * @param expected the expected
	 */
	protected void callApiDelete(String apiUrl, int expected) {
		try {
            URL               url     = new URL(apiUrl);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            
            if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
                request.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
            }

            if (ApplicationConstants.READ_TIMEOUT > -1) {
                request.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
            }
            
            for (String headerName : requestHeaders.keySet()) {
                request.setRequestProperty(headerName, requestHeaders.get(headerName));
            }
            
            request.setRequestMethod("DELETE");
			
            request.connect();

			if (request.getResponseCode() != expected) {
				throw new FacebookGraphApiException(convertStreamToString(request.getErrorStream()));
			}
		} catch (IOException e) {
			throw new FacebookGraphApiException(e);
		} finally {
//			httpclient.getConnectionManager().shutdown();
		}
	}
	
	/**
	 * Call api post.
	 * 
	 * @param apiUrl the api url
	 * @param parameters the parameters
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiPost(String apiUrl, Map<String, String> parameters) {
		return callApiPost(apiUrl, parameters, HttpURLConnection.HTTP_OK);
	}
	
	/**
	 * Call api post.
	 * 
	 * @param apiUrl the api url
	 * @param parameters the parameters
	 * @param expected the expected
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiPost(String apiUrl, Map<String, String> parameters, int expected) {
		try {
            URL               url     = new URL(apiUrl);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();

            if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
                request.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
            }

            if (ApplicationConstants.READ_TIMEOUT > -1) {
                request.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
            }
            
            for (String headerName : requestHeaders.keySet()) {
                request.setRequestProperty(headerName, requestHeaders.get(headerName));
            }

            request.setRequestMethod("POST");
            request.setDoOutput(true);

            PrintStream out = new PrintStream(new BufferedOutputStream(request.getOutputStream()));
            
            out.print(getParametersString(parameters));
            out.flush();
            out.close();

            request.connect();
            
            if (request.getResponseCode() == HttpURLConnection.HTTP_INTERNAL_ERROR) {
                return getWrappedInputStream(request.getErrorStream(),
                        GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
            } else {
                return getWrappedInputStream(request.getInputStream(),
                        GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
            }
		} catch (IOException e) {
			throw new FacebookGraphApiException(e);
		} finally {
//			httpclient.getConnectionManager().shutdown();
		}
	}
	
	protected String getParametersString(Map<String, String> parameters) {
		StringBuilder builder = new StringBuilder();
		for (Iterator<Map.Entry<String, String>> iterator = parameters.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<String, String> entry = iterator.next();
			builder.append(entry.getKey());
			builder.append("=");
			builder.append(encodeUrl(entry.getValue()));
			if (iterator.hasNext()) {
				builder.append("&");				
			}
		}
		
		return builder.toString();
	}

	/**
	 * Close stream.
	 * 
	 * @param is the is
	 */
	protected void closeStream(InputStream is) {
		try {
			is.close();
		} catch (IOException e) {
			LOG.log(Level.SEVERE, "An error occurred while closing stream.", e);
		}
	}

    /**
     * Method description
     *
     *
     * @param is
     * @param gzip
     * @return
     * @throws IOException
     */
    protected InputStream getWrappedInputStream(InputStream is, boolean gzip) throws IOException {
        if (gzip) {
            return new BufferedInputStream(new GZIPInputStream(is));
        } else {
            return new BufferedInputStream(is);
        }
    }
    
    /**
     * Encode url.
     * 
     * @param original the original
     * 
     * @return the string
     */
    private static String encodeUrl(String original) {
    	try {
			return URLEncoder.encode(original, ApplicationConstants.CONTENT_ENCODING);
		} catch (UnsupportedEncodingException e) {
			// should never be here..
			return original;
		}
    }
}
