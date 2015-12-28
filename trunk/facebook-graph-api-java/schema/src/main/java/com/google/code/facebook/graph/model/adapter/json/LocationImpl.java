/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.io.Serializable;

import org.json.simple.JSONObject;

import com.google.code.facebook.graph.model.Location;
import com.google.code.facebook.graph.model.adapter.Adapter;

/**
 * The Class LocationImpl.
 */
public class LocationImpl extends BaseJsonAdapter implements Adapter<JSONObject>, Location, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3112507792821438256L;
	
	/** The street. */
	private String street;
	
	/** The city. */
	private String city;
	
	/** The state. */
	private String state;
	
	/** The zip. */
	private String zip;
	
	/** The country. */
	private String country;
	
	/** The latitude. */
	private double latitude;
	
	/** The longitude. */
	private double longitude;
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Location#getStreet()
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Sets the street.
	 * 
	 * @param street the new street
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Location#getCity()
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the city.
	 * 
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Location#getState()
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Sets the state.
	 * 
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Location#getZip()
	 */
	public String getZip() {
		return zip;
	}
	
	/**
	 * Sets the zip.
	 * 
	 * @param zip the new zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Location#getCountry()
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Sets the country.
	 * 
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Location#getLatitude()
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * Sets the latitude.
	 * 
	 * @param latitude the new latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Location#getLongitude()
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * Sets the longitude.
	 * 
	 * @param longitude the new longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.json.BaseJsonAdapter#adaptFrom(org.json.simple.JSONObject)
	 */
	@Override
	public void adaptFrom(JSONObject adaptee) {
		copyProperties(this, adaptee);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.json.BaseJsonAdapter#adaptTo()
	 */
	@Override
	public JSONObject adaptTo() {
		JSONObject object = new JSONObject();
		copyProperties(object, this);
		return object;
	}
}
