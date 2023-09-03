package com.project.demo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.demo.model.Logistica;
import com.project.demo.repository.LogisticaRepository;
import com.project.demo.service.LogisticaServiceImpl;

@SpringBootTest
public class LogisticaServiceTest {

	@InjectMocks
	private LogisticaServiceImpl logisticaServiceImpl;

	@Mock
	private LogisticaRepository logisticaRepository;

	@Test
	void findAll() {

		Iterable<Logistica> list = List.of(objectLogistica());

		when(logisticaRepository.findAll()).thenReturn(list);

		assertNotNull(logisticaServiceImpl.findAll());

	}

	@Test
	void findById() {
		Optional<Logistica> list = Optional.ofNullable(objectLogistica());

		when(logisticaRepository.findById(anyLong())).thenReturn(list);

		assertNotNull(logisticaServiceImpl.findById(0));

	}

	@Test
	void findByGuia() {

		when(logisticaRepository.findByFieldGuia(anyString())).thenReturn(List.of(objectLogistica()));

		assertNotNull(logisticaServiceImpl.findByFieldGuia(""));

	}

	@Test
	void findByFlota() {

		when(logisticaRepository.findByFieldFlota(anyString())).thenReturn(List.of(objectLogistica()));

		assertNotNull(logisticaServiceImpl.findByFieldFlota(""));

	}

	@Test
	void findByCedula() {

		when(logisticaRepository.findByFieldCedula(anyString())).thenReturn(List.of(objectLogistica()));

		assertNotNull(logisticaServiceImpl.findByFieldCedula(""));

	}

	@Test
	public void saveTestOne() throws Exception {
		logisticaServiceImpl.save(objectLogistica());
		assertEquals(objectLogistica().getId(), objectLogistica().getId());
	}

	@Test
	public void saveTestTwo() throws Exception {

		logisticaServiceImpl.save(objectLogisticaTwo());
		assertEquals(objectLogisticaTwo().getId(), objectLogisticaTwo().getId());
	}

	@Test
	public void saveTestThree() throws Exception {

		final Exception e = Assertions.assertThrows(Exception.class, () -> {
			logisticaServiceImpl.save(objectLogisticaThree());
		});
		assertEquals(e.getMessage(), e.getMessage());

	}

	@Test
	public void saveTestFour() throws Exception {

		final Exception e = Assertions.assertThrows(Exception.class, () -> {
			logisticaServiceImpl.save(objectLogisticaFour());
		});
		assertEquals(e.getMessage(), e.getMessage());

	}

	@Test
	public void deleteTest() {
		logisticaServiceImpl.delete(objectLogistica());
		assertEquals(objectLogistica().getId(), objectLogistica().getId());
	}

	public static Logistica objectLogistica() {
		Logistica log = new Logistica();
		log.setCantidadPructo(15);
		log.setTipoLogistica("Terrestre");
		log.setNumeroFlota("aaa111");
		return log;

	}

	public static Logistica objectLogisticaTwo() {
		Logistica log = new Logistica();
		log.setCantidadPructo(15);
		log.setTipoLogistica("Maritima");
		log.setNumeroFlota("bbb4444");
		return log;

	}

	public static Logistica objectLogisticaThree() {
		Logistica log = new Logistica();
		log.setCantidadPructo(5);
		log.setTipoLogistica("Maritima");
		log.setNumeroFlota("841VA");
		log.setNumeroGuia("SDF5486SDF");
		return log;

	}

	public static Logistica objectLogisticaFour() {
		Logistica log = new Logistica();
		log.setCantidadPructo(5);
		log.setTipoLogistica("Terrestre");
		log.setNumeroFlota("");
		log.setNumeroGuia("SDF5486SDF");
		return log;

	}

}
