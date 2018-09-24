package br.com.zgsolucoes;

import br.com.zgsolucoes.entidades.Produto;
import br.com.zgsolucoes.entidades.PromocaoNovo;
import br.com.zgsolucoes.leitura.ManterCsv;
import br.com.zgsolucoes.leitura.Regex;
import br.com.zgsolucoes.persistencia.CNXJDBC;
import br.com.zgsolucoes.persistencia.ProdutoDAO;
import br.com.zgsolucoes.persistencia.PromocaoDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bootstrap {

    public void inicializa() throws IOException {

        criarTabelaProduto();
        criarTabelaPromocao();

        ProdutoDAO produtoDAO = new ProdutoDAO();
        PromocaoDAO promocaoDAO = new PromocaoDAO();
        Regex regex = new Regex();
        ManterCsv mm = new ManterCsv();

        String[] arquivo = new String[50];
        arquivo = regex.lerArquivo("Arquivo_dados_checkout.txt");

        Produto[] pp = new Produto[50];
        pp = regex.encontrarProduto(arquivo);

        for (int i = 0; i< 50; i++){
            produtoDAO.inserirProduto(pp[i]);
        }

        PromocaoNovo[] promo = new PromocaoNovo[30];
        promo = mm.recuperar("promoções.csv");
        for (int i = 0; i< 50; i++){
            promocaoDAO.inserirPromocao(promo[i]);
        }
    }

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
