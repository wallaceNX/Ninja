package com.ninjaone.backendinterviewproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICE_DEVICE")
@SequenceGenerator(name="generatorRecordId", sequenceName = "SERVICE_DEVICE_GENERATOR_ID", initialValue=1, allocationSize=1)
public class ServiceDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorRecordId")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ID_SERVICE", nullable = false)
    private Service service;
    
    @OneToOne
    @JoinColumn(name = "ID_DEVICE", nullable = false)
    private Device device;

    public ServiceDevice() {
		super();
	}    
    
	public ServiceDevice(Service service, Device device) {
		super();
		this.service = service;
		this.device = device;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}
    
    
}
