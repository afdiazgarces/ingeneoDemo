package com.project.demo.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.demo.controller.ProductoControllerApi;
import com.project.demo.service.IProductoService;

@SpringBootTest
public class ProductoControllerApiTest {

	@InjectMocks
	private ProductoControllerApi productoControllerApi;

	@Mock
	private IProductoService productoService;

	@Test
	void productoFindById() {
		
		when(productoService.findById(anyLong())).thenReturn(ProductoServiceTest.objectProducto());
		
		assertNotNull(productoControllerApi.productoFindById(0));
	}

	@Test
	void productoFindAll() {
		
		when(productoService.findAll()).thenReturn(List.of(ProductoServiceTest.objectProducto()));
		
		assertNotNull(productoControllerApi.productoFindAll());
	}

	@Test
	void productoSave() {

		assertNotNull(productoControllerApi.productoSave(ProductoServiceTest.objectProducto()));
	}

	@Test
	void productoDeleteId() {

		when(productoService.findById(anyLong())).thenReturn(ProductoServiceTest.objectProducto());

		
		assertNotNull(productoControllerApi.productoDeleteId(0));
	}

}
