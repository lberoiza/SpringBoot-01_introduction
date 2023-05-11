package com.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String home() {
//    redirect: genera una nueva peticion hacia la direccion escrita
//    puede ser una ruta interna o externa, pero como es una nueva peticion
//    los parametros que se enviaron a esta ruta no se pasan a la redireccion
//    cambia la direccion en la barra de direcciones
//    return "redirect:/index";

//    el forward en cambio no cambia la direccion de la barra de direcciones
//    y no realiza una nueva peticion, es decir pasa los parametros enviados
    return "forward:/index";
  }

}
