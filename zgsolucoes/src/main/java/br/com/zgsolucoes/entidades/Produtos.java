package br.com.zgsolucoes.entidades;

import java.util.ArrayList;
import java.util.List;

public class Produtos {

    private List<Produto> produtos = new ArrayList<Produto>();

    public Produtos() {
    }

    public Produtos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto getProdutos(String produto) {

        for (Produto produto1 : produtos) {
            if (produto1.getDescricao().equals(produto)) {
                return produto1;
            }
        }

        return null;
    }

    public void setProdutos(Produto produto) {
        this.produtos.add(produto);
    }
}
