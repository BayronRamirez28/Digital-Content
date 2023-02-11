package com.DigitalContentV2.DigitalContentv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DigitalContentV2.DigitalContentv2.modelo.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	@Query(
			value = "SELECT * FROM producto WHERE producto.estado = 'Activo'",
			nativeQuery = true
	)
	List<Producto> buscarEstado();
}
