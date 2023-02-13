package com.ninjaone.backendinterviewproject.resources;

/**
 * @author Wallace
 *
 */
public class ServiceSummary2 {

	private String type;	
	private int quantity;
	private double cost;
	
	/**
	 * Class Constructor 
	 */
	public ServiceSummary2() {
		super();
	}
	
	/**
	 * Class Constructor
	 * 
	 * @param type
	 * @param quantity
	 * @param cost
	 */
	public ServiceSummary2(String type, int quantity, double cost) {
		super();
		this.type = type;
		this.quantity = quantity;
		this.cost = cost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}


}
