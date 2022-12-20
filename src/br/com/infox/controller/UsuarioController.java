/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.controller;

import br.com.infox.entities.Usuario;
import br.com.infox.model.UsuarioModel;

/**
 *
 * @author mdavel
 */
public class UsuarioController extends Controller{
    
    public void Cadastrar(Usuario u){
        
        UsuarioModel model = new UsuarioModel();
        model.cadastrar(u);
        
    }
    
}
