package com.DigitalContentV2.DigitalContentv2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroController {

	@GetMapping("/login")
	public String iniciarSesion() {
		return "Ausuario/login";
	}
	
	@GetMapping
	public String pagInicio() {
		return "index";
	}
	
	@GetMapping("/logout")
	public String cerrarSesion() {
		return "redirect:login?logout";
	}
	
	@GetMapping("/ups")
	public String ups() {
		return "errores/ups";
	}
}
