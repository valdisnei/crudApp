package com.crudApp.model;



import java.io.Serializable;

public interface UsuarioBasico extends Serializable {

    long getId();

    String getNome();

    String getCpf();
}
