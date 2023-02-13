package com.ninjaone.backendinterviewproject.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ninjaone.backendinterviewproject.model.Service;

/**
 * @author Wallace
 *
 */
public interface ServiceRepository extends JpaRepository<Service, Long>{

}
