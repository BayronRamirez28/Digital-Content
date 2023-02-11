package com.DigitalContentV2.DigitalContentv2.facadeImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DigitalContentV2.DigitalContentv2.modelo.Car_items;
import com.DigitalContentV2.DigitalContentv2.modelo.Producto;
import com.DigitalContentV2.DigitalContentv2.modelo.Usuario;
import com.DigitalContentV2.DigitalContentv2.repository.CarRepository;
import com.DigitalContentV2.DigitalContentv2.repository.ProductoRepository;

@Service
public class Cardao {

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public List<Car_items> listCarItems(Usuario cliente){ 
		return carRepository.findByCliente(cliente);
	}
	
	public Integer addProduct(Integer idProducto, Integer cantidad, Usuario cliente) {
		Integer agregarCantidad = cantidad;
		
		Producto producto = productoRepository.findById(idProducto).get();
		Car_items car_items = carRepository.findByUsuarioAndProducto(cliente, producto);
		
		if (car_items != null) {
			agregarCantidad = car_items.getCantidad() + cantidad;
			car_items.setCantidad(agregarCantidad);
		} else {
			car_items = new Car_items();
			car_items.setCantidad(cantidad);
			car_items.setCliente(cliente);
			car_items.setProduct(producto);
		}
		
		carRepository.save(car_items);
		
		return agregarCantidad;
	}
}
