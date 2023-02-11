package com.DigitalContentV2.DigitalContentv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DigitalContentV2.DigitalContentv2.modelo.Car_items;
import com.DigitalContentV2.DigitalContentv2.modelo.Producto;
import com.DigitalContentV2.DigitalContentv2.modelo.Usuario;

@Repository
public interface CarRepository extends JpaRepository<Car_items, Integer>{

	public List<Car_items> findByCliente(Usuario usuario);
	
	@Query(
			value = "select * from cart_items where cliente_id = ? and producto_id = ?",
			nativeQuery = true
	)Car_items findByUsuarioAndProducto(Usuario cliente, Producto producto);
	
}
