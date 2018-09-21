/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zgsolucoes.persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

    public String lerArquivo(String nome) throws IOException {

        FileReader arq = new FileReader(nome);
        BufferedReader lerArq = new BufferedReader(arq);
        StringBuilder todasLinhas = new StringBuilder();
        while(lerArq.readLine() != null) {
            String linha = lerArq.readLine();
            todasLinhas.append(linha);
        }

        arq.close();

        return todasLinhas.toString();
    }    
}
