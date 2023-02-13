package com.ninjaone.backendinterviewproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ninjaone.backendinterviewproject.database.ServiceRepository;
import com.ninjaone.backendinterviewproject.model.OS;
import com.ninjaone.backendinterviewproject.model.Service;
import com.ninjaone.backendinterviewproject.model.Utility;

@ExtendWith(MockitoExtension.class)
class ServiceServiceTest {

	private static final Long ID = (long) 1;
	
	@Mock
	private ServiceRepository serviceRepository;
	
	@InjectMocks
	private ServiceService serviceService;
	
	private Service service;
		
	@BeforeEach
	void setUp() throws Exception {				
		service = new Service(new OS("windows"), new Utility("Antivirus"), 5);		
	}

	@Test
	void getServiceData() {
		when(serviceRepository.findById(ID)).thenReturn(Optional.of(service));
        Optional<Service> ServiceEntityOptional = serviceService.getService(ID);
        Service actualEntity = ServiceEntityOptional.orElse(null);
        assert actualEntity != null;
        assertEquals(service.getId(), actualEntity.getId());
	}

    @Test
    void saveServiceData() {
        when(serviceRepository.save(service)).thenReturn(service);
        assertEquals(service, serviceService.saveService(service));
    }

    @Test
    void deleteServiceData(){
        doNothing().when(serviceRepository).deleteById(ID);
        serviceService.deleteService(ID);
        Mockito.verify(serviceRepository, times(1)).deleteById(ID);
    }

}
