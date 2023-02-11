package com.DigitalContentV2.DigitalContentv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DigitalContentV2.DigitalContentv2.modelo.Talla;

@Repository
public interface TallaRepository extends JpaRepository<Talla, Integer> {
	
	@Query(
			value = "SELECT * FROM talla WHERE talla.estado = 'Activo'",
			nativeQuery = true
	)
	List<Talla> buscarEstado();
	

}
