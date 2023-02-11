package com.DigitalContentV2.DigitalContentv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DigitalContentV2.DigitalContentv2.modelo.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	@Query(
			value = "SELECT * FROM categorias WHERE categorias.estado = 'Activo'",
			nativeQuery = true
	)
	List<Categoria> buscarEstado();

}
