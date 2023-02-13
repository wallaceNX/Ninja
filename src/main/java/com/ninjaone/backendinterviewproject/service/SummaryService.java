package com.ninjaone.backendinterviewproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ninjaone.backendinterviewproject.database.ServiceDeviceRepository;
import com.ninjaone.backendinterviewproject.database.OSRepository;
import com.ninjaone.backendinterviewproject.database.UtilityRepository;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import com.ninjaone.backendinterviewproject.model.OS;
import com.ninjaone.backendinterviewproject.model.Utility;
import com.ninjaone.backendinterviewproject.resources.DeviceSummary1;
import com.ninjaone.backendinterviewproject.resources.DeviceSummary2;
import com.ninjaone.backendinterviewproject.resources.ServiceSummary1;
import com.ninjaone.backendinterviewproject.resources.ServiceSummary2;
import com.ninjaone.backendinterviewproject.resources.Summary1;
import com.ninjaone.backendinterviewproject.resources.Summary2;

@Service
public class SummaryService {
	private ServiceDeviceRepository serviceDeviceRepository;	
	private OSRepository osRepository;	
	private UtilityRepository utilityRepository;
	
	/**
	 * Class Constructor
	 * 
	 * @param serviceDeviceRepository
	 * @param osRepository
	 * @param utilityRepository
	 */
	public SummaryService(ServiceDeviceRepository serviceDeviceRepository, OSRepository osRepository,
			UtilityRepository utilityRepository) {
		super();
		this.serviceDeviceRepository = serviceDeviceRepository;
		this.osRepository = osRepository;
		this.utilityRepository = utilityRepository;
	}	
	
	/**
	 * Get summary with total cost by Device Id
	 * 
	 * @param id
	 * @return 
	 */
	public DeviceSummary1 getSummaryByDeviceId(Long id) {		
		List<ServiceDevice> serviceDeviceList = serviceDeviceRepository.findDistinctByDeviceId(id);				
		List<ServiceSummary1> ServiceSummary1List = new ArrayList<>();
		
		DeviceSummary1 devicesSummary1 = new DeviceSummary1();
		
		for (ServiceDevice serviceDevice : serviceDeviceList) {			
			devicesSummary1.setName(serviceDevice.getDevice().getName());
			devicesSummary1.setType(serviceDevice.getDevice().getOs().getName());						
			ServiceSummary1 services = new ServiceSummary1();
			services.setType(serviceDevice.getService().getUtility().getName());
			services.setCost(serviceDevice.getService().getPrice());			
			ServiceSummary1List.add(services);			
		}			
		devicesSummary1.setServices(ServiceSummary1List);
		devicesSummary1.setTotal(ServiceSummary1List.stream().mapToDouble(p -> p.getCost()).sum());
		
		return devicesSummary1;
	}
	
	/**
	 * Get Summary with total cost By device
	 * 
	 * @return
	 */
	public Summary1 getSummaryByDevices() {				
		List<Device> deviceList = serviceDeviceRepository.findDistinctByDevice();				
		List<DeviceSummary1> deviceSummary1List =  new ArrayList<>();		
		
		Summary1 summary1 = new Summary1();
		
		for (Device device : deviceList) {			
			DeviceSummary1 deviceSummary1 = getSummaryByDeviceId(device.getId());
			deviceSummary1List.add(deviceSummary1);
		}		
		summary1.setDevices(deviceSummary1List);
		summary1.setTotal(deviceSummary1List.stream().mapToDouble(c -> c.getTotal()).sum());
		
		return summary1;
	}
	
	/**
	 * Get Summary with total cost By device type and utilities for services
	 * 
	 * @return
	 */
	public Summary2 getSummaryByDevicesByService() {						
		List<OS> osList = osRepository.findAll();		
		List<DeviceSummary2> devicesSummaryList = new ArrayList<>();		
		Summary2 summary2 = new Summary2();
		
		for (OS os : osList) {									
			List<ServiceDevice> serviceDeviceList = serviceDeviceRepository.findDistinctByDeviceOsId(os.getId());			
			List<Utility> utilityList = utilityRepository.findAll();						
			List<ServiceSummary2> serviceSummaryList = new ArrayList<>();
			
			DeviceSummary2 deviceSummary2 = new DeviceSummary2();			
						
			deviceSummary2.setType(os.getName());
			
			for (Utility utility : utilityList) {			
				int quantity = (int) serviceDeviceList.stream().filter(m -> m.getService().getUtility().getName().equals(utility.getName())).count();
				double costByService = serviceDeviceList.stream().filter(m -> m.getService().getUtility().getName().equals(utility.getName())).mapToDouble(x -> x.getService().getPrice()).sum();
			
				ServiceSummary2 serviceSummary2 = new ServiceSummary2();
				serviceSummary2.setType(utility.getName());
				serviceSummary2.setQuantity(quantity);
				serviceSummary2.setCost(costByService);
				
				serviceSummaryList.add(serviceSummary2);			
			}			
			deviceSummary2.setServices(serviceSummaryList);
			deviceSummary2.setTotal(serviceSummaryList.stream().mapToDouble(s -> s.getCost()).sum());			
			devicesSummaryList.add(deviceSummary2);						
		}		
		summary2.setDevices2(devicesSummaryList);
		summary2.setTotal(devicesSummaryList.stream().mapToDouble(d -> d.getTotal()).sum());
		
		return summary2;
	}
}
