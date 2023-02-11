package com.DigitalContentV2.DigitalContentv2.facadeImp;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DigitalContentV2.DigitalContentv2.facade.IProducto;
import com.DigitalContentV2.DigitalContentv2.modelo.Producto;
import com.DigitalContentV2.DigitalContentv2.repository.ProductoRepository;

@Service
public class Productodao implements IProducto {

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Producto> encontrarTodo() {
		
		return this.productoRepository.findAll();
	}

	@Override
	public Producto encontrarId(Integer idProducto) {
		return this.productoRepository.getReferenceById(idProducto);
	}

	@Override
	public void crear(Producto producto) {
		this.productoRepository.save(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		this.productoRepository.save(producto);
		
	}

	@Override
	public void eliminar(Producto producto) {
		this.productoRepository.save(producto);
	}

	@Override
	public List<Producto> encontrarEstado() {
		return this.productoRepository.buscarEstado();
	}

	@Override
	public String resetCart() {
		return UUID.randomUUID().toString();
	}

	@Override
	public List<Producto> encontrarIdCar(Integer idProducto) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
