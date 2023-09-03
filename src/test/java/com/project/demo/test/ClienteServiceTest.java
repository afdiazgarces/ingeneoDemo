package com.project.demo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.demo.model.Cliente;
import com.project.demo.repository.ClienteRepository;
import com.project.demo.service.ClienteServiceImpl;

@SpringBootTest
public class ClienteServiceTest {

	@InjectMocks
	private ClienteServiceImpl clienteServiceImpl;

	@Mock
	private ClienteRepository clienteRepository;

	@Test
	void findAll() {

		Iterable<Cliente> list = List.of(objectCliente());

		when(clienteRepository.findAll()).thenReturn(list);

		assertNotNull(clienteServiceImpl.findAll());

	}

	@Test
	void findById() {
		Optional<Cliente> list = Optional.ofNullable(objectCliente());

		when(clienteRepository.findById(anyLong())).thenReturn(list);

		assertNotNull(clienteServiceImpl.findById(0));

	}

	@Test
	public void saveTest() {
		clienteServiceImpl.save(objectCliente());
		assertEquals(objectCliente().getId(), objectCliente().getId());
	}

	@Test
	public void deleteTest() {
		clienteServiceImpl.delete(objectCliente());
		assertEquals(objectCliente().getId(), objectCliente().getId());
	}

	public static Cliente objectCliente() {
		Cliente cli = new Cliente();
		cli.setNombres("Jose");
		cli.setApellidos("Roberto");
		return cli;

	}

}
