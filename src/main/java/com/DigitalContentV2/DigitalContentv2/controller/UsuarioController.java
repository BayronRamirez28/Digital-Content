package com.DigitalContentV2.DigitalContentv2.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DigitalContentV2.DigitalContentv2.dto.UsuarioRegistroS;
import com.DigitalContentV2.DigitalContentv2.facadeImp.Barriodao;
import com.DigitalContentV2.DigitalContentv2.facadeImp.Usuariodao;
import com.DigitalContentV2.DigitalContentv2.modelo.Barrio;
import com.DigitalContentV2.DigitalContentv2.modelo.Usuario;

@Controller
@RequestMapping("/registro")
public class UsuarioController {
	
	@Autowired
	private Usuariodao usuarioDao;
		
	@Autowired
	private Barriodao barrioDao;
	
	@ModelAttribute("usuario")
	private UsuarioRegistroS retornarNuevoUsuario() {
		return new UsuarioRegistroS();
	}
	
	@GetMapping
	public String mostrarFormulario(Model modelo) {
		List<Barrio> lstBar = this.barrioDao.encontrarTodo();
		modelo.addAttribute("barrio", lstBar);
		return "Ausuario/formulario_cu";
	}
	
	@PostMapping
	public String registrarCunteaUsuario(@ModelAttribute("usuario") UsuarioRegistroS registroS) {
		usuarioDao.save(registroS);
		return "redirect:/registro?exito";
	}
	
	@GetMapping("/usuario/editar/{idUsuario}")
	public String usuarioEdit(@PathVariable("idUsuario") Integer idUsuario, Model modelo) {
		Usuario usuario = usuarioDao.encontrarId(idUsuario);
		List<Barrio> lstBar = this.barrioDao.encontrarTodo();
		modelo.addAttribute("barrio", lstBar);
		modelo.addAttribute("usuario", usuario);
		return "Ausuario/asignarRoles";
	}
	
	@GetMapping("/users")
	public String nombreUser(Model modelo, HttpSession session) {
		Usuario logueado = (Usuario) session.getAttribute("usersession");
		List<Barrio> lstBar = this.barrioDao.encontrarTodo();
		modelo.addAttribute("barrio", lstBar);
		modelo.addAttribute("user", logueado);
		return "user";
	}
	
	@GetMapping("/editar/{idUsuario}")
	public String usuarioEditar(@PathVariable("idUsuario") Integer idUsuario, Model modelo) {
		Usuario usuario = usuarioDao.encontrarId(idUsuario);
		modelo.addAttribute("usuario", usuario);
		return "users_edit";
	}
	
	@PostMapping("actualizar")
	private String update(@ModelAttribute("usuarioN") Usuario usuario) {
		usuarioDao.actualizar(usuario);
		
		
		
		return "redirect:/registro/users";
	}
}





