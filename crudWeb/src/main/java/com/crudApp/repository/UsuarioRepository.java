package com.crudApp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.crudApp.model.Login;
import com.crudApp.model.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    List<Usuario> findByNome(String nome);

    Usuario findByLogin(Login login);

}
