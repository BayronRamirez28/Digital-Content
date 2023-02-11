package com.DigitalContentV2.DigitalContentv2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DigitalContentV2.DigitalContentv2.facadeImp.Cardao;
import com.DigitalContentV2.DigitalContentv2.modelo.Usuario;

@RestController
public class CarRestController {

	@Autowired
	private Cardao cardao;
 	
	@PostMapping("/carrito/add/{pid}/{cant}")
	public String addProduc2Car(@PathVariable("pid") Integer idProducto,
			@PathVariable("cant") Integer cant,
			@AuthenticationPrincipal Authentication authentication, HttpSession session) {
		
		if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "Necesitas Iniciar Sesion Primero";
		}
		Usuario cliente = (Usuario) session.getAttribute("usersession"); 
		Integer agregarCantidad = cardao.addProduct(idProducto, cant, cliente);
		return agregarCantidad + "item(s) fue agregado a tu carrito.";
	}
}
