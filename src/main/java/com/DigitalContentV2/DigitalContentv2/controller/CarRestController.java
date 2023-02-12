package com.DigitalContentV2.DigitalContentv2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String addProduc2Car(@PathVariable("pid") Integer idProducto, @PathVariable("cant") Integer cant,
			HttpSession session) {

		System.out.println("addProductCart: " + idProducto + " - " + cant);

		Usuario cliente = (Usuario) session.getAttribute("usersession");

		if (cliente == null) {
			return "Necesitas Iniciar Sesion Primero";
		}

		Integer agregarCantidad = cardao.addProduct(idProducto, cant, cliente);
		System.out.println("Agregado :D");
		return agregarCantidad + "item(s) fue agregado a tu carrito.";
	}

	@PostMapping("/carrito/update/{pid}/{cant}")
	public String updateCantidad(@PathVariable("pid") Integer idProducto, @PathVariable("cant") Integer cant,
			HttpSession session) {

		Usuario cliente = (Usuario) session.getAttribute("usersession");

		if (cliente == null) {
			return "Necesitas Iniciar Sesion Primero";
		}

		float subtotal = cardao.actualizarCantidad(idProducto, cant, cliente);
		return String.valueOf(subtotal);
	}
	
	@PostMapping("/carrito/remove/{pid}")
	public String removeProductCart(@PathVariable("pid") Integer idProducto, HttpSession session) {

		Usuario cliente = (Usuario) session.getAttribute("usersession");

		if (cliente == null) {
			return "Necesitas Iniciar Sesion Primero";
		}

		cardao.removeProductCart(idProducto, cliente);
		return "El producto ha sido removido del Carrito";
	}
}
