package com.DigitalContentV2.DigitalContentv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DigitalContentV2.DigitalContentv2.modelo.Devolucion;

@Repository
public interface DevolucionRepository extends JpaRepository<Devolucion, Integer>{
	
	@Query(
			value = "SELECT * FROM devolucion WHERE devolucion.estado = 'Activo'",
			nativeQuery = true
	)
	List<Devolucion> buscarEstado();
	

}
