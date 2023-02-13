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

import com.ninjaone.backendinterviewproject.model.Service;
import com.ninjaone.backendinterviewproject.service.OSService;
import com.ninjaone.backendinterviewproject.service.ServiceService;
import com.ninjaone.backendinterviewproject.service.UtilityService;

@RestController
public class ServiceController {

	@Autowired
	private ServiceService service;
	
	@Autowired
	private OSService osService;
	
	@Autowired
	private UtilityService utilityService;
	
	@GetMapping("/service/{id}")
    private Service getService(@PathVariable Long id){
        return service.getService(id).orElseThrow();
    }
	
	@GetMapping("/services")
    private Iterable<Service> getAllServices(){
        return service.getAllServices();
    }
		
	@PostMapping("/services")	
	@ResponseStatus(HttpStatus.CREATED)
	private Iterable<Service> saveAllServices(@RequestBody Iterable<Service> services) {
		return service.saveAllService(services); 								
	}
	
	@PostMapping("/service")	
	@ResponseStatus(HttpStatus.CREATED)
	private Service saveDevice(@RequestBody Service serviceIn) {		
		if (!osService.existsOS(serviceIn.getOs().getId())) {				
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "os not found");
		}
		
		if (!utilityService.existsUtility(serviceIn.getUtility().getId())) {				
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "utility not found");
		}
		
		try {			
			return service.saveService(serviceIn);			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}		 								
	}
	
    @DeleteMapping("/service/{id}")    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteService(@PathVariable Long id){
        service.deleteService(id);
    }
}
