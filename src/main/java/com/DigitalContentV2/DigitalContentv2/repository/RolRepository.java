package com.DigitalContentV2.DigitalContentv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DigitalContentV2.DigitalContentv2.modelo.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
	
	@Query(
			value = "SELECT * FROM rol WHERE rol.estado = 'Activo'",
			nativeQuery = true
	)
	List<Rol> buscarEstado();
	
	@Query(
			value = "SELECT * FROM rol WHERE rol.id_rol = 1",
			nativeQuery = true
	)
	List<Rol> EstablecerRol();
	

}
