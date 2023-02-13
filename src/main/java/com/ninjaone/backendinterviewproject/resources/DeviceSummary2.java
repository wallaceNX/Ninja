package com.ninjaone.backendinterviewproject.resources;

import java.util.List;

/**
 * @author Wallace
 *
 */
public class DeviceSummary2 {

	private String type;	
	
	private List<ServiceSummary2> services;
	
	private double total;
	
	/**
	 * Class Constructor 
	 */
	public DeviceSummary2() {
		super();
	}
	
	
	/**
	 * Class Constructor
	 * 
	 * @param type
	 * @param services
	 * @param total
	 */
	public DeviceSummary2(String type, List<ServiceSummary2> services, double total) {
		super();
		this.type = type;
		this.services = services;
		this.total = total;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ServiceSummary2> getServices() {
		return services;
	}

	public void setServices(List<ServiceSummary2 > services) {
		this.services = services;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
