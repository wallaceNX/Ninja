package com.ninjaone.backendinterviewproject.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ninjaone.backendinterviewproject.model.Device;

/** 
 * @author Wallace
 *
 */
public interface DeviceRepository extends JpaRepository<Device, Long>{

}
