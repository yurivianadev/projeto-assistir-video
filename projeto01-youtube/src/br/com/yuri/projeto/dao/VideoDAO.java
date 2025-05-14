package br.com.yuri.projeto.dao;

import br.com.yuri.projeto.conexao.Conexao;
import br.com.yuri.projeto.modelo.Video;
import java.sql.*;
import java.util.ArrayList;

public class VideoDAO {
    public int inserir(Video v){
        String sql = "INSERT INTO videos(titulo, curtidas, views, mediaAvaliacoes) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, v.getTitulo());
            stmt.setInt(2, v.getCurtidas());
            stmt.setInt(3, v.getViews());
            stmt.setFloat(4, v.getAvaliacao());

            int linhasAfetadas = stmt.executeUpdate();

            if(linhasAfetadas > 0){
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    v.setIdVideo(id);
                    System.out.println("🔎 Verificando se ID " + id + " existe no banco...");
                    
                     System.out.println("🔎 Verificando se ID do Vídeo " + id + " existe no banco...");

                    // Verifique imediatamente após a inserção do vídeo
                    try (PreparedStatement checkVideoStmt = conn.prepareStatement("SELECT COUNT(*) FROM videos WHERE id = ?")) {
                        checkVideoStmt.setInt(1, id);
                        ResultSet checkVideoRs = checkVideoStmt.executeQuery();
                        if (checkVideoRs.next() && checkVideoRs.getInt(1) > 0) {
                        System.out.println("✅ ID do Vídeo " + id + " confirmado no banco!");
                        } else {
                            System.out.println("❌ ID do Vídeo " + id + " NÃO existe no banco!");
                        }
                    }
                    return id;
                }
            }    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Video> listarTodos(){
        ArrayList<Video> lista = new ArrayList<>();
        String sql = "SELECT * FROM videos";
        try(Connection conn = Conexao.getConexao(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Video v = new Video(rs.getString("titulo")); // 
                v.setCurtidas(rs.getInt("curtidas"));
                v.setViews(rs.getInt("views"));
                v.setAvaliacao(rs.getFloat("mediaAvaliacoes"));
                lista.add(v);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    public Video buscarPorId(int id) {
        String sql = "SELECT * FROM videos WHERE id = ?";
        try(Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                Video v = new Video();
                v.setIdVideo(rs.getInt("id"));
                v.setTitulo(rs.getString("titulo"));
                v.setCurtidas(rs.getInt("curtidas"));
                v.setViews(rs.getInt("views"));
                v.setAvaliacao(rs.getFloat("mediaAvaliacoes"));
                return v;
                
            }
         
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean atualizar(Video v, int id) {
        String sql = "UPDATE videos SET titulo = ?, curtidas = ?, views = ?, mediaAvaliacoes = ? WHERE id = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, v.getTitulo());
            stmt.setInt(2, v.getCurtidas());
            stmt.setInt(3, v.getViews());
            stmt.setFloat(4, v.getAvaliacao());
            stmt.setInt(5, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM videos WHERE id = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
