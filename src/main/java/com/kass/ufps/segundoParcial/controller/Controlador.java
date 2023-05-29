package com.kass.ufps.segundoParcial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kass.ufps.segundoParcial.modelo.Continente;
import com.kass.ufps.segundoParcial.modelo.Seleccion;
import com.kass.ufps.segundoParcial.repository.ContinenteRepository;
import com.kass.ufps.segundoParcial.repository.SeleccionRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/controlador")
public class Controlador {

	
	@Autowired
	private SeleccionRepository seleccionRepository;
	
	@Autowired
    private ContinenteRepository continenteRepository;
	
	
	
	@GetMapping("/selecciones")
	public String listarSelecciones(Model model) {
		System.out.println("Entro en /selecciones");
		List<Seleccion> selecciones = seleccionRepository.findAll();
		
		
		model.addAttribute("selecciones", selecciones);
		return "listarSelecciones";
	}
	
	
	@GetMapping("/agregar")
	public String agregarSeleccion(Seleccion seleccion, Model model) {
		
		List<Continente> continentes = continenteRepository.findAll();
		model.addAttribute("continentes", continentes);
		return "seleccionAgregar";
	}
	
		
	@PostMapping("/selecciones")
	public String procesarFormulario(@Valid Seleccion seleccion, BindingResult result, Model model) {
		System.out.println("entro en prcoesar");
		Seleccion nuevaSeleccion = seleccionRepository.save(seleccion);
		System.out.println(nuevaSeleccion.getNombre() + " "  + nuevaSeleccion.getContinente().getNombre());
		model.addAttribute("seleccion", nuevaSeleccion);
		return "redirect:/controlador/selecciones";
	}
	
	
	@GetMapping("/selecciones/editar/{id}")
	public String editar(Seleccion seleccion, Model model) {
		Seleccion seleccionEditada = seleccionRepository.findById(seleccion.getId()).orElse(null);
		List<Continente> continentes = continenteRepository.findAll();
		model.addAttribute("seleccion", seleccionEditada);
		model.addAttribute("continentes", continentes);
		return "seleccionEditar";
	}
	
	@PostMapping("/editar/{id}")
	public String editar(@PathVariable("id") Integer id, Seleccion seleccion) {
		System.out.println("entro en editar post");
		seleccion.setId(id);
		seleccionRepository.save(seleccion);
		return "redirect:/controlador/selecciones";
	}
	
	@GetMapping("/selecciones/eliminar/{id}")
	public String eliminar(@PathVariable("id") Integer id) {
		
		seleccionRepository.deleteById(id);
		return "redirect:/controlador/selecciones";
	}
	
	
	
	
	
	
}
