package com.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.web.app.models.Usuario;

@Controller
public class IndexController {

  @Value("${es.IndexController.index.title}")
  private String indexTitle;

  @Value("${es.IndexController.index.headerText}")
  private String indexHeaderText;

  @Value("${es.IndexController.perfil.title}")
  private String perfilTitle;

  @Value("${es.IndexController.listar.title}")
  private String listarTitle;

  // value es opcional, se puede dejar directamente la direccion url
  @GetMapping(value = { "/index", "/home" })
  // Alias => @RequestMapping(value="/index", method = RequestMethod.GET)
  public String index(Model model) {
    // Se pueden usar tambien ModelMap, y ModelAndView para lo mismo (Enviar datos
    // del controlador a la vista)
    model.addAttribute("title", indexTitle);
    model.addAttribute("headerText", indexHeaderText);
    return "index";
  }

  @RequestMapping(value = "/perfil", method = RequestMethod.GET)
  public String perfil(ModelMap modelMap) {
    Usuario user = new Usuario();
    user.setNombre("Luis");
    user.setApellido("Beroiza");
    user.setEdad(39);

    modelMap.addAttribute("usuario", user);
    modelMap.addAttribute("title", String.format(perfilTitle, user.getNombre()));
    return "perfil";
  }

  @RequestMapping(value = "/listar", method = RequestMethod.GET)
  public String listar(ModelMap modelMap) {
    modelMap.addAttribute("title", String.format(listarTitle));
    return "listar";
  }

//  Este metodo con la etiqueta @ModelAttribute,
//  Devuelve a cada vista del controlador este objeto
  @ModelAttribute("usuarios")
  public List<Usuario> poblarUsuarios() {
    List<Usuario> userList = new ArrayList<>();
    userList.add(new Usuario("Luis", "Beroiza", 39, "luis@correo.com"));
    userList.add(new Usuario("John", "Doe", 39, "john@correo.com"));
    userList.add(new Usuario("Jane", "Doe", 39, "jane@correo.com"));
    return userList;
  }

}
