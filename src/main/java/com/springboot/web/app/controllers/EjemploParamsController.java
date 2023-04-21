package com.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
