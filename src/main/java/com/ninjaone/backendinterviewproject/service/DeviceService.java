package com.ninjaone.backendinterviewproject.service;

import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ninjaone.backendinterviewproject.database.DeviceRepository;
import com.ninjaone.backendinterviewproject.model.Device;

@Service
public class DeviceService{

	private final DeviceRepository deviceRepository;
		
	/**
	 * Class constructor
	 * @param deviceRepository
	 */
	public DeviceService(DeviceRepository deviceRepository) {
		super();
		this.deviceRepository = deviceRepository;
	}
		
	/**
	 * Get all devices 
	 * @return
	 */
	@Cacheable(value="devices")
	public Iterable<Device> getAllDevices() {
		return deviceRepository.findAll();
	}
	
	/**
	 * Save a list of devices
	 * @param device
	 * @return
	 */
	@CacheEvict(value="devices",allEntries=true)
	public Iterable<Device> saveAllDevices(Iterable<Device> device) {
		return deviceRepository.saveAll(device);
	}
	
	/**
	 * @param device
	 * @return
	 */
	@CacheEvict(value="devices",allEntries=true)
	public Device saveDevice(Device device){
        return deviceRepository.save(device);
    }
	
	/**
	 * Validate if exists device by id
	 * @param id
	 * @return
	 */
	public boolean existsDevice(Long id) {
		return deviceRepository.existsById(id);
	}
	
    /**
     * Get Device by id
     * @param id
     * @return
     */
	@Cacheable(value="devices")
	public Optional<Device> getDevice(Long id){
        return deviceRepository.findById(id);
    }
    
    /**
     * Delete device by Id
     * @param id
     */
	@CacheEvict(value="devices",allEntries=true)
    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }
}
