package br.com.yuri.projeto.visualizacao;

import br.com.yuri.projeto.modelo.Gafanhoto;
import br.com.yuri.projeto.modelo.Video;

public class InteracaoVisual {
    private Gafanhoto g;
    private Video v;
    public InteracaoVisual(Gafanhoto g, Video v) {
        this.g = g;
        this.v = v;
        this.g.viuMaisUm();
        this.v.setViews(this.v.getViews() + 1);
        this.v.adicionarEspectador(g);
        this.v.like(this.g);
        this.v.play();
    }

    public void avaliar(){
        this.v.setAvaliacao(3);
    }
    public void avaliar(int avaliacao){
        this.v.setAvaliacao(avaliacao);
    }
    public void avaliar(float porc){
        if (porc <= 20){
            this.v.setAvaliacao(1);
        }else if (porc <= 50){
            this.v.setAvaliacao(2);
        }else if (porc <= 75){
            this.v.setAvaliacao(3);
        }else if (porc <= 90){
            this.v.setAvaliacao(4);
        }else{
            this.v.setAvaliacao(5);
        }
    }
    public String toString() {
        return "Visualizacao: [Espectador = " + g.getNome() + 
               ", Video = " + v.getTitulo() + ", DeixouLike=" + this.g.isDeixouLike()+ "]";
    }

    public Gafanhoto getGafanhoto() {
        return g;
    }

    public Video getVideo() {
        return v;
    }

    
}
