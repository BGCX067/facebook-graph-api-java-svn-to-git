package com.google.code.facebook.graph.appengine.servlet;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.code.facebook.graph.client.constant.ParameterNames;
import com.google.code.facebook.graph.client.oauth.FacebookAccessToken;
import com.google.code.facebook.graph.client.oauth.FacebookOAuthService;
import com.google.code.facebook.graph.client.oauth.FacebookOAuthServiceFactory;
import com.google.code.facebook.graph.model.enumeration.Permission;

@SuppressWarnings("serial")
public class MainServlet extends HttpServlet {
	private FacebookOAuthService service;
	private String callbackUrl;
	private static final Set<Permission> REQUIRED_PERMISSIONS = EnumSet.of(Permission.READ_STREAM, Permission.READ_MAILBOX, Permission.CREATE_EVENT, Permission.PUBLISH_STREAM, Permission.OFFLINE_ACCESS);
	
	@Override
	public void init() throws ServletException {
		super.init();
		String consumerKey = getInitParameter("consumerKey");
		String consumerSecret = getInitParameter("consumerSecret");
		callbackUrl = getInitParameter("callbackUrl");		
		service = FacebookOAuthServiceFactory.getInstance().createFacebookOAuthService(consumerKey, consumerSecret);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		if (isNullOrEmpty(req.getParameter(ParameterNames.CODE))) {
			String authorizationUrl = service.getAuthorizationUrl(callbackUrl, REQUIRED_PERMISSIONS);
			log("Redirecting to:" + authorizationUrl);
			resp.sendRedirect(authorizationUrl);		
		} else {
			FacebookAccessToken accessToken = service.getAccessToken(callbackUrl, req.getParameter(ParameterNames.CODE));
			// get the id...
			// save access token in bigtable.
			// forward to the applet page.
			req.setAttribute("accessToken", accessToken.getAccessToken());
			try {
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			} catch (ServletException e) {
				log("Error forwarding to graph page.", e);
			}
		}
	}
	
	protected boolean isNullOrEmpty(String text) {
		return text == null || text.length() == 0; 
	}
}
