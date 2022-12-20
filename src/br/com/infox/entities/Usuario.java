/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.entities;

import java.io.Serializable;

/**
 *
 * @author mdavel
 */

public class Usuario implements Serializable{
    private int id;
    private String usuario;
    private String fone;
    private String login;
    private String senha;
    private String perfil;

    public Usuario() {
    }

    public Usuario(String usuario, String fone, String login, String senha, String perfil) {
        this.usuario = usuario;
        this.fone = fone;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    
    
}
