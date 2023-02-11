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

import com.DigitalContentV2.DigitalContentv2.facadeImp.Roldao;
import com.DigitalContentV2.DigitalContentv2.facadeImp.Usuariodao;
import com.DigitalContentV2.DigitalContentv2.modelo.Rol;
import com.DigitalContentV2.DigitalContentv2.modelo.Usuario;

@Controller
@RequestMapping("/admin/")
public class UsuarioControllerCrud {

	@Autowired
	private Usuariodao usuarioDao;
	
	@Autowired
	private Roldao rolDao;
	
	@GetMapping("/usuario")
	public String allUsuarios(Model modelo) {
		List<Rol> lstRol = this.rolDao.encontrarTodo();
		List<Usuario> lstUsu = this.usuarioDao.encontrarTodo();
		modelo.addAttribute("listaU", lstUsu);
		modelo.addAttribute("lstRol", lstRol);
		return "Ausuario/usuario";
	}
	
	@PostMapping("/usuario")
	public String recibeRol(@ModelAttribute("usuarioN") Usuario usuario) {
		usuarioDao.crear(usuario);
		return "redirect:/admin/usuario";
	}
	
	@GetMapping("/usuario/asgrol/{idUsuario}")
	public String asignaRol(@PathVariable("idUsuario") Integer idUsuario, Model modelo) {
		List<Rol> lstRol = this.rolDao.encontrarTodo();
		Usuario usuario = usuarioDao.encontrarId(idUsuario);
		modelo.addAttribute("usuario", usuario);
		modelo.addAttribute("lstRol", lstRol);
		return "Ausuario/asignarRoles";
	}
	
}
