/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zgsolucoes;
    
import java.math.BigDecimal;

public class PromocaoNovo {
    private int id;
    private String descricao;
    private String observacao;
    private BigDecimal quantidade_ativacao;
    private BigDecimal preco_final;
    private BigDecimal quantidade_paga;

    public PromocaoNovo(int id, String descricao, String observacao, 
            BigDecimal quantidade_ativacao, BigDecimal preco_final, 
            BigDecimal quantidade_paga) {
        this.id = id;
        this.descricao = descricao;
        this.observacao = observacao;
        this.quantidade_ativacao = quantidade_ativacao;
        this.preco_final = preco_final;
        this.quantidade_paga = quantidade_paga;
    }

    public PromocaoNovo() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getQuantidade_ativacao() {
        return quantidade_ativacao;
    }

    public void setQuantidade_ativacao(BigDecimal quantidade_ativacao) {
        this.quantidade_ativacao = quantidade_ativacao;
    }

    public BigDecimal getPreco_final() {
        return preco_final;
    }

    public void setPreco_final(BigDecimal preco_final) {
        this.preco_final = preco_final;
    }

    public BigDecimal getQuantidade_paga() {
        return quantidade_paga;
    }

    public void setQuantidade_paga(BigDecimal quantidade_paga) {
        this.quantidade_paga = quantidade_paga;
    }
    
}
