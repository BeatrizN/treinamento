package br.com.zgsolucoes;

import br.com.zgsolucoes.persistencia.Bootstrap;
import br.com.zgsolucoes.persistencia.ProdutoDAO;

public class PrincipalMain {
    public static void main(String[] args) {
        ProdutoDAO teste = new ProdutoDAO();
//        teste.inserirTeste();
//
//        Bootstrap b = new Bootstrap();
//
//        b.criarTabelaProduto();
//
//        Produto pp = new Produto("AAA", 30, 1);
//        Produto produto = new Produto("BBBB", 10, 1);
//        produto = teste.inserirProduto(pp);

        Teste t = new Teste();
        t = teste.listarTodosTeste().get(1);

        System.out.println(t.getNome() +" - "+ t.getIdade());


//                fredpolicarpo@zgsolucoes.com.br
    }
}
