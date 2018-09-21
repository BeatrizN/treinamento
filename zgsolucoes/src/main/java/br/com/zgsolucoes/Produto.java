package br.com.zgsolucoes;

import java.math.BigDecimal;

public class Produto {
    private int id;
    private String descricao;
    private BigDecimal preco;
    private int promocao;

    public Produto(int id, String descricao, BigDecimal preco, int promocao) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.promocao = promocao;
    }

    public Produto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getPromocao() {
        return promocao;
    }

    public void setPromocao(int promocao) {
        this.promocao = promocao;
    }

}
