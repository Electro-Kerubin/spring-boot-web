package com.nerfilin.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		 
		model.addAttribute("titulo", "Enviar parametros de la ruta (@PathVariable)");
		return "variables/index";
	}
	
	@RequestMapping(value = "/string/{texto}", method = RequestMethod.GET)
	public String variables(@PathVariable(name = "texto") String textoTest, Model model) {
		
		model.addAttribute("titulo", "Recibir parametros de la ruta @PathVariable");
		model.addAttribute("resultado", "El texto enviado en la ruta es: " + textoTest);
		return "variables/ver";
	}
	
	@RequestMapping(value = "/string/{texto}/{numero} ", method = RequestMethod.GET)
	public String variables(@PathVariable(name = "texto") String textoTest, @PathVariable Integer numero, Model model) {
		
		model.addAttribute("titulo", "Recibir parametros de la ruta @PathVariable");
		model.addAttribute("resultado", "El texto enviado en la ruta es: " + textoTest 
				+ "y el numero enviado en el path es: " + numero);
		return "variables/ver";
	}
}
