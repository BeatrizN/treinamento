/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zgsolucoes.leitura;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Classe de objetos Lista de Alunos.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaAlunos {

    @XmlElementWrapper(name = "alunos")
    @XmlElement(name = "aluno")
    private List<Aluno> alunos;

    /**
     * Método responsável por dar acesso ao ArrayList alunos.
     * @return ArrayList de alunos.
     */
    public List<Aluno> getListaAlunos() {
        return alunos;
    }

    /**
     * Método de acesso ao ArrayList alunos.
     */
    public void setListaAlunos(Aluno aluno) {
        this.alunos.add(aluno);
    }

}