/*
 * 
 */
package com.google.code.facebook.graph.model;

/**
 * The Interface Location.
 */
public interface Location {

	/**
	 * Gets the street.
	 * 
	 * @return the street
	 */
	public String getStreet();

	/**
	 * Gets the city.
	 * 
	 * @return the city
	 */
	public String getCity();

	/**
	 * Gets the state.
	 * 
	 * @return the state
	 */
	public String getState();

	/**
	 * Gets the zip.
	 * 
	 * @return the zip
	 */
	public String getZip();

	/**
	 * Gets the country.
	 * 
	 * @return the country
	 */
	public String getCountry();

	/**
	 * Gets the latitude.
	 * 
	 * @return the latitude
	 */
	public double getLatitude();

	/**
	 * Gets the longitude.
	 * 
	 * @return the longitude
	 */
	public double getLongitude();

}