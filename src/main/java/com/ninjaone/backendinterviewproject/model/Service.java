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
@Table(name = "SERVICES")
@SequenceGenerator(name="generatorServiceId", sequenceName = "SERVICES_GENERATOR_ID", initialValue=1, allocationSize=1)
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorServiceId")
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "ID_OS", nullable = false)
    private OS os;
    
    @OneToOne
    @JoinColumn(name = "ID_UTILITY", nullable = false)
    private Utility utility;

    @Column(nullable = false)
    private double price;

	public Service() {
		super();
	}
	
	public Service(OS os, Utility utility, double price) {
		super();		
		this.os = os;
		this.utility = utility;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OS getOs() {
		return os;
	}

	public void setOs(OS os) {
		this.os = os;
	}

	public Utility getUtility() {
		return utility;
	}

	public void setUtility(Utility utility) {
		this.utility = utility;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
