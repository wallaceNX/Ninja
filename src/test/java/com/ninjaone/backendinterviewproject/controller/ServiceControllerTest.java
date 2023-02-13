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
import com.ninjaone.backendinterviewproject.model.OS;
import com.ninjaone.backendinterviewproject.model.Service;
import com.ninjaone.backendinterviewproject.model.Utility;
import com.ninjaone.backendinterviewproject.service.OSService;
import com.ninjaone.backendinterviewproject.service.ServiceService;
import com.ninjaone.backendinterviewproject.service.UtilityService;

@ContextConfiguration(classes = {BackendInterviewProjectApplication.class})
@AutoConfigureMockMvc
@WebMvcTest(ServiceController.class)
@AutoConfigureDataJpa
public class ServiceControllerTest {

	private static final Long ID = (long) 1;
	
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private ServiceService serviceService; 
	
    @MockBean
    private OSService osService;
    
    @MockBean
    private UtilityService utilityService;
    
	private Service service;	
	
	@BeforeEach
	void setUp() throws Exception {		
		service = new Service(new OS("windows"), new Utility("Antivirus"), 5);
	}
	
	@Test
    void postServiceData() throws Exception {										
		when(serviceService.saveService(service)).thenReturn(service);

        String DeviceEntityString = objectMapper.writeValueAsString(service);
        mockMvc.perform(post("/service")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(DeviceEntityString))
                .andExpect(status().isCreated());
    }
	
	@Test
	void getServiceData() throws JsonProcessingException, Exception {				
		when(serviceService.getService(ID)).thenReturn(Optional.of(service));

        mockMvc.perform(get("/service/" + ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(objectMapper.writeValueAsString(service)));
	}
}
