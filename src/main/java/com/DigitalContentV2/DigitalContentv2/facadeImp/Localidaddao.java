package com.DigitalContentV2.DigitalContentv2.facadeImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DigitalContentV2.DigitalContentv2.facade.ILocalidad;
import com.DigitalContentV2.DigitalContentv2.modelo.Localidad;
import com.DigitalContentV2.DigitalContentv2.repository.LocalidadRepository;

@Service
public class Localidaddao implements ILocalidad{

	@Autowired
	private LocalidadRepository localidadRepository;
	
	@Override
	public List<Localidad> encontrarTodo() {
		return this.localidadRepository.findAll();
	}

	@Override
	public void crear(Localidad localidad) {
		this.localidadRepository.save(localidad);
		
	}

	@Override
	public void actualizar(Localidad localidad) {
		this.localidadRepository.save(localidad);
		
	}

	@Override
	public Localidad encontrarId(Integer idLocalidad) {
		return this.localidadRepository.getReferenceById(idLocalidad);
	}

	@Override
	public void eliminar(Localidad localidad) {
		this.localidadRepository.delete(localidad);
	}

}
