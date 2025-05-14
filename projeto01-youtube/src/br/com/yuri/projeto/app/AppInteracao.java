package br.com.yuri.projeto.app;

import br.com.yuri.projeto.modelo.Gafanhoto;
import br.com.yuri.projeto.modelo.Video;
import br.com.yuri.projeto.dao.GafanhotoDAO;
import br.com.yuri.projeto.dao.VideoDAO;
import br.com.yuri.projeto.servico.*;

public class AppInteracao {
    public static void main(String[] args) {
        // 1. Criar Gafanhoto
        Gafanhoto novoGafanhoto = new Gafanhoto(0, "Mario", "M", 25, "Mario25");
        GafanhotoDAO gdao = new GafanhotoDAO();
        int idGafanhoto = gdao.inserir(novoGafanhoto); // insere no banco e pega o ID
        novoGafanhoto.setId(idGafanhoto); // atualiza o objeto

        // 2. Criar Vídeo
        /* Video novoVideo = new Video(0, "Curso PHP Básico", 0, 0, 0.0f, false);
        VideoDAO vdao = new VideoDAO();
        int idVideo = vdao.inserir(novoVideo); // insere no banco e pega o ID
        novoVideo.setIdVideo(idVideo); // atualiza o objeto */
        
        System.out.println("ID do Gafanhoto: " + novoGafanhoto.getId());
        
        VideoDAO vdao = new VideoDAO();
        Video videoExistente = vdao.buscarPorId(20); 

        // 3. Registrar Visualização
        boolean sucesso = VisualizacaoService.registrarVisualizacaoComAtualizacao(
                novoGafanhoto,
                videoExistente,
                2.5f, // nota da avaliação
                true // deixou like
        );
        
        //3.8
        System.out.println("ID do Gafanhoto: " + idGafanhoto);
       // System.out.println("ID do Vídeo: " + idVideo);

        //3.9
        if (idGafanhoto < 0) {
            System.out.println("Falha ao inserir Gafanhoto.");
            return;
        }

       /*  if (idVideo < 0) {
            System.out.println("Falha ao inserir Vídeo.");
            return;
        }
 */
        // 4. Exibir resultado
        if (sucesso) {
            System.out.println("Interação registrada com sucesso!");
        } else {
            System.out.println("Falha ao registrar a interação.");
        } 
    
    }
}
