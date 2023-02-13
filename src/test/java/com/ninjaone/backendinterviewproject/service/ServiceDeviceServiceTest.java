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

import com.ninjaone.backendinterviewproject.database.ServiceDeviceRepository;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.OS;
import com.ninjaone.backendinterviewproject.model.Service;
import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import com.ninjaone.backendinterviewproject.model.Utility;

@ExtendWith(MockitoExtension.class)
public class ServiceDeviceServiceTest {

	private static final Long ID = (long) 1;
	
	@Mock
	private ServiceDeviceRepository serviceDeviceRepository;
	
	@InjectMocks
	private ServiceDeviceService servicDeviceService;
	
	private ServiceDevice record;
	
	private Device device;
	
	private Service service;		
	
	@BeforeEach
	void setUp() throws Exception {
		service = new Service(new OS("windows"), new Utility("Antivirus"), 5);
		device = new Device("DeviceN167", new OS("Windows"));
		record = new ServiceDevice(service, device);		
	}

	@Test
	void getRecordData() {
		when(serviceDeviceRepository.findById(ID)).thenReturn(Optional.of(record));
        Optional<ServiceDevice> recordEntityOptional = servicDeviceService.getRecord(ID);
        ServiceDevice actualEntity = recordEntityOptional.orElse(null);
        assert actualEntity != null;
        assertEquals(device.getId(), actualEntity.getId());
	}

    @Test
    void saveRecordData() {
        when(serviceDeviceRepository.save(record)).thenReturn(record);
        assertEquals(record, servicDeviceService.saveRecord(record));
    }

    @Test
    void deleteRecordData(){
        doNothing().when(serviceDeviceRepository).deleteById(ID);
        servicDeviceService.deleteRecord(ID);
        Mockito.verify(serviceDeviceRepository, times(1)).deleteById(ID);
    }
	
}
