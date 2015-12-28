/*
 * 
 */
package com.google.code.facebook.graph.model;

import java.util.List;


/**
 * The Interface Education.
 */
public interface Education {

	/**
	 * Gets the school.
	 * 
	 * @return the school
	 */
	public Page getSchool();

	/**
	 * Gets the year.
	 * 
	 * @return the year
	 */
	public Page getYear();

	/**
	 * Gets the degree.
	 * 
	 * @return the degree
	 */
	public Page getDegree();

	/**
	 * Gets the concentration.
	 * 
	 * @return the concentration
	 */
	public List<Page> getConcentration();

}