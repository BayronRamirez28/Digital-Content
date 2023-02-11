package com.DigitalContentV2.DigitalContentv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DigitalContentV2.DigitalContentv2.modelo.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {
	
	@Query(
			value = "SELECT * FROM genero WHERE genero.estado = 'Activo'",
			nativeQuery = true
	)
	List<Genero> buscarEstado();
	

	
}
