package com.kass.ufps.segundoParcial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kass.ufps.segundoParcial.modelo.Usuario;
import com.kass.ufps.segundoParcial.repository.UsuarioRepository;

@Service
public class UsuarioServiceImple implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void eliminarUsuario(Integer id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public Usuario buscarUsuarioPorId(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario editarUsuario(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
	}
	
	
}
