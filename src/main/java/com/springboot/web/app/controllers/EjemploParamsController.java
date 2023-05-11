package com.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;





@Controller
@RequestMapping("/params")
public class EjemploParamsController {

  @GetMapping("/")
  public String enviarParams(@RequestParam(name = "texto", required = false, defaultValue =  "???") String texto, Model model) {
    return "params/enviar";
  }
  
  @GetMapping("/string")
  public String paramString(@RequestParam(name = "texto", required = false, defaultValue =  "???") String texto, Model model) {
    model.addAttribute("textoIngresado", String.format("El Texto ingresado fue: '%s'", texto));
    return "params/string";
  }


  @GetMapping("/mix-params")
  public String paramString(@RequestParam String texto, @RequestParam Integer number, Model model) {
    model.addAttribute("textoIngresado", String.format("El Texto ingresado fue: '%s' y el numero fué '%d'", texto, number));
    return "params/string";
  }

  //  Forma Antigua de trabajar con Request Params
  @GetMapping("/mix-params-request")
  public String paramString(HttpServletRequest request, Model model) {
    String texto = request.getParameter("texto");
    Integer number = null; 
    try {
      number = Integer.parseInt(request.getParameter("number"));
    }catch(NumberFormatException nex) {
      System.out.println("No se pudo convertir a Integer el valor de number: " + request.getParameter("number"));
      number = 0;
    }catch(Exception ex) {
      System.err.println(ex);
      number = -1;
    }
    
    model.addAttribute("textoIngresado", String.format("Usando HttpServletRequest - El Texto ingresado fue: '%s' y el numero fué '%d'", texto, number));
    return "params/string";
  }

}
