package com.DigitalContentV2.DigitalContentv2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DigitalContentV2.DigitalContentv2.facadeImp.Categoriadao;
import com.DigitalContentV2.DigitalContentv2.modelo.Categoria;

@Controller
@RequestMapping("/admin/")
public class CategoriaController {
	
	@Autowired
	private Categoriadao categoriaDao;
	
	@GetMapping("/categoria")
	public String allCategoria(Model modelo) {
		
		List<Categoria> lstCategoria = this.categoriaDao.encontrarporEstado();
		modelo.addAttribute("listaC", lstCategoria);
		return "Administration/Acategoria/categoria";
	}
	
	@GetMapping("/categoria/nuevoC")
	public String formularioCrear(Model modelo) {
		modelo.addAttribute("categoriaN",new Categoria());
		return "Administration/Acategoria/formulario_cc";
	}
	
	@PostMapping("/categoria")
	public String crearCategoria(@ModelAttribute("categoriaN") Categoria categoria) {
		categoriaDao.crear(categoria);
		return "redirect:/admin/categoria";
	}
	
	@GetMapping("/categoria/editar/{idCategoria}")
	public String formularioModificarC(@PathVariable("idCategoria") Integer idCategoria, Model modelo){
		
		Categoria categoria = categoriaDao.encontrarId(idCategoria);
		modelo.addAttribute("categoria",categoria);
	
		return "Administration/Acategoria/formulario_ec";
	}
	
	@GetMapping("/categoria/eliminar/{idCategoria}")
	private String eliminarCategoria(@PathVariable("idCategoria") Integer idCategoria) {
		
		Categoria categoria = categoriaDao.encontrarId(idCategoria);
		
		categoria.setEstado("Inactivo");
		this.categoriaDao.actualizarEstado(categoria);
		return "redirect:/admin/categoria";
	}

}
