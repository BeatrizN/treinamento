/**
 * Copyright (c) 2018.
 * Beatriz Nogueira Carvalho da Silveira
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.zgsolucoes.leitura;

import br.com.zgsolucoes.entidades.PromocaoNovo;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;


public class ManterCsv {

    public static PromocaoNovo[] recuperar(String strFile) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(strFile));
        PromocaoNovo[] promocoes = new PromocaoNovo[3];
        String[] nextLine;
        int lineNumber = 0;

        while ((nextLine = reader.readNext()) != null) {
            if (lineNumber != 0) {
                PromocaoNovo promocao = new PromocaoNovo();
                String id = nextLine[0];
                String descricao = nextLine[1];
                String observacao = nextLine[2];
                String quantidade_ativacao = nextLine[3];
                String preco_final = nextLine[4];
                String quantidade_paga = nextLine[5];

                promocao.setId(Integer.parseInt(id));
                promocao.setDescricao(descricao);
                promocao.setObservacao(observacao);
                promocao.setQuantidade_ativacao(iniciaBigDecimal(quantidade_ativacao));
                promocao.setPreco_final(iniciaBigDecimal(preco_final));
                promocao.setQuantidade_paga(iniciaBigDecimal(quantidade_paga));

                promocoes[lineNumber-1] = promocao;
            }

            lineNumber++;
        }
        return promocoes;
    }

    public static BigDecimal iniciaBigDecimal(String numero) {
         BigDecimal bigDecimal;
         if(numero == null || numero.trim().equals("")) {
             bigDecimal = new BigDecimal(0);
         } else {
             bigDecimal = new BigDecimal(numero);
         }
         return bigDecimal;
    }

}