package com.project.demo.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.demo.controller.ClienteControllerApi;
import com.project.demo.service.IClienteService;

@SpringBootTest
public class ClienteControllerApiTest {

	@InjectMocks
	private ClienteControllerApi clienteControllerApi;

	@Mock
	private IClienteService clienteService;

	@Test
	void clienteFindById() {
		
		when(clienteService.findById(anyLong())).thenReturn(ClienteServiceTest.objectCliente());
		
		assertNotNull(clienteControllerApi.clientefindById(0));
	}

	@Test
	void clienteFindAll() {
		
		when(clienteService.findAll()).thenReturn(List.of(ClienteServiceTest.objectCliente()));
		
		assertNotNull(clienteControllerApi.clientefindAll());
	}

	@Test
	void clienteSave() {

		assertNotNull(clienteControllerApi.clienteSave(ClienteServiceTest.objectCliente()));
	}

	@Test
	void clienteDeleteId() {

		when(clienteService.findById(anyLong())).thenReturn(ClienteServiceTest.objectCliente());

		
		assertNotNull(clienteControllerApi.clienteDeleteId(0));
	}

}
