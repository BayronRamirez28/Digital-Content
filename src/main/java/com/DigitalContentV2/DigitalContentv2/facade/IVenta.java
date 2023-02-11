package com.DigitalContentV2.DigitalContentv2.facade;

import java.util.List;

import com.DigitalContentV2.DigitalContentv2.modelo.Venta;

public interface IVenta {

	public List<Venta> encontrarTodo();
	public void crear(Venta venta);
	public void actualizar(Venta venta);
	public void eliminar(Venta venta);
}
