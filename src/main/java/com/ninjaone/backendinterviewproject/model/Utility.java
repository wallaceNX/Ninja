package com.ninjaone.backendinterviewproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CAT_UTILITIES")
@SequenceGenerator(name="generatorUtilityId", sequenceName = "UTILITIES_GENERATOR_ID", initialValue=1, allocationSize=1)
public class Utility {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorUtilityId")
    private Long id;
        
    @Column(unique = true, nullable = false)
    private String name;

    public Utility() {
    	super();
	}
    
	public Utility(String name) {
		super();	
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
