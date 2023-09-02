package com.project.demo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.Logistica;
import com.project.demo.repository.LogisticaRepository;
import com.project.demo.util.Util;

@Service
public class LogisticaServiceImpl implements ILogisticaService {

	@Autowired
	LogisticaRepository logisticaRepository;

	public final static String TERRESTRE = "Terrestre";
	public final static String MARITIMA = "Maritima";
	public final static int CANT = 10;
	public final static String PLACA = "[a-zA-Z]{3}[0-9]{3}";
	public final static String FLOTA = "[a-zA-Z]{3}[0-9]{4}";

	Logger logger = Logger.getLogger(LogisticaServiceImpl.class.getName());

	@Override
	public List<Logistica> findAll() {
		return (List<Logistica>) logisticaRepository.findAll();
	}

	@Override
	public Logistica findById(long id) {

		return logisticaRepository.findById(id).get();
	}

	@Override
	public void delete(Logistica logistica) {
		logisticaRepository.delete(logistica);

	}

	@Override
	public void save(Logistica logistica) throws Exception {

		if (logistica.getNumeroGuia() == null || logistica.getNumeroGuia().isEmpty()) {
			logistica.setNumeroGuia(Util.generateUuid());
		}

		double desc;

		if (logistica.getTipoLogistica().equalsIgnoreCase(TERRESTRE) && logistica.getCantidadPructo() > CANT) {
			desc = (logistica.getPrecioEnvio() * (5.0 / 100.0));
			logistica.setValorDescuento(desc);
			logistica.setPrecioFinalEnvio(logistica.getPrecioEnvio() - desc);

		} else if (logistica.getTipoLogistica().equalsIgnoreCase(MARITIMA) && logistica.getCantidadPructo() > CANT) {
			desc = (logistica.getPrecioEnvio() * (3.0 / 100.0));
			logistica.setValorDescuento(desc);
			logistica.setPrecioFinalEnvio(logistica.getPrecioEnvio() - desc);
		} else {
			logistica.setValorDescuento(0);
			logistica.setPrecioFinalEnvio(logistica.getPrecioEnvio());
		}

		if (logistica.getTipoLogistica().equalsIgnoreCase(TERRESTRE)
				&& !Util.fieldValidate(logistica.getNumeroFlota(), PLACA)) {

			throw new Exception(
					"El formato (placa o flota) debe corresponder a 3 letras iniciales y 3 números finales");

		}

		if (logistica.getTipoLogistica().equalsIgnoreCase(MARITIMA)
				&& !Util.fieldValidate(logistica.getNumeroFlota(), FLOTA)) {

			throw new Exception(
					"El formato (placa o flota) debe corresponder a 3 letras iniciales y 4 números finales");

		}

		logger.info("Logistica save" + Util.writeValueAsString(logistica));

		logisticaRepository.save(logistica);

	}

	@Override
	public List<Logistica> findByFieldGuia(String value) {
		return (List<Logistica>) logisticaRepository.findByFieldGuia(value);
	}

	@Override
	public List<Logistica> findByFieldCedula(String value) {
		return (List<Logistica>) logisticaRepository.findByFieldCedula(value);
	}

	@Override
	public List<Logistica> findByFieldFlota(String value) {
		return (List<Logistica>) logisticaRepository.findByFieldFlota(value);
	}

}
