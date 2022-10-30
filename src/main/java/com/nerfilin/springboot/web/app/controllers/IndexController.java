package com.nerfilin.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nerfilin.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexController.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexController.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexController.listar.titulo}")
	private String textoListar;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model, Map<String, Object> map) {

		model.addAttribute("tituloModel", textoIndex);

		map.put("tituloMap", "Hola Mundo Spring Boot con Map");

		// Retorna una plantilla html llamada index
		return "index";
	}

	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public String perfil(Model model) {

		Usuario usuario = new Usuario();
		usuario.setNombre("Aquiles");
		usuario.setApellido("Baeza");
		usuario.setEmail("aqui.baeza@duocuc.cl");

		model.addAttribute("tituloModel", textoPerfil.concat(usuario.getNombre()));
		model.addAttribute("usuario", usuario);

		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {

		model.addAttribute("tituloModel", textoListar);

		return "listar";
	}
	
	//MA : MODEL ATTRIBUTE
	@ModelAttribute("usuariosMA")
	public List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Aquiles", "Baeza", "correo1@duocuc.cl"));
		usuarios.add(new Usuario("Constantina", "Suarez", "correo2@duocuc.cl"));
		usuarios.add(new Usuario("Camila", "Andrades", "correo3@duocuc.cl"));

		return usuarios;
	}
}
