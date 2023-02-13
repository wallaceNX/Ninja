package com.ninjaone.backendinterviewproject.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import com.ninjaone.backendinterviewproject.model.Service;

/** 
 * @author Wallace
 *
 */
public interface ServiceDeviceRepository extends JpaRepository<ServiceDevice, Long> {
	
	List<ServiceDevice> findDistinctByDeviceId(Long id);		
	
	@Query("SELECT DISTINCT x.device FROM ServiceDevice x")
	List<Device> findDistinctByDevice();
	
	@Query("SELECT DISTINCT x.service FROM ServiceDevice x")
	List<Service> findDistinctByService();
		
	List<ServiceDevice> findDistinctByDeviceOsId(Long id);
}
