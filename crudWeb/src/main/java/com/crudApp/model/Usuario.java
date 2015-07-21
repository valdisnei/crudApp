package com.crudApp.model;



import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Objects.equal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.Objects;


@Entity
@Table(name = "tb_usuario")
public class Usuario implements UsuarioBasico, Serializable,
	Comparable<Usuario> {

    private static final long serialVersionUID = -1223921310687326693L;

    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NM_USUARIO", nullable = true, length = 512,insertable=false,updatable=false)
    private String nome;
    
    @Column(name = "NU_CPF", nullable = true, length = 11, unique = true, updatable = false)
    private String cpf;

    @Embedded
    private Login login;

    public Usuario() {

    }

    public Usuario(String usuario, String senha) {
		this.login=new Login();
		this.login.setUsuario(usuario);
		this.login.setPassword(senha);
	}

	public String getNome() {
	return nome;
    }

    public long getId() {
	return id;
    }
    
    public String getCpf() {
        return cpf;
    }

    public Login getLogin() {
	return login;
    }
    
    public void setId(long id) {
	this.id = id;
    }
    
    public void setNome(String nome) {
	this.nome = nome;
    }
    
    public void setLogin(Login login) {
	this.login = login;
    }
    
    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null) {
	    return false;
	}

	if (obj == this) {
	    return true;
	}

	if (obj.getClass() != getClass()) {
	    return false;
	}

	Usuario that = (Usuario) obj;

	return equal(this.id, that.getId())
		&& equal(this.login, that.getLogin());
    }

    @Override
    public int hashCode() {
	return Objects.hashCode(this.id, this.login);
    }

    @Override
    public String toString() {
	// @formatter:off
        return toStringHelper(this)
        	.addValue(this.id)
        	.addValue(this.login)
        	.toString();
        // @formatter:on
    }

    @Override
    public int compareTo(Usuario o) {
	return this.login.compareTo(o.getLogin());
    }

}
