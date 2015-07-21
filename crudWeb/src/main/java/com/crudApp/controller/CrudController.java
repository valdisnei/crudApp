package com.crudApp.controller;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.emptyToNull;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crudApp.model.Customer;
import com.crudApp.model.Login;
import com.crudApp.model.Usuario;
import com.crudApp.repository.UsuarioRepository;


@RestController
public class CrudController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@RequestMapping(value="/customer" , method = RequestMethod.POST)
	public Customer customer(@RequestParam(value="nome",defaultValue="Valdis") String nome, @RequestParam(value="lastName",defaultValue="Fajardo Grilo") String lastName) {
		
		return new Customer(nome,lastName);
		
	}
	
	
	
	@RequestMapping(value="/usuario" , method = RequestMethod.POST)
	public Usuario usuario(@RequestParam(value="usuario",defaultValue="Valdis") String usuario, @RequestParam(value="senha",defaultValue="123123") String senha) {	
		
		return new Usuario(usuario,senha);
		
	}
	
	
	
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public Usuario login(@RequestBody Login userLogin) {	
		
		Usuario usuario = usuarioRepository.findByLogin(userLogin);
		
		checkNotNull(usuario,
				"Usuario não encontrado");		
		
		return usuario;
		
	}
	
	
	@RequestMapping(value="/addUsuario" , method = RequestMethod.POST)
	public Usuario usuario(@RequestBody Usuario usuario) {
		
		validar(usuario);		
		
		usuarioRepository.save(usuario);
		
		return usuario;		
	}



	private void validar(Usuario usuario) {
		checkNotNull(usuario,
				"Eh preciso informar o usuario");
		
		checkNotNull(usuario.getLogin(),
				"Eh preciso informar o login");
		
		checkNotNull(usuario.getLogin().getUsuario(),
				"Eh preciso informar o Usuario");
		
		checkNotNull(usuario.getLogin().getPassword(),
				"Eh preciso informar a senha");
		
		
		checkNotNull(emptyToNull(usuario.getCpf()),
				"Eh preciso informar o CPF");
		
		checkNotNull(emptyToNull(usuario.getNome()),
				"Eh preciso informar o Nome");
		
		
		checkNotNull(emptyToNull(usuario.getLogin().getUsuario()),
				"Eh preciso informar o Usuario");
		
		checkNotNull(emptyToNull(usuario.getLogin().getPassword()),
				"Eh preciso informar a senha");
	}
	
	

}
