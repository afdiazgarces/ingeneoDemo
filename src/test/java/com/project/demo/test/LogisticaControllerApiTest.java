package com.project.demo.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.demo.controller.LogisticaControllerApi;
import com.project.demo.service.ILogisticaService;

@SpringBootTest
public class LogisticaControllerApiTest {

	@InjectMocks
	private LogisticaControllerApi logisticaControllerApi;

	@Mock
	private ILogisticaService logisticaService;

	@Test
	void bodegaFindById() {
		
		when(logisticaService.findById(anyLong())).thenReturn(LogisticaServiceTest.objectLogistica());
		
		assertNotNull(logisticaControllerApi.logisticaFindById(0));
	}

	@Test
	void logisticaFindAll() {
		
		when(logisticaService.findAll()).thenReturn(List.of(LogisticaServiceTest.objectLogistica()));
		
		assertNotNull(logisticaControllerApi.logisticaFindAll());
	}

	@Test
	void logisticaSave() throws Exception {

		assertNotNull(logisticaControllerApi.logisticaSave(LogisticaServiceTest.objectLogistica()));
	}
	
	@Test
	void logisticaDeleteId() {

		when(logisticaService.findById(anyLong())).thenReturn(LogisticaServiceTest.objectLogistica());

		
		assertNotNull(logisticaControllerApi.logisticaDeleteId(0));
	}

	
	
}
