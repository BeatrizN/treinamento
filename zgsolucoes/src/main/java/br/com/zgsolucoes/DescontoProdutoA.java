package br.com.zgsolucoes;

public class DescontoProdutoA implements Promocao {

    public int ativarPromocao(Produto produto, int quantidade) {
        int desconto = quantidade/3;
        desconto *= 20;

        return desconto;
    }

}
