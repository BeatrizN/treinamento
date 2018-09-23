package br.com.zgsolucoes.main;

import br.com.zgsolucoes.entidades.PromocaoNovo;
import br.com.zgsolucoes.leitura.ManterCsv;
import br.com.zgsolucoes.persistencia.PromocaoDAO;

import java.io.IOException;

public class iiii {
    public static void main(String[] args) throws IOException {

        ManterCsv mm = new ManterCsv();
        PromocaoDAO dao = new PromocaoDAO();

        PromocaoNovo[] pp = new PromocaoNovo[30];
         pp = mm.recuperar("promoções.csv");

//        for (int i = 0; i< 50; i++){
//            dao.inserirPromocao(pp[i]);
//        }

        for (int i = 0; i< 3; i++){
            System.out.println("ID  " + pp[i].getId());
            System.out.println("DESCRICAO  " + pp[i].getDescricao());
            System.out.println("OBS  " + pp[i].getObservacao());
            System.out.println("Qativa  " + pp[i].getQuantidade_ativacao());
            System.out.println("PReco  " + pp[i].getPreco_final());
            System.out.println("Qpaga  " + pp[i].getQuantidade_paga());

            System.out.println("\n");
        }
    }
}
