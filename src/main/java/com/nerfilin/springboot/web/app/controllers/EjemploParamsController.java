package com.nerfilin.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		
		
		
		return "params/index";
	}
	
	@RequestMapping(value = "/string", method = RequestMethod.GET)
	public String param(@RequestParam(name = "texto", required = false , defaultValue = "valor por defecto") String texto, Model model) {
		
		model.addAttribute("resultado", "El parametro enviado es: " + texto);
		
		return "params/ver";
	}
	
	@RequestMapping(value = "/mix-params", method = RequestMethod.GET)
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		
		model.addAttribute("resultado", "El parametro enviado es: '" + saludo + "' y el numero es '" + numero + "'");
		
		return "params/ver";
	}
	
	@RequestMapping(value = "mix-params-request", method = RequestMethod.GET)
	public String param(HttpServletRequest request, Model model) {
		
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch(NumberFormatException e) {
			numero = 0;
		}
		
		model.addAttribute("resultado", "El parametro enviado es: '" + saludo + "' y el número es '" + numero + "'");
		return "params/ver";
	}
	
}
