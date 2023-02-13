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

import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.service.DeviceService;
import com.ninjaone.backendinterviewproject.service.OSService;

@RestController
public class DeviceController {

	@Autowired
	private DeviceService deviceService;	
	
	@Autowired
	private OSService osService;
	
	@GetMapping("/device/{id}")
    private Device getDevice(@PathVariable Long id){
        return deviceService.getDevice(id).orElseThrow();
    }
	
	@GetMapping("/devices")
    private Iterable<Device> getAllDevices(){
        return deviceService.getAllDevices();
    }
		
	@PostMapping("/devices")	
	@ResponseStatus(HttpStatus.CREATED)
	private Iterable<Device> saveAllDevices(@RequestBody Iterable<Device> devices) {		
		return deviceService.saveAllDevices(devices); 								
	}
	
	@PostMapping("/device")	
	@ResponseStatus(HttpStatus.CREATED)
	private Device saveDevice(@RequestBody Device device ) {
		
		if (!osService.existsOS(device.getOs().getId())) {				
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "os not found");
		}
		
		try {						
			return deviceService.saveDevice(device);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}				
	}
	
    @DeleteMapping("/device/{id}")    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteDevice(@PathVariable Long id){
        deviceService.deleteDevice(id);
    }
}
