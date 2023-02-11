package com.DigitalContentV2.DigitalContentv2.facadeImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DigitalContentV2.DigitalContentv2.facade.IRol;
import com.DigitalContentV2.DigitalContentv2.modelo.Rol;
import com.DigitalContentV2.DigitalContentv2.repository.RolRepository;

@Service
public class Roldao implements IRol{

	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public List<Rol> encontrarTodo() {
		return this.rolRepository.findAll();
	}

	@Override
	public Rol encontrarId(Integer idRol) {
		return this.rolRepository.getReferenceById(idRol);
	}

	@Override
	public void crear(Rol rol) {
		this.rolRepository.save(rol);
	}

	@Override
	public void actualizar(Rol rol) {
		this.rolRepository.save(rol);
	}

	@Override
	public List<Rol> encontrarporEstado() {
		return this.rolRepository.buscarEstado();
	}

	@Override
	public void eliminar(Integer idRol) {
		rolRepository.deleteById(idRol);
		
	}

	@Override
	public void actualizarEstado(Rol rol) {
		this.rolRepository.save(rol);
	}

}
