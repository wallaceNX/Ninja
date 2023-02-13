package com.ninjaone.backendinterviewproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import com.ninjaone.backendinterviewproject.service.DeviceService;
import com.ninjaone.backendinterviewproject.service.ServiceDeviceService;
import com.ninjaone.backendinterviewproject.service.ServiceService;

@RestController
public class ServiceDeviceController {

	@Autowired
	private ServiceDeviceService serviceDeviceService;
	
	@Autowired
	private ServiceService service;
	
	@Autowired
	private DeviceService deviceService;	
	
	@GetMapping("/records")
    private Iterable<ServiceDevice> getAllRecords(){
        return serviceDeviceService.getAllRecords();
    }
	
	@GetMapping("/record/{id}")
    private ServiceDevice getRecord(@PathVariable Long id){
        return serviceDeviceService.getRecord(id).orElseThrow();
    }
		
	@PostMapping("/records")	
	@ResponseStatus(HttpStatus.CREATED)
	private Iterable<ServiceDevice> saveAllRecords(@RequestBody Iterable<ServiceDevice> records) {
		return serviceDeviceService.saveAllRecords(records); 								
	}
	
	@PostMapping("/record")	
	@ResponseStatus(HttpStatus.CREATED)
	private ServiceDevice saveRecord(@RequestBody ServiceDevice record ) {
		
		if (!deviceService.existsDevice(record.getDevice().getId())) {				
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "device not found");
		}
		
		if (!service.existsService(record.getService().getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "service not found");
		}
		
		try {
			return serviceDeviceService.saveRecord(record);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}   								
	}
	
    @DeleteMapping("/record/{id}")    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteRecord(@PathVariable Long id){
    	serviceDeviceService.deleteRecord(id);
    }
}
