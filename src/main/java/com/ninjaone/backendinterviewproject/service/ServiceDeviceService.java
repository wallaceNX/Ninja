package com.ninjaone.backendinterviewproject.service;

import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ninjaone.backendinterviewproject.database.ServiceDeviceRepository;
import com.ninjaone.backendinterviewproject.model.ServiceDevice;

@Service
public class ServiceDeviceService {

	private ServiceDeviceRepository serviceDeviceRepository;
		
	/**
	 * Class Constructor
	 * 
	 * @param serviceDeviceRepository
	 */
	public ServiceDeviceService(ServiceDeviceRepository serviceDeviceRepository) {
		super();
		this.serviceDeviceRepository = serviceDeviceRepository;
	}

	/**
	 * Get all records of resources allocated to devices
	 * 
	 * @return
	 */
	@Cacheable(value="records")
	public Iterable<ServiceDevice> getAllRecords() {
		return serviceDeviceRepository.findAll();
	}
	
	/**
	 * Save a list of records of resources allocated to devices
	 * 
	 * @param records
	 * @return
	 */
	@CacheEvict(value="records",allEntries=true)
	public Iterable<ServiceDevice> saveAllRecords(Iterable<ServiceDevice> records) {
		return serviceDeviceRepository.saveAll(records);		
	}
	
	/**
	 * 
	 * Save a record of resources allocated to devices
	 * 
	 * @param record
	 * @return
	 */
	@CacheEvict(value="records",allEntries=true)
	public ServiceDevice saveRecord(ServiceDevice record){
        return serviceDeviceRepository.save(record);
    }	
	
	/**
	 * validate if exists records of resources allocated to devices by id
	 * 
	 * @param id
	 * @return
	 */
	public boolean existsRecord(Long id) {
		return serviceDeviceRepository.existsById(id);
	}
	
    /**
     * Get records of resources allocated to devices by id
     * 
     * @param id
     * @return
     */
	@Cacheable(value="records")
    public Optional<ServiceDevice> getRecord(Long id){
        return serviceDeviceRepository.findById(id);
    }
    
    /**
     * Delete records of resources allocated to devices by id
     * 
     * @param id
     */
	@CacheEvict(value="records",allEntries=true)
    public void deleteRecord(Long id) {
    	serviceDeviceRepository.deleteById(id);
    }
}
