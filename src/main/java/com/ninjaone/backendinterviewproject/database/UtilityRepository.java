package com.ninjaone.backendinterviewproject.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ninjaone.backendinterviewproject.model.Utility;

/**
 * @author Wallace
 *
 */
public interface UtilityRepository extends JpaRepository<Utility, Long>{

}
