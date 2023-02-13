package com.ninjaone.backendinterviewproject.resources;

import java.util.List;

/**
 * @author Wallace
 *
 */
public class Summary2 {

	private List<DeviceSummary2> devices2;
	
	private double total;

	/**
	 * Class Constructor
	 */
	public Summary2() {
		super();
	}
	
	/**
	 * Class Constructor
	 * 
	 * @param devices2
	 * @param total
	 */
	public Summary2(List<DeviceSummary2> devices2, double total) {
		super();
		this.devices2 = devices2;
		this.total = total;
	}

	public List<DeviceSummary2> getDevices2() {
		return devices2;
	}

	public void setDevices2(List<DeviceSummary2> devices2) {
		this.devices2 = devices2;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
