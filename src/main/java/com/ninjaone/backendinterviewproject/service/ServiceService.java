package com.ninjaone.backendinterviewproject.service;

import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ninjaone.backendinterviewproject.database.ServiceRepository;

@Service
public class ServiceService {

	private final ServiceRepository sarviceRepository;
	
	/**
	 * Class Constructor
	 * 
	 * @param serviceRepository
	 */
	public ServiceService(ServiceRepository serviceRepository) {
		super();
		this.sarviceRepository = serviceRepository;
	}

	/**
	 * get all services
	 * 
	 * @return
	 */
	@Cacheable(value="services")
	public Iterable<com.ninjaone.backendinterviewproject.model.Service> getAllServices() {
		return sarviceRepository.findAll();
	}
	
	/**
	 * save a service
	 * 
	 * @param service
	 * @return
	 */
	@CacheEvict(value="services",allEntries=true)
	public com.ninjaone.backendinterviewproject.model.Service saveService(com.ninjaone.backendinterviewproject.model.Service service){
        return sarviceRepository.save(service);
    }

	/**
	 * save a list of services
	 * 
	 * @param services
	 * @return
	 */	
	@CacheEvict(value="services",allEntries=true)
	public Iterable<com.ninjaone.backendinterviewproject.model.Service> saveAllService(Iterable<com.ninjaone.backendinterviewproject.model.Service> services){
		return sarviceRepository.saveAll(services); 
	}
	
	/**
	 * validate if exists service by id
	 * 
	 * @param id
	 * @return
	 */
	public boolean existsService(Long id) {
		return sarviceRepository.existsById(id);
	}
	
    /**
     * Get service by Id
     * 
     * @param id
     * @return
     */
	@Cacheable(value="services")
    public Optional<com.ninjaone.backendinterviewproject.model.Service> getService(Long id){
        return sarviceRepository.findById(id);
    }
    
    /**
     * Delete service by Id
     * 
     * @param id
     */
	@CacheEvict(value="services",allEntries=true)
    public void deleteService(Long id) {
    	sarviceRepository.deleteById(id);
    }
}
