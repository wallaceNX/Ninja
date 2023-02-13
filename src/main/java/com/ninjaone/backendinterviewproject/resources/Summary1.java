package com.ninjaone.backendinterviewproject.resources;

import java.util.List;

/**
 * @author Wallace
 *
 */
public class Summary1 {

	private List<DeviceSummary1> devices;
	
	private double total;

	/**
	 * Class Constructor
	 */
	public Summary1() {
		super();		
	}
	
	/**
	 * Class Constructor
	 * 
	 * @param devices
	 * @param total
	 */
	public Summary1(List<DeviceSummary1> devices, double total) {
		super();
		this.devices = devices;
		this.total = total;
	}

	public List<DeviceSummary1> getDevices() {
		return devices;
	}

	public void setDevices(List<DeviceSummary1> devices) {
		this.devices = devices;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}	
}
