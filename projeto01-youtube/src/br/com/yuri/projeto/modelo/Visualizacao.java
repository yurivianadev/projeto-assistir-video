package br.com.yuri.projeto.modelo;

import java.sql.Timestamp;

public class Visualizacao {
    private int id;
    private int idGafanhoto;
    private int idVideo;
    private float mediaAvaliacoes;
    private Timestamp dataVisualizacao;
    private Gafanhoto g;
    private Video v;
    
    public Visualizacao(Gafanhoto gafanhoto, Video video, float avaliacao, Timestamp dataVisualizacao) {
        this.g = gafanhoto;
        this.v = video;
        this.mediaAvaliacoes = avaliacao;
        this.dataVisualizacao = dataVisualizacao;

        this.idGafanhoto = gafanhoto.getId();
        this.idVideo = video.getIdVideo();
    }

    public Visualizacao(int idGafanhoto, int idVideo, float avaliacao) {
        this.idGafanhoto = idGafanhoto;
        this.idVideo = idVideo;
        this.mediaAvaliacoes = avaliacao;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getIdGafanhoto() {
        return idGafanhoto;
    }
    public void setIdGafanhoto(int idGafanhoto) {
        this.idGafanhoto = idGafanhoto;
    }

    public int getIdVideo() {
        return idVideo;
    }
    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public float getAvaliacao() {
        return mediaAvaliacoes;
    }
    public void setAvaliacao(float avaliacao) {
        this.mediaAvaliacoes = avaliacao;
    }

    public Timestamp getDataVisualizacao() {
        return dataVisualizacao;
    }
    public void setDataVisualizacao(Timestamp dataVisualizacao) {
        this.dataVisualizacao = dataVisualizacao;
    }
}
