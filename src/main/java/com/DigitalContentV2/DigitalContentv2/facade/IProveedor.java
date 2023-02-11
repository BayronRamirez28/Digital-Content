package com.DigitalContentV2.DigitalContentv2.facade;

import java.util.List;

import com.DigitalContentV2.DigitalContentv2.modelo.Proveedor;

public interface IProveedor {

	public List<Proveedor> encontrarTodo();
	public List<Proveedor> encontrarporEstado();
	public Proveedor encontrarId(Integer idProveedor);
	public void crear(Proveedor proveedor);
	public void actualizar(Proveedor proveedor);
	public void eliminar(Integer idProveedor);
	public void actualizarEstado(Proveedor proveedor);
}
