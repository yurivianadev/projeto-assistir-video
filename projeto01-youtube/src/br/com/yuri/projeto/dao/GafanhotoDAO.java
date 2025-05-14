package br.com.yuri.projeto.dao;

import java.sql.*;
import java.util.ArrayList;
import br.com.yuri.projeto.conexao.Conexao;
import br.com.yuri.projeto.modelo.Gafanhoto;
import java.util.Scanner;


public class GafanhotoDAO {

    public int inserir(Gafanhoto g){
        String sql = "INSERT INTO gafanhotos(nome, sexo, idade, login, totAssistido) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setString(1, g.getNome());
            stmt.setString(2, g.getSexo());
            stmt.setInt(3, g.getIdade());
            stmt.setString(4, g.getLogin());
            stmt.setInt(5, g.getTotAssistido());
            
            int linhasAfetadas = stmt.executeUpdate();
            
            if(linhasAfetadas > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                     int id = rs.getInt(1); // ← armazena o ID
                    System.out.println("🔎 Verificando se ID " + id + " existe no banco..."); // ← imprime antes de retornar
                    
                    //Verificar
                    try (PreparedStatement checkStmt = conn.prepareStatement("SELECT COUNT(*) FROM gafanhotos WHERE id = ?")) {
                        checkStmt.setInt(1, id);
                        ResultSet checkRs = checkStmt.executeQuery();
                        if (checkRs.next() && checkRs.getInt(1) > 0) {
                            System.out.println("✅ ID " + id + " confirmado no banco!");
                        } else {
                            System.out.println("❌ ID " + id + " NÃO existe no banco após inserção!");
                        }
                    }
                    return id;
                }       
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("false");
        }
        return 0;
    }

    public ArrayList<Gafanhoto> listarTodos(){
        ArrayList<Gafanhoto> lista = new ArrayList<>();
        String sql = "SELECT * FROM gafanhotos";
        try(Connection conn = Conexao.getConexao(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Gafanhoto g = new Gafanhoto (rs.getString("nome"), rs.getString("sexo"), rs.getInt("idade"), rs.getString("login"));
                g.setTotAssistido(rs.getInt("totAssistido"));
                g.setId(rs.getInt("id"));

                lista.add(g);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    public Gafanhoto buscarPorId(int id) {
        String sql = "SELECT * FROM gafanhotos WHERE id = ?";
        try(Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Gafanhoto g = new Gafanhoto (rs.getString("nome"), rs.getString("sexo"), rs.getInt("idade"), rs.getString("login"));
                g.setTotAssistido(rs.getInt("totAssistido"));
                g.setId(rs.getInt("id"));

                return g;
            }
        }catch (SQLException e){
            e.printStackTrace();
            
        }
        return null;
    }

    public void atualizar(Gafanhoto g, int id) {
        String sql = "UPDATE gafanhotos SET nome = ?, sexo = ?, idade = ?, login = ?, totAssistido = ? WHERE id = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, g.getNome());
            stmt.setString(2, g.getSexo()); 
            stmt.setInt(3, g.getIdade());
            stmt.setString(4, g.getLogin());
            stmt.setInt(5, g.getTotAssistido());
            stmt.setInt(6, id);
            stmt.executeUpdate();
        }
        catch (SQLException e){
        e.printStackTrace();
    }
    }

    public void deletar(int id){
        String sql = "DELETE FROM gafanhotos WHERE id = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
