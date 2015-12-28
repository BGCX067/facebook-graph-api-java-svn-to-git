package com.google.code.facebook.graph.appengine.servlet;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.code.facebook.graph.appengine.dal.MemcachedAccessTokenProvider;
import com.google.code.facebook.graph.client.AccessTokenProvider;
import com.google.code.facebook.graph.client.FacebookGraphApiClient;
import com.google.code.facebook.graph.client.FacebookGraphApiClientFactory;
import com.google.code.facebook.graph.model.User;

@SuppressWarnings("serial")
public class GraphFetcherServlet extends HttpServlet {
	private FacebookGraphApiClientFactory factory;
	private AccessTokenProvider accessTokenProvider;
	
	@Override
	public void init() throws ServletException {
		super.init();
		factory = FacebookGraphApiClientFactory.newInstance();
		accessTokenProvider = new MemcachedAccessTokenProvider();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String accessToken = req.getParameter("accessToken");
		FacebookGraphApiClient client = factory.createFacebookGraphApiClient(accessToken);
		User user = client.load(User.ME, accessTokenProvider);
		// save user id and token.
		serializeUser(user, resp);
	}

	private void serializeUser(User user, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/x-gzip");
		GZIPOutputStream gzos = new GZIPOutputStream(resp.getOutputStream());
		ObjectOutputStream oos = new ObjectOutputStream(gzos);
		oos.writeObject(user);
		gzos.finish();
		oos.flush();
	}
}
