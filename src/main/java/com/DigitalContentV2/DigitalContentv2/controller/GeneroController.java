package com.DigitalContentV2.DigitalContentv2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.DigitalContentV2.DigitalContentv2.facadeImp.Generodao;
import com.DigitalContentV2.DigitalContentv2.modelo.Genero;

@Controller
public class GeneroController {
	
	@Autowired
	private Generodao generoDao;
	
	@GetMapping({"/genero"})
	public String allGenero(Model modelo) {

		List<Genero> lstGenero = this.generoDao.encontrarTodo();
		modelo.addAttribute("listaG", lstGenero);
		return "/Agenero/genero";
		
	}
	
	@PostMapping("/genero")
	public String crearGenero(@ModelAttribute("generoN") Genero genero) {
		generoDao.crear(genero);
		return "redirect:/genero";
	}
	
	@GetMapping("/genero/editar/{idGenero}")
	public String formularioModificarG(@PathVariable("idGenero") Integer idGenero, Model modelo){
		
		Genero genero = generoDao.encontrarId(idGenero);
		modelo.addAttribute("genero",genero);
		return "Agenero/formulario_eg";
	}
	
	@GetMapping("/genero/eliminar/{idGenero}")
	public String eliminarGenero(@PathVariable("idGenero") Integer idGenero, Model modelo){
		generoDao.eliminar(idGenero);	
		return "redirect:/genero";
	}
	
	@GetMapping("/genero/eliminare/{idGenero}")
	private String eliminarGenero(@PathVariable("idGenero") Integer idGenero) {
		
		Genero genero = generoDao.encontrarId(idGenero);
		
		genero.setEstado("Inactivo");
		this.generoDao.actualizarEstado(genero);
		return "redirect:/genero";
	}

}

