/*
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.code.facebook.graph.model.Education;
import com.google.code.facebook.graph.model.Page;
import com.google.code.facebook.graph.model.adapter.Adapter;

/**
 * The Class EducationImpl.
 */
public class EducationImpl extends BaseJsonAdapter implements Adapter<JSONObject>, Education, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3112507792821438256L;
	
	/** The school. */
	private Page school;
	
	/** The year. */
	private Page year;
	
	/** The degree. */
	private Page degree;
	
	/** The concentration. */
	private List<Page> concentration = new ArrayList<Page>();
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Education#getSchool()
	 */
	public Page getSchool() {
		return school;
	}

	/**
	 * Sets the school.
	 * 
	 * @param school the new school
	 */
	public void setSchool(Page school) {
		this.school = school;
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Education#getYear()
	 */
	public Page getYear() {
		return year;
	}

	/**
	 * Sets the year.
	 * 
	 * @param year the new year
	 */
	public void setYear(Page year) {
		this.year = year;
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Education#getDegree()
	 */
	public Page getDegree() {
		return degree;
	}

	/**
	 * Sets the degree.
	 * 
	 * @param degree the new degree
	 */
	public void setDegree(Page degree) {
		this.degree = degree;
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.Education#getConcentration()
	 */
	public List<Page> getConcentration() {
		return concentration;
	}

	/**
	 * Sets the concentration.
	 * 
	 * @param concentration the new concentration
	 */
	public void setConcentration(List<Page> concentration) {
		this.concentration = concentration;
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.model.adapter.json.BaseJsonAdapter#adaptFrom(org.json.simple.JSONObject)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void adaptFrom(JSONObject adaptee) {
		copyProperties(this, adaptee);
		JSONObject schoolJson = (JSONObject) adaptee.get("school");
		if (schoolJson != null) {
			this.school = new PageImpl();
			((PageImpl) school).adaptFrom(schoolJson);
		}
		JSONObject yearJson = (JSONObject) adaptee.get("year");
		if (yearJson != null) {
			this.year = new PageImpl();
			((PageImpl) year).adaptFrom(yearJson);
		}
		JSONObject degreeJson = (JSONObject) adaptee.get("degree");
		if (degreeJson != null) {
			this.degree = new PageImpl();
			((PageImpl) degree).adaptFrom(degreeJson);
		}
		JSONArray concentrationJson = (JSONArray) adaptee.get("concentration");
		if (concentrationJson != null) {
			for (JSONObject obj : (List<JSONObject>) concentrationJson) {
				Page conc = new PageImpl();
				((PageImpl) conc).adaptFrom(obj);
				concentration.add(conc);
			}
		}
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
