package br.com.zgsolucoes.entidades;

public class DescontoProdutoB implements Promocao {

    public int ativarPromocao(Produto produto, int quantidade) {
        int desconto = quantidade/2;
        desconto *= 15;

        return desconto;
    }

}