package com.DigitalContentV2.DigitalContentv2.facadeImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DigitalContentV2.DigitalContentv2.dto.InventarioDTO;
import com.DigitalContentV2.DigitalContentv2.facade.IInventario;
import com.DigitalContentV2.DigitalContentv2.modelo.Inventario;
import com.DigitalContentV2.DigitalContentv2.repository.InventarioRepository;

@Service
public class Inventariodao implements IInventario{

	@Autowired
	InventarioRepository inventarioRepository;
	
	@Override
	public List<Inventario> encontrarTodo() {
		return this.inventarioRepository.findAll();
	}

	@Override
	public void crear(Inventario inventario) {
		this.inventarioRepository.save(inventario);
	}

	@Override
	public void actualizar(Inventario inventario) {
		this.inventarioRepository.save(inventario);
	}

	@Override
	public Inventario encontrarId(Integer idInventario) {
		return this.inventarioRepository.getReferenceById(idInventario);
	}

	@Override
	public Inventario save(InventarioDTO inventarioDTO) {
		Inventario inventario = new Inventario();
		inventarioDTO.getCalculo();
		return this.inventarioRepository.save(inventario);
	}

	@Override
	public List<Inventario> listarContado() {
		return this.inventarioRepository.listarContado();
	}

}
