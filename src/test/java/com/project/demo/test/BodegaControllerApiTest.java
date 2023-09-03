package com.project.demo.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.demo.controller.BodegaControllerApi;
import com.project.demo.service.IBodegaService;

@SpringBootTest
public class BodegaControllerApiTest {

	@InjectMocks
	private BodegaControllerApi bodegaControllerApi;

	@Mock
	private IBodegaService bodegaService;

	@Test
	void bodegaFindById() {
		
		when(bodegaService.findById(anyLong())).thenReturn(BodegaServiceTest.objectBodega());
		
		assertNotNull(bodegaControllerApi.bodegaFindById(0));
	}

	@Test
	void bodegaFindAll() {
		
		when(bodegaService.findAll()).thenReturn(List.of(BodegaServiceTest.objectBodega()));
		
		assertNotNull(bodegaControllerApi.bodegaFindAll());
	}

	@Test
	void bodegaSave() {

		assertNotNull(bodegaControllerApi.bodegaSave(BodegaServiceTest.objectBodega()));
	}
	
	@Test
	void bodegaDeleteId() {

		when(bodegaService.findById(anyLong())).thenReturn(BodegaServiceTest.objectBodega());

		
		assertNotNull(bodegaControllerApi.bodegaDeleteId(0));
	}

	
	
}
