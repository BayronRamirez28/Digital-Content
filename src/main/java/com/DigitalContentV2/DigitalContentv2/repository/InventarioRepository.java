package com.DigitalContentV2.DigitalContentv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DigitalContentV2.DigitalContentv2.modelo.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer>{

	@Query(
			value = "SELECT inventario.id_inventario,sum(inventario.stock) as stock,count(inventario.id_compra_fk) as id_Compra_fk, inventario.id_producto_fk ,inventario.id_venta_fk FROM inventario group by inventario.id_producto_fk;",
			nativeQuery = true
	)
	List<Inventario> listarContado();
}
