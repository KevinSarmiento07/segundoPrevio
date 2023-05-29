package com.kass.ufps.segundoParcial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kass.ufps.segundoParcial.modelo.Usuario;
import com.kass.ufps.segundoParcial.services.UsuarioService;

@Controller
@RequestMapping("/")
public class Controlador {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/")
	public String mostrarIndex(Model model) {
		System.out.println("ESTA AQUI");
		List<Usuario> usuarios = usuarioService.listarUsuarios();
		usuarios.sort((u1, u2) -> u1.getNombre().compareTo(u2.getNombre()));
		for(Usuario usuario : usuarios) {
			System.out.println(usuario.getNombre() +  "entro aqui ");
		}
		model.addAttribute("usuarios", usuarios);
		return "index";
	}
	
	@GetMapping("/agregar")
	public String agregarForm(Model model) {
		Usuario usuario = new Usuario();
		System.out.println(usuario.getId() + " IDDDD");
		model.addAttribute("usuario", usuario);
		return "agregar";
	}
	
	@PostMapping("/agregar")
	public String procesarFormAgregar(@ModelAttribute("usuario") Usuario usuario) {
		usuarioService.crearUsuario(usuario);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Integer id, Model model) {
		Usuario usuario = usuarioService.buscarUsuarioPorId(id);
		model.addAttribute("usuario", usuario);
		return "agregar";
	}
	
	
	@PostMapping("/editar/{id}")
	public String editar(Usuario usuario, Model model, @PathVariable("id") Integer id) {
		usuario.setId(id);
		usuarioService.editarUsuario(usuario);
		return "redirect:/";
	}
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Integer id) {
		usuarioService.eliminarUsuario(id);
		return "redirect:/";
	}
}
