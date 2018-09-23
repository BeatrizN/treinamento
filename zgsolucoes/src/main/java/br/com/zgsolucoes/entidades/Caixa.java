package br.com.zgsolucoes.entidades;

import java.util.*;

public class Caixa {

    List<Item> itens = new ArrayList<Item>();
    Produtos produtos = new Produtos();

    public void adicionarProdutoCarrinho(String produto) {

        boolean existe = false;
        for (int i = 0; i < itens.size(); i++) {

            if (itens.get(i).getProduto().equals(produto)) {
                itens.get(i).setQuantidade(itens.get(i).getQuantidade() + 1);
                existe = true;
            }
        }
        if (!existe) {
            Produto produtoCadastrado = produtos.getProdutos(produto);
            if (produtoCadastrado != null) {
                Item itemAdicionar = new Item(produtoCadastrado, 1);
                itens.add(itemAdicionar);
            }
        }
    }

    public void removerProdutoCarrinho(String produto) {

        for (int i = 0; i < itens.size(); i++) {

            if (itens.get(i).getProduto().equals(produto)) {
                itens.get(i).setQuantidade(itens.get(i).getQuantidade() - 1);

            }
        }
    }

    public int getTotalPrice() {
        int valorTotal = 0;

        for(Item item : itens) {
           // valorTotal += item.getQuantidade() * item.getProduto().getPreco(); ****
        }

        valorTotal = valorTotal - getTotalDiscount();

        return valorTotal;
    }

    public int getTotalDiscount() {

        int desconto = 0;

        for (Item item : itens) {
            //desconto += item.getProduto().getPromocao().ativarPromocao(item.getProduto(), item.getQuantidade());
        }

        return desconto;
    }

}
