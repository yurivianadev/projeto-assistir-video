package br.com.yuri.projeto.modelo;
import java.util.ArrayList;

public class Video implements AcoesVideo {
    private int id;
    private String titulo;
    private int curtidas, views, quantAvaliacoes;
    private float avaliacao, mediaAvaliacoes, somaAvaliacoes;
    private boolean reproduzindo;  
    private ArrayList<Gafanhoto> espectadores = new ArrayList<>();    
    @Override
    public String toString() {
        return "Dados do video [avaliacao=" + String.format("%.1f", mediaAvaliacoes) + ", titulo=" + titulo + ", curtidas=" + curtidas + ", views=" + views
                + ", reproduzindo=" + reproduzindo + "]";
        
    }
    public Video(String titulo) {
        this.avaliacao = 1;
        this.titulo = titulo;
        this.curtidas = 0;
        this.views = 0;
        this.reproduzindo = false;
    }
    // Constructor com ID
    public Video(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }
    // Constructor Vazio
    public Video(){
        this.avaliacao = 0;
        this.titulo = null;
        this.curtidas = 0;
        this.views = 0;
        this.reproduzindo = false;
        this.id = 0;
    }
    public Video(int id, String titulo, int curtidas, int views, float mediaAvaliacoes, boolean reproduzindo) {
        this.id = id;
        this.titulo = titulo;
        this.curtidas = curtidas;
        this.views = views;
        this.mediaAvaliacoes = mediaAvaliacoes;
        this.reproduzindo = reproduzindo;
    }



    public float getAvaliacao() {
        return mediaAvaliacoes;
    }
    public void setAvaliacao(float avaliacao) {
        if (avaliacao < 0 || avaliacao > 5){
            avaliacao = 2.5f;
        }
        this.quantAvaliacoes++;
        this.somaAvaliacoes += avaliacao;
        this.mediaAvaliacoes = (float) somaAvaliacoes / quantAvaliacoes;
        
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getCurtidas() {
        return curtidas;
    }
    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }
    public int getViews() {
        return views;
    }
    public void setViews(int views) {
        this.views = views;
    }
    public boolean isReproduzindo() {
        return reproduzindo;
    }
    public void setReproduzindo(boolean reproduzindo) {
        this.reproduzindo = reproduzindo;
    }
     public int getIdVideo() {
        return id;
    }

    public void setIdVideo(int id) {
        this.id = id;
    }
    

    @Override
    public void like(Gafanhoto g) {
        this.setCurtidas(getCurtidas() + 1);
        g.setDeixouLike(true);
    }
    @Override
    public void pause() {
        this.setReproduzindo(false);
        
    }
    @Override
    public void play() {
        this.setReproduzindo(true);
    }
        // Adicione esse método para registrar um novo espectador
        public void adicionarEspectador(Gafanhoto g) {
            this.espectadores.add(g);

        }
    
        // Exibir todos os espectadores
        public void listarEspectadores() {
            System.out.println("Espectadores do vídeo \"" + this.titulo + "\":");
            for (Gafanhoto g : espectadores) {
                System.out.println("- " + g.getNome());
            }
        }

   
}
