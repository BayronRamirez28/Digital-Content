package com.DigitalContentV2.DigitalContentv2.facade;

import java.util.List;


import com.DigitalContentV2.DigitalContentv2.modelo.Categoria;

public interface ICategoria {

	public List<Categoria> encontrarTodo();
	public List<Categoria> encontrarporEstado();
	public Categoria encontrarId(Integer idCategoria);
	public void crear(Categoria categoria);
	public void actualizar(Categoria categoria);
	public void eliminar(Integer idCategoria);
	public void actualizarEstado(Categoria categoria);
}
