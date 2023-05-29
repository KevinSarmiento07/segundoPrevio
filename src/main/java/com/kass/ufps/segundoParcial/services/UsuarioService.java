package com.kass.ufps.segundoParcial.services;

import java.util.List;

import com.kass.ufps.segundoParcial.modelo.Usuario;

public interface UsuarioService {
	
	
	public List<Usuario> listarUsuarios();
	
	public Usuario crearUsuario(Usuario usuario);
	
	public void eliminarUsuario(Integer id);
	
	public Usuario buscarUsuarioPorId(Integer id);
	
	public Usuario editarUsuario(Usuario usuario);

}
