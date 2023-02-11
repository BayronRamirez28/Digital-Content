package com.DigitalContentV2.DigitalContentv2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.DigitalContentV2.DigitalContentv2.facadeImp.Categoriadao;
import com.DigitalContentV2.DigitalContentv2.facadeImp.Productodao;
import com.DigitalContentV2.DigitalContentv2.facadeImp.Usuariodao;
import com.DigitalContentV2.DigitalContentv2.modelo.Producto;
import com.DigitalContentV2.DigitalContentv2.modelo.Usuario;

@Controller
public class AdminController {

	@Autowired
	Productodao productoDao; 
	
	@Autowired
	Usuariodao usuarioDao; 
	
	@Autowired
	Categoriadao categoriaDao; 
	
	@GetMapping("/admin")
	public String paginaAd() {
		return "Administration/admin";
	}
	
	@GetMapping("/")
	private String catalogo(Model modelo) {
		List<Producto> lstPro = productoDao.encontrarTodo();
		modelo.addAttribute("productos", lstPro);
		List<Usuario> lstUsu = this.usuarioDao.encontrarTodo();
		modelo.addAttribute("usuarios", lstUsu);
		return "index";
	}
	
	/*
	@GetMapping("/")
	public String index() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String home(){
		return "/home";
	}
	*/

}
