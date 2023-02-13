package com.ninjaone.backendinterviewproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CAT_OS")
@SequenceGenerator(name = "generatorOSId", sequenceName = "OS_GENERATOR_ID", initialValue = 1, allocationSize = 1)
public class OS {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorOSId")
	private Long id;

	@Column(unique = true, nullable = false)
	private String name;

	public OS() {
		super();
	}

	public OS(String name) {
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
