package br.com.yuri.projeto.conexao;

import  java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args){
        Connection conn = Conexao.getConexao();

        if(conn != null){
            System.out.println("Conexão com banco de dados estabelecida com sucesso");
        }else {
            System.out.println("Falha ao estabelecer a conexão");
        }
    }
}
