package br.com.infox.dal;

import java.sql.*;

/**
 *
 * @author MDAVEL
 */
public class ModuloConexao {

    // Método responsável por estabelecer a conexão com o banco de dados
    public static Connection conector() {
        java.sql.Connection conexao = null;
        // a linha abaixo chama o driver importado de conexão
        //String driver = "com.mysql.jdbc.Driver";
         String driver = "com.mysql.cj.jdbc.Driver";
        // Armazenando informações referente ao banco de dados
        //String url = "jdbc:mysql://mysqlsenai.mysql.database.azure.com:3306/dbinfox?useTimezone=true&serverTimezone=UTC";
        //String user = "joao@mysqlsenai";
        //String password = "Passw0rd";
        
        String url = "jdbc:mysql://localhost:3306/prinfox";
        //String url = "jdbc:mysql://194.163.44.92:3306/dbenderson";
        String user = "root";
        String password = "";
        
        // Estabelecendo a conexão com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            // a linha abaixo serve de informação ao erro
            System.out.println(e);
            return null;
        }
    }
    
}
