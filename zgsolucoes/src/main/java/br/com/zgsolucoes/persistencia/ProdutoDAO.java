package br.com.zgsolucoes.persistencia;

import br.com.zgsolucoes.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {

    private static final String SQL_INSERE_CONTATO = "INSERT INTO produto(id, "
            + "descricao, valor, promocao) VALUES ( ?, ?, ?, ?);";
    private final String SQL_SELECIONA_CONTATO = "SELECT * FROM teste1";
    private final String SQL_SELECIONA_PRODUTO = "SELECT * FROM produto";
    private static final String SQL_INSERE_TESTE = "INSERT INTO teste1(nome, idade) VALUES ( ?, ?);";

    //private PreparedStatement pst = null;

    public void inserirProduto(Produto produto) {
        try (Connection conn = new CNXJDBC().conectar();
             PreparedStatement pst = conn.prepareStatement(SQL_INSERE_CONTATO);) {
            pst.setInt(1, produto.getId());
            pst.setString(2, produto.getDescricao());
            pst.setBigDecimal(3, produto.getPreco());
            pst.setInt(4, produto.getPromocao());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao executar o Statment " + e.toString());
        }
    }

    public ArrayList<Produto> listarTodosProduto() {
        ArrayList<Produto> p = new ArrayList<Produto>();

        Produto produto;
        try (Connection conn = new CNXJDBC().conectar();
             PreparedStatement pst = conn.prepareStatement(SQL_SELECIONA_PRODUTO);
             ResultSet rs = pst.executeQuery();) {

            while (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getInt("ID"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setPreco(rs.getBigDecimal("VALOR"));
                produto.setPromocao(rs.getInt("PROMOCAO"));
                p.add(produto);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar o Statement" + e.toString());
        }

        return p;
    }
    
    public void inserirTeste() {
        try (Connection conn = new CNXJDBC().conectar();
             PreparedStatement pst = conn.prepareStatement(SQL_INSERE_TESTE);) {
            pst.setString(1, "AA");
            pst.setInt(2, 10);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao executar o Statment " + e.toString());
        }
    }

    public ArrayList<Teste> listarTodosTeste() {
        ArrayList<Teste> p = new ArrayList<Teste>();

        Teste produto;
        try (Connection conn = new CNXJDBC().conectar();
             PreparedStatement pst = conn.prepareStatement(SQL_SELECIONA_CONTATO);
             ResultSet rs = pst.executeQuery();) {

            while (rs.next()) {
                produto = new Teste();
                produto.setNome(rs.getString("NOME"));
                produto.setIdade(Integer.parseInt(rs.getString("IDADE")));
                p.add(produto);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar o Statement" + e.toString());
        }

        return p;
    }
}