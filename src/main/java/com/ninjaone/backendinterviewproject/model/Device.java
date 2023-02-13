package com.ninjaone.backendinterviewproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DEVICES")
@SequenceGenerator(name="generatorDeviceId", sequenceName = "DEVICES_GENERATOR_ID", initialValue=1, allocationSize=1)
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorDeviceId")
    private Long id;
        
    @Column(nullable = false, unique = true)
    private String name;
    
    @OneToOne
    @JoinColumn(name = "ID_OS", nullable = false)
    private OS os;

	public Device() {
	}

	public Device(String name, OS os) {
		super();
		this.name = name;		
		this.os = os;
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

	public OS getOs() {
		return os;
	}

	public void setOs(OS os) {
		this.os = os;
	}
}
