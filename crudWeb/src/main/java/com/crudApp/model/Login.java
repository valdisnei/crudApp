package com.crudApp.model;



import static com.google.common.base.MoreObjects.toStringHelper;

import static com.google.common.base.Objects.equal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

@Embeddable
public class Login implements Serializable, Comparable<Login> {

    private static final long serialVersionUID = -580646629045825690L;

    @Column(name = "NM_USUARIO", length = 32, nullable = true, updatable = false)
    private String usuario;

    @Column(name = "DC_PASSWORD", length = 512, nullable = true, updatable = false)
    private String password;
    
//    @Column(name = "NM_PERFIL", length = 512, nullable = true, updatable = false)
//    private String perfil;
//    
//    @Column(name = "IN_ATIVO", updatable = true)
//    private boolean ativo;

    public Login() {

    }
    
    public Login(final String usuario, final String password) {
	this();
	this.password = password;
	this.usuario = usuario;
    }

    public String getUsuario() {
	return usuario;
    }

    public void setUsuario(String usuario) {
	this.usuario = usuario;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }
    
//    public String getPerfil() {
//	return perfil;
//    }
//    
//    public void setPerfil(String perfil) {
//	this.perfil = perfil;
//    }
//    
//    public boolean isAtivo() {
//	return ativo;
//    }
//    
//    public void setAtivo(boolean ativo) {
//	this.ativo = ativo;
//    }

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

	Login that = (Login) obj;

	return equal(this.usuario, that.getUsuario())
		&& equal(this.password, that.getPassword());
    }

    @Override
    public String toString() {
	return toStringHelper(this).addValue(this.usuario).toString();
    }

    @Override
    public int hashCode() {
	return Objects.hashCode(this.usuario, this.password);
    }
    
    @Override
    public int compareTo(Login o) {
	// @formatter:off
        return ComparisonChain
        	.start()
        	.compare(this.usuario, o.getUsuario())
        	.compare(this.password, o.getPassword())
        	.result();
        // @formatter:on
    }

}
