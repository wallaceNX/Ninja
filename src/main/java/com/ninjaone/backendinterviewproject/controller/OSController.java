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

import com.ninjaone.backendinterviewproject.model.OS;
import com.ninjaone.backendinterviewproject.service.OSService;

@RestController
public class OSController {

	@Autowired
	private OSService osService;
		
	@GetMapping("/os")
    private Iterable<OS> getAllOS(){
        return osService.getAllOS();
    }
	
	@PostMapping("/oss")
	@ResponseStatus(HttpStatus.CREATED)
	private Iterable<OS> saveAllOS(@RequestBody Iterable<OS> oss){
		return osService.saveAllOS(oss);
	}
	
	@PostMapping("/os")	
	@ResponseStatus(HttpStatus.CREATED)
	private OS saveOS(@RequestBody OS os) {		
		return osService.saveOS(os); 								
	}
	
	@DeleteMapping("/os/{id}")    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteOS(@PathVariable Long id){
        osService.deleteOS(id);
    }
}
