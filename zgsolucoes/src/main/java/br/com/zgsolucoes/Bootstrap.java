package br.com.zgsolucoes;

import br.com.zgsolucoes.persistencia.CNXJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bootstrap {

    public void criarTabelaProduto() {
        String SQL_CRIAR_Produto = "CREATE TABLE IF NOT EXISTS produto (id integer, descricao varchar(30), valor numeric, promocao numeric, PRIMARY KEY (id));";
        try (Connection conn = new CNXJDBC().conectar();
             PreparedStatement pst = conn.prepareStatement(SQL_CRIAR_Produto);) {
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao executar o Statment " + e.toString());
        }
    }

    public void criarTabelaPromocao() {
        String SQL_CRIAR_Promocao = "CREATE TABLE IF NOT EXISTS promocao (id integer, descricao varchar(80),\n" +
                "observacao varchar(80), quantidade_ativacao numeric, \n" +
                "preco_final numeric, quantidade_paga numeric, PRIMARY KEY (id))";
        try (Connection conn = new CNXJDBC().conectar();
             PreparedStatement pst = conn.prepareStatement(SQL_CRIAR_Promocao);) {
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao executar o Statment " + e.toString());
        }
    }

}
