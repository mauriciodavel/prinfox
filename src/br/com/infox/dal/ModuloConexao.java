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
        String driver = "com.mysql.jdbc.Driver";
        // Armazenando informações referente ao banco de dados
        String url = "jdbc:mysql://localhost:3306/dbinfox";
        String user = "root";
        String password = "root";
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
