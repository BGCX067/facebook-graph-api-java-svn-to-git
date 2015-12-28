/**
 *
 */
package com.google.code.facebook.graph.sna.service;

import java.util.Set;

import com.google.code.facebook.graph.model.GraphNode;
import com.google.code.facebook.graph.sna.service.jung.JungFacebookGraphAnalyzer;


/**
 * A factory for creating FacebookGraphApiClient objects.
 * 
 * @author Nabeel Mukhtar
 */
public class FacebookGraphAnalyzerFactory {
	
	private FacebookGraphAnalyzerFactory() {
		
	}


    /**
     * New instance.
     * 
     * @param consumerKey the consumer key
     * @param consumerSecret the consumer secret
     * 
     * @return the linked in api client factory
     */
    public static FacebookGraphAnalyzerFactory newInstance() {
        return new FacebookGraphAnalyzerFactory();
    }
    
    public FacebookSocialNetworkAnalyzer createFacebookSocialNetworkAnalyzer(Set<GraphNode<?, ?>> nodes) {
    	return new JungFacebookGraphAnalyzer(nodes);
    }
}
