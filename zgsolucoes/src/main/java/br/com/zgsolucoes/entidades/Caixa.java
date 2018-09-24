package br.com.zgsolucoes.entidades;

import java.math.BigDecimal;
import java.util.*;

public class Caixa {

    List<Item> itens = new ArrayList<Item>();
    Produtos produtos = new Produtos();
    Promocoes promocoes = new Promocoes();

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

    public BigDecimal getTotalPrice() {
        BigDecimal valorTotal = new BigDecimal(0);

        for(Item item : itens) {
            BigDecimal quantidade = new BigDecimal(item.getQuantidade());
            BigDecimal temporario = quantidade.multiply(item.getProduto().getPreco());
            valorTotal = valorTotal.add(temporario);
        }

        return valorTotal;
    }

    public BigDecimal getTotalDiscount() {

        BigDecimal desconto = new BigDecimal(0);

        for (Item item : itens) {
            PromocaoNovo promocao = promocoes.getPromocoes(Integer.toString(item.getProduto().getPromocao()));
            BigDecimal temporario = ativarPromocao(item.getProduto(), item.getQuantidade(), promocao, desconto);
            desconto = desconto.add(temporario);
        }

        return desconto;
    }

    public BigDecimal ativarPromocao(Produto produto, int quantidade, PromocaoNovo promocao, BigDecimal desconto) {
        int qAtiva = Integer.valueOf(promocao.getQuantidade_ativacao().toString());
        int q = quantidade/qAtiva;
        BigDecimal quanti = new BigDecimal(q);

        if(promocao.getQuantidade_paga() != new BigDecimal(0)){
            BigDecimal temporario = quanti.multiply(produto.getPreco());
            desconto = desconto.add(temporario);
        } else {
            BigDecimal total = quanti.multiply(produto.getPreco());
            desconto = total.subtract(promocao.getPreco_final());
        }

        return desconto;
    }

}
