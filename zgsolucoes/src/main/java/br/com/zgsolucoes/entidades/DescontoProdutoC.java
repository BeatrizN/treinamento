package br.com.zgsolucoes.entidades;

public class DescontoProdutoC implements Promocao {

    public int ativarPromocao(Produto produto, int quantidade) {
        int desconto = quantidade/3;
        //desconto = desconto * produto.getPreco();

        return desconto;
    }

}