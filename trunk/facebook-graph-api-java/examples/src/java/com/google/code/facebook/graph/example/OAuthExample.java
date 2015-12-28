/**
 * 
 */
package com.google.code.facebook.graph.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.code.facebook.graph.client.oauth.FacebookAccessToken;
import com.google.code.facebook.graph.client.oauth.FacebookOAuthService;
import com.google.code.facebook.graph.client.oauth.FacebookOAuthServiceFactory;

/**
 * @author nmukhtar
 *
 */
public class OAuthExample {
	private static final String CLIENT_ID = "112986745406607";
	private static final String CLIENT_SECRET = "d9ec498e134be3cc0c8669e58cf26699";
	private static final String CALLBACK_URL = "http://facebookgraph.appspot.com/Main";

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FacebookOAuthService service = FacebookOAuthServiceFactory.getInstance().createFacebookOAuthService(CLIENT_ID, CLIENT_SECRET);
		String autorizationUrl = service.getAuthorizationUrl(CALLBACK_URL);
		System.out.println("Visit this url to get code and enter it.\n" + autorizationUrl);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
		FacebookAccessToken accessToken = service.getAccessToken(CALLBACK_URL, code);
		System.out.println("Access Token:" + accessToken.getAccessToken());
		System.out.println("Duration:" + accessToken.getDuration());
	}

}
