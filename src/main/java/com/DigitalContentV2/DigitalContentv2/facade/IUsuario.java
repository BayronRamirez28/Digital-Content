package com.DigitalContentV2.DigitalContentv2.facade;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.DigitalContentV2.DigitalContentv2.dto.UsuarioRegistroS;
import com.DigitalContentV2.DigitalContentv2.modelo.Usuario;

public interface IUsuario extends UserDetailsService {

	public List<Usuario> encontrarTodo();
	public Usuario encontrarId(Integer idUsuario);
	public void crear(Usuario usuario);
	public void actualizar(Usuario usuario);
	public void eliminar(Usuario usuario);
	
	public Usuario save(UsuarioRegistroS uregistroS);	
	
}
