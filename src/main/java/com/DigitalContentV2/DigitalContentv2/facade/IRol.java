package com.DigitalContentV2.DigitalContentv2.facade;

import java.util.List;


import com.DigitalContentV2.DigitalContentv2.modelo.Rol;

public interface IRol {

	public List<Rol> encontrarTodo();
	public List<Rol> encontrarporEstado();
	public Rol encontrarId(Integer idRol);
	public void crear(Rol rol);
	public void actualizar(Rol rol);
	public void eliminar(Integer idRol);
	public void actualizarEstado(Rol rol);
}
