package com.springboot.web.app.models;

public class Usuario {
  private String Nombre;
  private String Apellido;
  private Integer Edad;
  private String Email;

  public Usuario() {
  }

  public Usuario(String nombre, String apellido, Integer edad, String email) {
    Nombre = nombre;
    Apellido = apellido;
    Edad = edad;
    Email = email;
  }

  public String getNombre() {
    return Nombre;
  }

  public void setNombre(String nombre) {
    Nombre = nombre;
  }

  public String getApellido() {
    return Apellido;
  }

  public void setApellido(String apellido) {
    Apellido = apellido;
  }

  public Integer getEdad() {
    return Edad;
  }

  public void setEdad(Integer edad) {
    Edad = edad;
  }

  public String getEmail() {
    return Email;
  }

  public void setEmail(String email) {
    Email = email;
  }
}
