package com.DigitalContentV2.DigitalContentv2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.DigitalContentV2.DigitalContentv2.modelo.Usuario;

@Controller
public class GeneralController {

	/*@GetMapping("/")
	public String pruebadatos(HttpSession session, Model modelo) {
		Usuario logueado = (Usuario) session.getAttribute("usersession");	
		modelo.addAttribute("nom", logueado);
		return "/layouts/header";
	} */
}
