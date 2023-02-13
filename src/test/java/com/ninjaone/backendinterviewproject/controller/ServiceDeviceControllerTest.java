package com.ninjaone.backendinterviewproject.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninjaone.backendinterviewproject.BackendInterviewProjectApplication;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.OS;
import com.ninjaone.backendinterviewproject.model.Service;
import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import com.ninjaone.backendinterviewproject.model.Utility;
import com.ninjaone.backendinterviewproject.service.DeviceService;
import com.ninjaone.backendinterviewproject.service.ServiceDeviceService;
import com.ninjaone.backendinterviewproject.service.ServiceService;

@ContextConfiguration(classes = {BackendInterviewProjectApplication.class})
@AutoConfigureMockMvc
@WebMvcTest(ServiceDeviceController.class)
@AutoConfigureDataJpa
public class ServiceDeviceControllerTest {

	private static final Long ID = (long) 1;
	
	@Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;
    
    @MockBean
    private ServiceDeviceService serviceDeviceService;
    
    @MockBean
    private ServiceService serviceService;
    
    @MockBean
    private DeviceService deviceService;
    
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
    void postRecordData() throws Exception {										
		when(serviceDeviceService.saveRecord(record)).thenReturn(record);

        String RecordEntityString = objectMapper.writeValueAsString(record);
        mockMvc.perform(post("/record")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(RecordEntityString))
                .andExpect(status().isCreated());
    }
	
	@Test
	void getRecordData() throws JsonProcessingException, Exception {				
		when(serviceDeviceService.getRecord(ID)).thenReturn(Optional.of(record));

        mockMvc.perform(get("/record/" + ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))                
                .andExpect(content().string(objectMapper.writeValueAsString(record)));
	}
}
