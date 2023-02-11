package com.DigitalContentV2.DigitalContentv2.facade;

import java.util.List;

import com.DigitalContentV2.DigitalContentv2.modelo.Color;

public interface IColor {

	public List<Color> encontrarTodo();
	public List<Color> encontrarporEstado();
	public Color encontrarId(Integer idColor);
	public void crear(Color color);
	public void actualizar(Color color);
	public void eliminar(Integer idColor);
	public void actualizarEstado(Color color);
	
	
}
