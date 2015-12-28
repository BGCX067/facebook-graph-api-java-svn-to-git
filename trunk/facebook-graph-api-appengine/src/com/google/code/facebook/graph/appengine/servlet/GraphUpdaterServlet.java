package com.google.code.facebook.graph.appengine.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.code.facebook.graph.appengine.dal.MemcachedAccessTokenProvider;
import com.google.code.facebook.graph.client.AccessTokenProvider;
import com.google.code.facebook.graph.client.FacebookGraphApiClientFactory;

@SuppressWarnings("serial")
public class GraphUpdaterServlet extends HttpServlet {
	private FacebookGraphApiClientFactory factory;
	private AccessTokenProvider accessTokenProvider;
	
	@Override
	public void init() throws ServletException {
		super.init();
		factory = FacebookGraphApiClientFactory.newInstance();
		accessTokenProvider = new MemcachedAccessTokenProvider();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String id = req.getParameter("id");
		String command = req.getParameter("command");
	}
}
