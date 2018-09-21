/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zgsolucoes.persistencia;

import br.com.zgsolucoes.Produto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public String regex(String regex, String texto) {
        StringBuilder retorno = new StringBuilder();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        while (matcher.find()) {
            String regexEncontrada = matcher.group();

            retorno.append(regexEncontrada);
        }

        return retorno.toString();
    }

    public String[] lerArquivo(String nome) throws IOException {

        FileReader arq = new FileReader(nome);
        BufferedReader lerArq = new BufferedReader(arq);
        StringBuilder todasLinhas = new StringBuilder();

        String[] linhas = new String[50];
        int contador = 0;
        for(int i = 0; i<50;i++) {
            //while(lerArq.readLine() != null) {
            String linha = lerArq.readLine();
            linhas[contador] = linha;
            contador = contador + 1;
        }

        arq.close();
        return linhas;
    }

    public Produto[] encontrarProduto(String[] linhas) throws IOException {

        String regraID = "(?<=id: )\\d+(<=|)";
        String regraDescricao = "(?<=descricao: )\\w+(<=|)";
        String regraPreco = "(?<=valor: )\\d*.?\\d*(<=|)";
        String regraPromocao = "(?<=promocao: ).?\\d+(<=|)";

        Produto[] produtos = new Produto[50];

        for(int i = 0; i<linhas.length; i++) {

            Produto produto = new Produto();

            String id = regex(regraID, linhas[i]);
            String descricao = regex(regraDescricao, linhas[i]);
            String preco = regex(regraPreco, linhas[i]);
            String promocao = regex(regraPromocao, linhas[i]);

            produto.setId(Integer.parseInt (id));
            produto.setDescricao(descricao);

            BigDecimal valor = new BigDecimal(preco);
            produto.setPreco(valor);
            produto.setPromocao(Integer.parseInt(promocao));

            produtos[i] = produto;
        }

        return produtos;
    }
}
