package com.DigitalContentV2.DigitalContentv2.facade;

import java.util.List;

import com.DigitalContentV2.DigitalContentv2.modelo.Producto;

public interface IProducto {

	public List<Producto> encontrarTodo();
	public Producto encontrarId(Integer idProducto);
	public void crear(Producto producto);
	public void actualizar(Producto producto);
	public void eliminar(Producto producto);
	public List<Producto> encontrarEstado();
	public String resetCart();
	public List<Producto> encontrarIdCar(Integer idProducto);
}
