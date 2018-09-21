package br.com.zgsolucoes;

public class Teste {
    private String nome;
    private int idade;

    public Teste(String produto, int idade) {
        this.nome = produto;
        this.idade = idade;
    }

    public Teste() {
        this.nome = "";
        this.idade = 1;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String produto) {
        this.nome = produto;
    }

    public void setIdade(int preco) {
        this.idade = preco;
    }
}
