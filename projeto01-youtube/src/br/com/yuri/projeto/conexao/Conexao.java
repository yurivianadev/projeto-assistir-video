package br.com.yuri.projeto.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/projeto_assistirvideo";
    private static final String USUARIO = "root";
    private static final String SENHA = "91313826";

    private static Connection conn;
    
    public static Connection getConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

