package br.com.yuri.projeto.dao;

import br.com.yuri.projeto.conexao.Conexao;
import br.com.yuri.projeto.modelo.Gafanhoto;
import br.com.yuri.projeto.modelo.Video;
import br.com.yuri.projeto.modelo.Visualizacao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VisualizacaoDAO {

    public boolean inserir(Visualizacao visualizacao) {
        String sql = "INSERT INTO visualizacao (id_g, id_v, avaliacao, data_visualizacao) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao(); 
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, visualizacao.getIdGafanhoto());
            stmt.setInt(2, visualizacao.getIdVideo());
            stmt.setFloat(3, visualizacao.getAvaliacao());
            stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis())); // Insere a data e hora atuais
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<Visualizacao> listarTodos() {
        ArrayList<Visualizacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM visualizacao";

        try (Connection conn = Conexao.getConexao();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            GafanhotoDAO gdao = new GafanhotoDAO();
            VideoDAO vdao = new VideoDAO();

            while (rs.next()) {
                int id = rs.getInt("id");
                int idGafanhoto = rs.getInt("id_g");
                int idVideo = rs.getInt("id_v");
                float avaliacao = rs.getFloat("avaliacao");
                Timestamp timestamp = rs.getTimestamp("data_visualizacao");

                Gafanhoto g = gdao.buscarPorId(idGafanhoto);
                Video v = vdao.buscarPorId(idVideo);

                if (g != null && v != null) {
                    Visualizacao visualizacao = new Visualizacao(g, v, avaliacao, timestamp);
                    visualizacao.setId(id);
                    lista.add(visualizacao);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }


    
     public Video buscarPorTitulo(String titulo) {
        String sql = "SELECT * FROM videos WHERE titulo = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, titulo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Video v = new Video(rs.getString("titulo"));
                v.setCurtidas(rs.getInt("curtidas"));
                v.setViews(rs.getInt("views"));
                v.setAvaliacao(rs.getFloat("mediaAvaliacoes"));
                v.setReproduzindo(rs.getBoolean("reproduzindo"));
                return v;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Visualizacao buscarPorId(int id) {
        String sql = "SELECT * FROM visualizacao WHERE id = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int idGafanhoto = rs.getInt("id_g");
                int idVideo = rs.getInt("id_v");
                float avaliacao = rs.getFloat("avaliacao");
                Timestamp timestamp = rs.getTimestamp("data_visualizacao");

                GafanhotoDAO gdao = new GafanhotoDAO();
                VideoDAO vdao = new VideoDAO();

                Gafanhoto gafanhoto = gdao.buscarPorId(idGafanhoto);
                Video video = vdao.buscarPorId(idVideo);

                Visualizacao v = new Visualizacao(gafanhoto, video, avaliacao, timestamp);
                v.setId(id); // define o id da visualização

                return v;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean atualizar(Visualizacao v, int id) {
        String sql = "UPDATE visualizacao SET id_g = ?, id_v = ?, avaliacao = ? WHERE id = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, v.getIdGafanhoto());
            stmt.setInt(2, v.getIdVideo());
            stmt.setFloat(3, v.getAvaliacao());
            stmt.setInt(4, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM visualizacao WHERE id = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
