package br.com.zgsolucoes;

public interface Promocao {

    String descricao = "";
    String observacao = "";
    int quantidade_ativacao = 0;
    double preco_final = 0;
    double quantidade_paga = 0;

    public int ativarPromocao (Produto produto, int quantidade);
}
