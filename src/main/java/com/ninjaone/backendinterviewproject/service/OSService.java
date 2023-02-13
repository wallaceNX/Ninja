package com.ninjaone.backendinterviewproject.service;

import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ninjaone.backendinterviewproject.database.OSRepository;
import com.ninjaone.backendinterviewproject.model.OS;

@Service
public class OSService {

	private final OSRepository osRepository;	
	
	/**
	 * Class Constructor
	 * 
	 * @param osRepository
	 */
	public OSService(OSRepository osRepository) {
		super();
		this.osRepository = osRepository;
	}

	/**
	 * Get all Operating Systems
	 * 
	 * @return
	 */
	@Cacheable(value="oss")
	public Iterable<OS> getAllOS() {
		return osRepository.findAll();
	}
	
	/**
	 * Save Operating Systems
	 * 
	 * @param os
	 * @return
	 */	
	@CacheEvict(value="oss",allEntries=true)
	public OS saveOS(OS os){						
        return osRepository.save(os);
    }
	
	/**
	 * Save a list of Operating Systems
	 * 
	 * @param os
	 * @return
	 */
	@CacheEvict(value="oss",allEntries=true)
	public Iterable<OS> saveAllOS(Iterable<OS> os) {				
		return osRepository.saveAll(os);
	}
	
	/**
	 * Validate if exists Operating Systems by id
	 * 
	 * @param id
	 * @return
	 */
	public boolean existsOS(Long id) {
		return osRepository.existsById(id);
	}
	
    /**
     * Get Operating Systems by ID
     * 
     * @param id
     * @return
     */	
	@Cacheable(value="oss")
    public Optional<OS> getOS(Long id){
        return osRepository.findById(id);
    }
    
    /**
     * Delete Operating Systems by id
     * 
     * @param id
     */
	@CacheEvict(value="oss",allEntries=true)
    public void deleteOS(Long id) {    	    	
    	osRepository.deleteById(id);
    }	
	
	
}
