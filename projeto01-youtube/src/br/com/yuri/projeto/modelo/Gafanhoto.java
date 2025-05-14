package br.com.yuri.projeto.modelo;
public class Gafanhoto extends Pessoa {
    private int id;
    private String login;
    private int totAssistido;
    public boolean deixouLike;  
    
    public Gafanhoto(int id, String nome, String sexo, int idade, String login) {
        super(nome, sexo, idade);
        this.id = id;
        this.login = login;
        this.totAssistido = 0;
        this.deixouLike = false;
    }
    public Gafanhoto(String nome, String sexo, int idade, String login) {
        this.nome = nome;
        this.login = login;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String toString() {
        return "Dados do espectador [nome=" + getNome() +
               ", sexo=" + getSexo() +
               ", login=" + login +
               ", totAssistido=" + totAssistido +
               ", idade=" + getIdade() +
               ", deixouLike=" + deixouLike + "]";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getTotAssistido() {
        return totAssistido;
    }

    public void setTotAssistido(int totAssistido) {
        this.totAssistido = totAssistido;
    }

    public void viuMaisUm(){
        this.setTotAssistido(getTotAssistido() + 1);   
    }

    public boolean isDeixouLike() {
        return deixouLike;
    }

    public void setDeixouLike(boolean deixouLike) {
        this.deixouLike = deixouLike;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
