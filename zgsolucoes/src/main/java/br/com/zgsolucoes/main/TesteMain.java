/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zgsolucoes.main;

import br.com.zgsolucoes.Bootstrap;
import br.com.zgsolucoes.entidades.Produto;
import br.com.zgsolucoes.entidades.PromocaoNovo;
import br.com.zgsolucoes.leitura.Regex;
import br.com.zgsolucoes.persistencia.ProdutoDAO;
import br.com.zgsolucoes.persistencia.PromocaoDAO;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class TesteMain {
     public static void main(String[] args) throws IOException {

        ProdutoDAO teste = new ProdutoDAO();
        PromocaoDAO promo = new PromocaoDAO();
        Bootstrap b = new Bootstrap();

        Regex regex = new Regex();

        //b.criarTabelaProduto();

        String[] arquivo = new String[50];
        arquivo = regex.lerArquivo("Arquivo_dados_checkout.txt");


        Produto[] pp = new Produto[50];
        pp = regex.encontrarProduto(arquivo);

//        for (int i = 0; i< 50; i++){
//            teste.inserirProduto(pp[i]);
//        }

        for (int i = 0; i< 50; i++){
            System.out.println("ID" + pp[i].getId());
            System.out.println("DESCRICAO" + pp[i].getDescricao());
            System.out.println("PRECO" + pp[i].getPreco());
            System.out.println("PROMOCAO" + pp[i].getPromocao());
            System.out.println("\n");
        }

        //ArrayList<Produto> ppp = teste.listarTodosProduto();

//        for (int i = 0; i<50; i++){
//            System.out.println(ppp.get(i).getId());
//            System.out.println(ppp.get(i).getDescricao());
//            System.out.println(ppp.get(i).getPreco());
//            System.out.println(ppp.get(i).getPromocao());
//            System.out.println("\n");
//        }


        //Produto pp = new Produto(9, "AAA", new BigDecimal(3.9860), 1);
        //teste.inserirProduto(pp);
//        Produto aaa = new Produto();
//        aaa = teste.listarTodosProduto().get(1);
//        System.out.println(aaa.getId() +" - "+ aaa.getDescricao()+" - "+ aaa.getPreco()+" - "+ aaa.getPromocao());

        //b.criarTabelaPromocao();
//        PromocaoNovo promocao = new PromocaoNovo(2, "ABB", "CCCC", new BigDecimal(1), new BigDecimal(1),new BigDecimal(1));
//        promo.inserirPromocao(promocao);
//        PromocaoNovo aba = promo.listarTodosPromocao().get(1);
//        System.out.println(aba.getId() +" - "+ aba.getDescricao());

    }
}
