package br.com.yuri.projeto.modelo;
public abstract class Pessoa {
    protected String nome, sexo;
    protected int idade;
    protected float especialidade;
    
    // Construtor sem parâmetros (para permitir instanciar sem passar valores)
    public Pessoa() {
        this.nome = "";
        this.sexo = "";
        this.idade = 0;
        this.especialidade = 0f;
    }
    
    public Pessoa(String nome, String sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.especialidade = 0f;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(float especialidade) {
        this.especialidade = especialidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    protected void ganharExp(){

    }
}
