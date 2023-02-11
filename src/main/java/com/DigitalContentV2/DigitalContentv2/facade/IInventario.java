package com.DigitalContentV2.DigitalContentv2.facade;

import java.util.List;

import com.DigitalContentV2.DigitalContentv2.dto.InventarioDTO;
import com.DigitalContentV2.DigitalContentv2.modelo.Inventario;

public interface IInventario {

	public List<Inventario> encontrarTodo();
	public List<Inventario> listarContado();
	public void crear(Inventario inventario);
	public void actualizar(Inventario inventario);
	public Inventario encontrarId(Integer idInventario);
	public Inventario save(InventarioDTO InventarioDTO);
}
