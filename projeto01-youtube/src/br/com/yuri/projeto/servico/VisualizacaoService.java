package br.com.yuri.projeto.servico;

import br.com.yuri.projeto.dao.GafanhotoDAO;
import br.com.yuri.projeto.dao.VideoDAO;
import br.com.yuri.projeto.dao.VisualizacaoDAO;
import br.com.yuri.projeto.modelo.Gafanhoto;
import br.com.yuri.projeto.modelo.Video;
import br.com.yuri.projeto.modelo.Visualizacao;
import java.sql.Timestamp;

public class VisualizacaoService {
    public static boolean registrarVisualizacaoComAtualizacao(Gafanhoto gafanhoto, Video video, float avaliacao, boolean deixouLike) {
        try {
            // 1. Cria timestamp da visualização
            Timestamp dataVisualizacao = new Timestamp(System.currentTimeMillis());

            // 2. Cria visualização
            Visualizacao vis = new Visualizacao(gafanhoto, video, avaliacao, dataVisualizacao);
            System.out.println("Criando visualização com ID do Gafanhoto: " + gafanhoto.getId() + ", ID do Vídeo: " + video.getIdVideo());

            // 3. Insere a visualização no banco
            VisualizacaoDAO vdao = new VisualizacaoDAO();
            boolean sucessoInsercao = vdao.inserir(vis);
            if (!sucessoInsercao){
                System.out.println("Erro ao inserir");
                return false;
            }
            // 4. Atualiza estatísticas do vídeo
               

            int viewsAnteriores = video.getViews();
            System.out.printf("   ➤ Avaliação recebida: %.2f\n", avaliacao);
            System.out.printf("   ➤ Avaliação anterior do vídeo: %.2f\n", video.getAvaliacao());
            System.out.printf("   ➤ Views anteriores: %d\n", viewsAnteriores);
            
            video.setAvaliacao(avaliacao);
            video.setViews(viewsAnteriores + 1);
            
          

            if (deixouLike) {
                video.setCurtidas(video.getCurtidas() + 1); // incrementa curtidas
            }
            
            // 🔎 DEBUG: imprimir antes da atualização
            System.out.printf("   ➤ Título: %s\n", video.getTitulo());
            System.out.printf("   ➤ Curtidas: %d\n", video.getCurtidas());
            System.out.printf("   ➤ Views: %d\n", video.getViews());
            System.out.printf("   ➤ Nova média de avaliações: %.2f\n", video.getAvaliacao());

            VideoDAO videoDAO = new VideoDAO();
            videoDAO.atualizar(video, video.getIdVideo()); // passando o objeto e seu ID
            

        
            // 5. Atualiza estatísticas do gafanhoto
            gafanhoto.setTotAssistido(gafanhoto.getTotAssistido() + 1); // incrementa o total assistido

            GafanhotoDAO gdao = new GafanhotoDAO();
            gdao.atualizar(gafanhoto, gafanhoto.getId()); // passando o objeto e seu ID

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
