package com.DigitalContentV2.DigitalContentv2.facadeImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DigitalContentV2.DigitalContentv2.facade.ITalla;
import com.DigitalContentV2.DigitalContentv2.modelo.Talla;
import com.DigitalContentV2.DigitalContentv2.repository.TallaRepository;

@Service
public class Talladao implements ITalla{

	@Autowired
	private TallaRepository tallaRepository;

	@Override
	public List<Talla> encontrarTodo() {
		return this.tallaRepository.findAll();
	}

	@Override
	public Talla encontrarId(Integer idTalla) {
		return this.tallaRepository.getReferenceById(idTalla);
	}

	@Override
	public void crear(Talla talla) {
		this.tallaRepository.save(talla);
	}

	@Override
	public void actualizar(Talla talla) {
		this.tallaRepository.save(talla);
	}

	@Override
	public List<Talla> encontrarporEstado() {
		return this.tallaRepository.buscarEstado();
	}

	@Override
	public void eliminar(Integer idTalla) {
		tallaRepository.deleteById(idTalla);
		
	}

	@Override
	public void actualizarEstado(Talla talla) {
		this.tallaRepository.save(talla);		
	}
	
	
}
