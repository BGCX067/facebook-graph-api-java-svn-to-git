/**
 * 
 */
package com.google.code.facebook.graph.model.adapter.json;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.code.facebook.graph.model.Insight;
import com.google.code.facebook.graph.model.InsightValue;
import com.google.code.facebook.graph.model.enumeration.Period;

/**
 * @author nmukhtar
 *
 */
public class InsightImpl extends BaseEntity implements Insight {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4346440432868204539L;
	
	private String name;
	private Period period;
	private List<InsightValue> values = new ArrayList<InsightValue>();
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the period
	 */
	public Period getPeriod() {
		return period;
	}
	/**
	 * @param period the period to set
	 */
	public void setPeriod(Period period) {
		this.period = period;
	}
	/**
	 * @return the values
	 */
	public List<InsightValue> getValues() {
		return values;
	}
	/**
	 * @param values the values to set
	 */
	public void setValues(List<InsightValue> values) {
		this.values = values;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void adaptFrom(JSONObject adaptee) {
		super.adaptFrom(adaptee);
		JSONArray valuesJson = (JSONArray) adaptee.get("values");
		if (valuesJson != null) {
			for (JSONObject obj : (List<JSONObject>) valuesJson) {
				InsightValue value = new InsightValueImpl();
				((InsightValueImpl) value).adaptFrom(obj);
				values.add(value);				
			}
		}
	}
	@Override
	public String getDescription() {
		return getLabel();
	}
	@Override
	public String getLabel() {
		return getName();// + "[" + getId() + "]";
	}
}
