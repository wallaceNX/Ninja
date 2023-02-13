package com.ninjaone.backendinterviewproject.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ninjaone.backendinterviewproject.model.OS;

/**
 * @author Wallace
 *
 */
public interface OSRepository extends JpaRepository<OS, Long>{

}
