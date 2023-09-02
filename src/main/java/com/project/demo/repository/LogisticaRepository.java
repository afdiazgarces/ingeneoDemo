package com.project.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.demo.model.Logistica;

@Repository
public interface LogisticaRepository extends CrudRepository<Logistica, Long> {
	
	@Query("SELECT u FROM Logistica u WHERE u.numeroGuia = :value")
	public List<Logistica> findByFieldGuia(@Param("value") String value);
	
	@Query("SELECT u FROM Logistica u WHERE u.numeroFlota = :value")
	public List<Logistica> findByFieldFlota(@Param("value") String value);
	
    @Query("SELECT u FROM Logistica u join u.cliente c where c.cedula=:value")
    public List<Logistica> findByFieldCedula(@Param("value") String value);

}
