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

import com.project.demo.model.Producto;
import com.project.demo.repository.ProductoRepository;
import com.project.demo.service.ProductoServiceImpl;

@SpringBootTest
public class ProductoServiceTest {

	@InjectMocks
	private ProductoServiceImpl productoServiceImpl;

	@Mock
	private ProductoRepository productoRepository;

	@Test
	void findAll() {

		Iterable<Producto> list = List.of(objectProducto());

		when(productoRepository.findAll()).thenReturn(list);

		assertNotNull(productoServiceImpl.findAll());

	}

	@Test
	void findById() {
		Optional<Producto> list = Optional.ofNullable(objectProducto());

		when(productoRepository.findById(anyLong())).thenReturn(list);

		assertNotNull(productoServiceImpl.findById(0));

	}

	@Test
	public void saveTest() {
		productoServiceImpl.save(objectProducto());
		assertEquals(objectProducto().getId(), objectProducto().getId());
	}

	@Test
	public void deleteTest() {
		productoServiceImpl.delete(objectProducto());
		assertEquals(objectProducto().getId(), objectProducto().getId());
	}

	public static Producto objectProducto() {
		Producto pro = new Producto();
		pro.setNombre("Uvas");
		pro.setPrecio(6800);
		return pro;

	}

}
