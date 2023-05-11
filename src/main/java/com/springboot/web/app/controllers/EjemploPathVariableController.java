package com.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/path_variables")
public class EjemploPathVariableController {

  @GetMapping(value = {"", "/"})
  public String index(Model model) {
    model.addAttribute("title", "Usando Urls dinamicas");
    model.addAttribute("h1", "Probando Urls dinamicas con Spring Boot");
    return "path_variables/index";
  }

  //  La parte variable de la URL debe ir entre {} y el nombre que se puso allí
  //  debe ser el mismo que el que se usa en los argumentos de la funcion
  //  como en este ejemplo el nombre de la variable de argumento es "texto"
  //  se usó dentro de @PathVariable el argumento (name="texto_variable")
  @GetMapping("/user/{texto_variable}")
  public String showUser(@PathVariable(name="texto_variable") Integer userId, Model model) {
    model.addAttribute("textoIngresado", String.format("Pagina del usuario con id: '%d'", userId));
    return "path_variables/show";
  }

  @GetMapping("/user/{user_id}/{action}")
  public String showUser(@PathVariable(name="user_id") Integer userId, @PathVariable String action, Model model) {
    model.addAttribute("textoIngresado", String.format("Pagina del usuario con id: '%d' ejecutando la accion: '%s'", userId, action));
    return "path_variables/show";
  }

}
