package com.ninjaone.backendinterviewproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ninjaone.backendinterviewproject.resources.DeviceSummary1;
import com.ninjaone.backendinterviewproject.resources.Summary1;
import com.ninjaone.backendinterviewproject.resources.Summary2;
import com.ninjaone.backendinterviewproject.service.SummaryService;

@RestController
public class SummaryController {

	@Autowired
	private SummaryService summaryService;
	
	@GetMapping("/summary/device/{id}")
    private DeviceSummary1 getSummaryByDeviceId(@PathVariable Long id){
        return summaryService.getSummaryByDeviceId(id);
    }
	
	@GetMapping("/summary/devices")
    private Summary1 getSummaryByDevices(){
        return summaryService.getSummaryByDevices();
    }
	
	@GetMapping("/summary/services")
    private Summary2 getSummaryByDevicesByService(){
        return summaryService.getSummaryByDevicesByService();
    }
}
