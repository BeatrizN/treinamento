/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zgsolucoes.persistencia;

import br.com.zgsolucoes.entidades.PromocaoNovo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PromocaoDAO {
    private static final String SQL_INSERE_PROMOCAO = "INSERT INTO promocao "
            + "(id, descricao, observacao, quantidade_ativacao, preco_final, "
            + "quantidade_paga) VALUES ( ?, ?, ?, ?, ?, ?);";
    private final String SQL_SELECIONA_PROMOCAO = "SELECT * FROM promocao";

    public void inserirPromocao(PromocaoNovo pro) {
        try (Connection conn = new CNXJDBC().conectar();
            PreparedStatement pst = conn.prepareStatement(SQL_INSERE_PROMOCAO);) {
            pst.setInt(1, pro.getId());
            pst.setString(2, pro.getDescricao());
            pst.setString(3, pro.getObservacao());
            pst.setBigDecimal(4, pro.getQuantidade_ativacao());
            pst.setBigDecimal(5, pro.getPreco_final());
            pst.setBigDecimal(6, pro.getQuantidade_paga());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao executar o Statment " + e.toString());
        }
    }
    
    public ArrayList<PromocaoNovo> listarTodosPromocao() {
        ArrayList<PromocaoNovo> p = new ArrayList<PromocaoNovo>();

        PromocaoNovo promocao;
        try (Connection conn = new CNXJDBC().conectar();
             PreparedStatement pst = conn.prepareStatement(SQL_SELECIONA_PROMOCAO);
             ResultSet rs = pst.executeQuery();) {

            while (rs.next()) {
                promocao = new PromocaoNovo();
                promocao.setId(rs.getInt("ID"));
                promocao.setDescricao(rs.getString("DESCRICAO"));
                promocao.setObservacao(rs.getString("OBSERVACAO"));
                promocao.setQuantidade_ativacao(rs.getBigDecimal("QUANTIDADE_ATIVACAO"));
                promocao.setPreco_final(rs.getBigDecimal("PRECO_FINAL"));
                promocao.setQuantidade_paga(rs.getBigDecimal("QUANTIDADE_PAGA"));
                p.add(promocao);
            }

        } catch (Exception e) {
            System.out.println("Erro ao executar o Statement" + e.toString());
        }

        return p;
    }
}
