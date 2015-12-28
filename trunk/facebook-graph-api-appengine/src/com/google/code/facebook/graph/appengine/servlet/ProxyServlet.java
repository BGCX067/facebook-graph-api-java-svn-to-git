package com.google.code.facebook.graph.appengine.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ProxyServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
    	InputStream in = null;
    	OutputStream out = null;
		try {
			String targetUrl = req.getParameter("url");
	        URL               url     = new URL(targetUrl);
	        HttpURLConnection request = (HttpURLConnection) url.openConnection();
	        
	        request.connect();
	        
	        if (request.getResponseCode() == HttpURLConnection.HTTP_OK) {
	        	in = request.getInputStream();
	        	out = resp.getOutputStream();
	        	byte[] buf = new byte[1024]; 
	        	int len; 
	        	while ((len = in.read(buf)) > 0) { 
	        		out.write(buf, 0, len); 
	        	} 
	        }
		} finally {
			closeStream(in);
		}
	}

	private void closeStream(InputStream in) {
		if (in != null) {
			try {
				in.close();
			} catch (Exception e) {}
		}
	}
}
