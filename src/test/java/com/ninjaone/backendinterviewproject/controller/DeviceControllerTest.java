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
import com.ninjaone.backendinterviewproject.service.DeviceService;
import com.ninjaone.backendinterviewproject.service.OSService;

@ContextConfiguration(classes = {BackendInterviewProjectApplication.class})
@AutoConfigureMockMvc
@WebMvcTest(DeviceController.class)
@AutoConfigureDataJpa
public class DeviceControllerTest {
	
	private static final Long ID = (long) 1;
	
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private DeviceService deviceService; 
    
    @MockBean
    private OSService osService;
    
    private Device device;
	
	@BeforeEach
	void setUp() throws Exception {		
		device = new Device("DeviceN167", new OS("Windows"));
	}

	@Test
    void postDeviceData() throws Exception {										
		when(deviceService.saveDevice(device)).thenReturn(device);

        String DeviceEntityString = objectMapper.writeValueAsString(device);
        mockMvc.perform(post("/device")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(DeviceEntityString))
                .andExpect(status().isCreated());        		
    }
	
	@Test
	void getDeviceData() throws JsonProcessingException, Exception {				
		when(deviceService.getDevice(ID)).thenReturn(Optional.of(device));

        mockMvc.perform(get("/device/" + ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(objectMapper.writeValueAsString(device)));
	}

}
