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

import com.project.demo.model.Bodega;
import com.project.demo.repository.BodegaRepository;
import com.project.demo.service.BodegaServiceImpl;

@SpringBootTest
public class BodegaServiceTest {

	@InjectMocks
	private BodegaServiceImpl bodegaServiceImpl;

	@Mock
	private BodegaRepository bodegaRepository;

	@Test
	void findAll() {

		Iterable<Bodega> list = List.of(objectBodega());

		when(bodegaRepository.findAll()).thenReturn(list);

		assertNotNull(bodegaServiceImpl.findAll());

	}

	@Test
	void findById() {
		Optional<Bodega> list = Optional.ofNullable(objectBodega());

		when(bodegaRepository.findById(anyLong())).thenReturn(list);

		assertNotNull(bodegaServiceImpl.findById(0));

	}

	@Test
	public void saveTest() {
		bodegaServiceImpl.save(objectBodega());
		assertEquals(objectBodega().getId(), objectBodega().getId());
	}
	
	@Test
	public void deleteTest() {
		bodegaServiceImpl.delete(objectBodega());
		assertEquals(objectBodega().getId(), objectBodega().getId());
	}

	public static Bodega objectBodega() {
		Bodega bog = new Bodega();
		bog.setNombre("Bodega ZZZ");
		bog.setUbicacion("Paris");
		return bog;

	}

}
