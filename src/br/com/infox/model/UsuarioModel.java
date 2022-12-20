/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.model;

import br.com.infox.entities.Usuario;
import br.com.infox.persistense.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mdavel
 */
public class UsuarioModel extends Model {

    private PreparedStatement pst;
    private int adicionado;
    private boolean resp;

    public boolean cadastrar(Usuario u) {

        try {
            String sql = "insert into tbusuarios(iduser,usuario,fone,login,senha,perfil) values(?,?,?,?,?,?)";
            pst = Conexao.conectar().prepareStatement(sql);
            pst.setString(1, String.valueOf(u.getId()));
            pst.setString(2, u.getUsuario());
            pst.setString(3, u.getFone());
            pst.setString(4, u.getLogin());
            pst.setString(5, u.getSenha());
            pst.setString(6, u.getPerfil());
            // validação dos campos obrigatórios

            // a linha abaixo atualiza a tabela de usuário com os dados do formulário
            // a linha abaixo é usada para confirmar a inserção dos dados na tabela
            int adicionado = pst.executeUpdate();
            // a linha abaixo serve de apoio ao entendimento da lógica
            System.out.println(adicionado);
            resp = adicionado > 0;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resp;
    }

}
