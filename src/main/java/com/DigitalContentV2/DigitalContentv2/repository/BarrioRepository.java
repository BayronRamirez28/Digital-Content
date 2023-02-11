package com.DigitalContentV2.DigitalContentv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DigitalContentV2.DigitalContentv2.modelo.Barrio;

@Repository
public interface BarrioRepository extends JpaRepository<Barrio, Integer> {

	@Query(
			value = "SELECT * FROM barrio WHERE barrio.estado = 'Activo'",
			nativeQuery = true
	)
	List<Barrio> buscarEstado();
	
}
