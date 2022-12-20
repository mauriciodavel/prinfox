/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.persistense;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author mdavel
 */
public class Conexao {
    
    private static Connection conexao;
    
    public static Connection conectar() {
    
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://18.206.235.64:3306/dbinfox";
        String user = "mdavel";
        String password = "7820mdavel";
         // Estabelecendo a conexão com o banco
        try {
            Class.forName(driver);
        
            if (conexao.equals(null)){
            
            conexao = DriverManager.getConnection(url, user, password);
                       
            }
            
            
            return conexao;
        } catch (Exception e) {
            // a linha abaixo serve de informação ao erro
            System.out.println(e);
            return null;
        }
    
    
}}
