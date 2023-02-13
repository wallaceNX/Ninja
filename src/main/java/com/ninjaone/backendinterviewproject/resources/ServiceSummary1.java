package com.ninjaone.backendinterviewproject.resources;

/**
 * @author Wallace
 *
 */
public class ServiceSummary1 {

	private String type;	
	private double cost;
	
	/**
	 * Class Constructor
	 */
	public ServiceSummary1() {
		super();
	}
	
	/**
	 * Class Constructor
	 * 
	 * @param type
	 * @param cost
	 */
	public ServiceSummary1(String type, double cost) {
		super();
		this.type = type;		
		this.cost = cost;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
