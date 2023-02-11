package com.DigitalContentV2.DigitalContentv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DigitalContentV2.DigitalContentv2.modelo.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer>{
	
	@Query(
			value = "SELECT * FROM color WHERE color.estado = 'Activo'",
			nativeQuery = true
	)
	List<Color> buscarEstado();

}
