package com.ninjaone.backendinterviewproject.resources;

import java.util.List;

/**
 * @author Wallace
 *
 */
public class DeviceSummary1 {

	private String name;
	private String type;

	private List<ServiceSummary1> services;

	private double total;

	/**
	 * Class Constructor
	 */
	public DeviceSummary1() {
		super();
	}

	/**
	 * Class Constructor
	 * 
	 * @param name
	 * @param type
	 * @param services
	 * @param total
	 */
	public DeviceSummary1(String name, String type, List<ServiceSummary1> services, double total) {
		super();
		this.name = name;
		this.type = type;
		this.services = services;
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ServiceSummary1> getServices() {
		return services;
	}

	public void setServices(List<ServiceSummary1> services) {
		this.services = services;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
