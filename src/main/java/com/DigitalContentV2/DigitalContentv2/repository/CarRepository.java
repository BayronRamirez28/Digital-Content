package com.DigitalContentV2.DigitalContentv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DigitalContentV2.DigitalContentv2.modelo.Car_items;
import com.DigitalContentV2.DigitalContentv2.modelo.Producto;
import com.DigitalContentV2.DigitalContentv2.modelo.Usuario;

@Repository
public interface CarRepository extends JpaRepository<Car_items, Integer> {

	public List<Car_items> findByCliente(Usuario usuario);

	@Query(value = "select * from cart_items where cliente_id = ? and producto_id = ?", nativeQuery = true)
	Car_items findByUsuarioAndProducto(Usuario cliente, Producto producto);

	@Modifying
	@Query(value = "UPDATE cart_items c SET c.cantidad = ?1 WHERE c.producto_id = ?2 AND  c.cliente_id = ?3", nativeQuery = true)
	public void updateCantidad(Integer cantidad, Integer idProducto, Integer idUsuario);
	
	@Modifying
	@Query(value = "DELETE FROM cart_items WHERE cliente_id = ?1 AND producto_id = ?2", nativeQuery = true)
	public void deleteByClienteAndProducto(Integer idUsuario, Integer idProducto);	

}
