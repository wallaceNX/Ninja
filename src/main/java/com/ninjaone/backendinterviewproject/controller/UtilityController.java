 package com.ninjaone.backendinterviewproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ninjaone.backendinterviewproject.model.Utility;
import com.ninjaone.backendinterviewproject.service.UtilityService;

@RestController
public class UtilityController {
	
	@Autowired
	private UtilityService utilityService;		
	
	@Cacheable(value="utilities")
	@GetMapping("/utilities")
	private Iterable<Utility> getAllUtilities() {
		return utilityService.getAllUtilities();
	}

	@PostMapping("/utilities")
	@ResponseStatus(HttpStatus.CREATED)
	private Iterable<Utility> saveUtility(@RequestBody Iterable<Utility> utilities) {
		return utilityService.saveAllUtilities(utilities); 								
	}
	
	@PostMapping("/utility")
	@ResponseStatus(HttpStatus.CREATED)
	private Utility saveUtility(@RequestBody Utility utility) {
		return utilityService.saveUtility(utility); 								
	}
	
    @DeleteMapping("/utility/{id}")    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteUtility(@PathVariable Long id){
        utilityService.deleteUtility(id);
    }
}
