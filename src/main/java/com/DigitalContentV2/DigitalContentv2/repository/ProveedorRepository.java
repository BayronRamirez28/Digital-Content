package com.DigitalContentV2.DigitalContentv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.DigitalContentV2.DigitalContentv2.modelo.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
	
	@Query(
			value = "SELECT * FROM proveedor WHERE proveedor.estado = 'Activo'",
			nativeQuery = true
	)
	List<Proveedor> buscarEstado();

}
