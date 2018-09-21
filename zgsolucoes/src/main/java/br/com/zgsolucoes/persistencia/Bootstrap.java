package br.com.zgsolucoes.persistencia;

import br.com.zgsolucoes.CNXJDBC;
import br.com.zgsolucoes.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bootstrap {

    public void criarTabelaProduto() {
        String SQL_CRIAR_Produto = "CREATE TABLE promocao (\n" +
                "  id int(4) AUTO_INCREMENT,\n" +
                "  descricao varchar,\n" +
                "  observação varchar,\n" +
                "  qtde_ativacao int,\n" +
                "  preco_final numeric ,\n" +
                "  qtd_paga numeric\n" +
                "  PRIMARY KEY (id)\n" +
                ");";
        //String SQL_CRIAR_Produto = "CREATE TABLE IF NOT EXISTS 'produto' (id int(4) AUTO_INCREMENT, descricao varchar, valor intersect, promocao int PRIMARY KEY (id));";
        try (Connection conn = new CNXJDBC().conectar();
             PreparedStatement pst = conn.prepareStatement(SQL_CRIAR_Produto);) {
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao executar o Statment " + e.toString());
        }
    }
    /*
    iniciar check
    setup data
    popular data
    ler produtor
    ler promoção */
}
