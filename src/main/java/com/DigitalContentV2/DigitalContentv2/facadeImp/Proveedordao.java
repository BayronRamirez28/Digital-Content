package com.DigitalContentV2.DigitalContentv2.facadeImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DigitalContentV2.DigitalContentv2.facade.IProveedor;
import com.DigitalContentV2.DigitalContentv2.modelo.Proveedor;
import com.DigitalContentV2.DigitalContentv2.repository.ProveedorRepository;

@Service

public class Proveedordao implements IProveedor {
	
	@Autowired
	private ProveedorRepository proveedorRepository;

	@Override
	public List<Proveedor> encontrarTodo() {
		return this.proveedorRepository.findAll();
	}

	@Override
	public void crear(Proveedor proveedor) {
		this.proveedorRepository.save(proveedor);
		
	}

	@Override
	public void actualizar(Proveedor proveedor) {
		this.proveedorRepository.save(proveedor);
		
	}

	@Override
	public List<Proveedor> encontrarporEstado() {
		return this.proveedorRepository.buscarEstado();
	}

	@Override
	public Proveedor encontrarId(Integer idProveedor) {
		return this.proveedorRepository.getReferenceById(idProveedor);
	}

	@Override
	public void eliminar(Integer idProveedor) {
		proveedorRepository.deleteById(idProveedor);
		
	}

	@Override
	public void actualizarEstado(Proveedor proveedor) {
		this.proveedorRepository.save(proveedor);
		
	}

}
