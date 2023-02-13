package com.ninjaone.backendinterviewproject.service;

import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ninjaone.backendinterviewproject.database.UtilityRepository;
import com.ninjaone.backendinterviewproject.model.Utility;

@Service
public class UtilityService{
	
	private final UtilityRepository utilityRepository;
	
	/**
	 * Class Constructor
	 * 
	 * @param repository
	 */
	public UtilityService(UtilityRepository repository) {
		this.utilityRepository = repository;
	}

	/**
	 * Get all utilities
	 * 
	 * @return
	 */	
	@Cacheable(value="utilities")
	public Iterable<Utility> getAllUtilities() {
		return utilityRepository.findAll();
	}
	
	/**
	 * Save utility
	 * 
	 * @param utility
	 * @return
	 */
	@CacheEvict(value="utilities",allEntries=true)
	public Utility saveUtility(Utility utility){
        return utilityRepository.save(utility);
    }

	/**
	 * Save a list of utilities
	 * 
	 * @param utility
	 * @return
	 */
	@CacheEvict(value="utilities",allEntries=true)
	public Iterable<Utility> saveAllUtilities(Iterable<Utility> utility){
		return utilityRepository.saveAll(utility);
	}

	/**
	 * Validate if exists utility by id
	 * 
	 * @param id
	 * @return
	 */
	public boolean existsUtility(Long id) {
		return utilityRepository.existsById(id);
	}
	
    /**
     * Get utility by id
     * 
     * @param id
     * @return
     */	
	@Cacheable(value="utilities")
    public Optional<Utility> getUtility(Long id){
        return utilityRepository.findById(id);
    }
    
    /**
     * Delete utility by id
     * 
     * @param id
     */
	@CacheEvict(value="utilities",allEntries=true)
    public void deleteUtility(Long id) {
    	utilityRepository.deleteById(id);
    }
}
