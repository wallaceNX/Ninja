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

import com.ninjaone.backendinterviewproject.database.DeviceRepository;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.OS;

@ExtendWith(MockitoExtension.class)
class DeviceServiceTest {

	private static final Long ID = (long) 1;
	
	@Mock
	private DeviceRepository deviceRepository;
	
	@InjectMocks
	private DeviceService deviceService;
	
	private Device device;		
	
	@BeforeEach
	void setUp() throws Exception {		
		device = new Device("DeviceN167", new OS("Windows"));		
	}

	@Test
	void getDeviceData() {
		when(deviceRepository.findById(ID)).thenReturn(Optional.of(device));
        Optional<Device> deviceEntityOptional = deviceService.getDevice(ID);
        Device actualEntity = deviceEntityOptional.orElse(null);
        assert actualEntity != null;
        assertEquals(device.getId(), actualEntity.getId());
	}

    @Test
    void saveDeviceData() {
        when(deviceRepository.save(device)).thenReturn(device);
        assertEquals(device, deviceService.saveDevice(device));
    }

    @Test
    void deleteDeviceData(){
        doNothing().when(deviceRepository).deleteById(ID);
        deviceService.deleteDevice(ID);
        Mockito.verify(deviceRepository, times(1)).deleteById(ID);
    }
}
