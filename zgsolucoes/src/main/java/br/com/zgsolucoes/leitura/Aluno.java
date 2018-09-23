/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zgsolucoes.leitura;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Home
 */
    
@XmlRootElement(name = "aluno")
public class Aluno {

    private String nome;
    private String email;

    /**
     * Método que retor o valor do atributo nome.
     * @return Nome do aluno.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que retor o valor do atributo email.
     * @return Email do aluno.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método que acesssa e atualiza a variável nome.
     * @param nome Nome do aluno.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que acesssa e atualiza a variável email·
     * @param email Email do aluno.
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
