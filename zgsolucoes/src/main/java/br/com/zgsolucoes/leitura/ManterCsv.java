/**
 * Copyright (c) 2018.
 * Beatriz Nogueira Carvalho da Silveira
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.zgsolucoes.leitura;

import br.com.zgsolucoes.entidades.PromocaoNovo;
import br.com.zgsolucoes.leitura.ListaAlunos;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Classe que recebe como argumento o nome de um arquivo 
 * no formato CSV (colunas separadas por “;”) e produz 
 * um documento XML equivalente.
 */
public class ManterCsv {

    /**
     * Método de interação entre os parametros
     * de  entrada e outros métodos.
     */
    public void main(String[] args) throws IOException, JAXBException {
        String arquivo = "arquivo.csv";
        List<PromocaoNovo> promocoes;
        promocoes = recuperar(arquivo);
        
//        ListaAlunos turma = new ListaAlunos();
//        turma = recuperar(arquivo);
//        arquivo = "arquivo.xml";
//        gerarXml(turma, arquivo);        
    }
    
    public static List<PromocaoNovo> recuperar(String arquivo) throws IOException {
        
        List<PromocaoNovo> promocoes = null;
        char separaAtributo = ';';
        Path arquivoGerado = Paths.get(arquivo);
        Charset utf8 = Charset.forName("UTF-8");
        
        for (String line : Files.readAllLines(arquivoGerado, utf8)) {
            PromocaoNovo promocao = new PromocaoNovo();
            String[] aln = line.split(String.valueOf(separaAtributo));
                       
            String id = aln[line.length()-6];
            String descricao = aln[line.length()-5];
            String observacao = aln[line.length()-4];
            String quantidade_ativacao = aln[line.length()-3];
            String preco_final = aln[line.length()-2];
            String quantidade_paga = aln[line.length()-1];
            
            promocao.setId(Integer.parseInt (id));
            promocao.setDescricao(descricao);
            promocao.setObservacao(observacao);
            BigDecimal valor1 = new BigDecimal(quantidade_ativacao);
            promocao.setQuantidade_ativacao(valor1);        
            BigDecimal valor2 = new BigDecimal(quantidade_ativacao);
            promocao.setPreco_final(valor2);
            BigDecimal valor3 = new BigDecimal(quantidade_ativacao);
            promocao.setQuantidade_paga(valor3);
            
            promocoes.add(promocao);
        }
        return promocoes;
    }

    /**
     * Método transforma os dados de um arquivo xml
     * e os transforma em objetos java.
     *
    public static ListaAlunos recuperar(String arquivo) throws IOException {
        Aluno aluno = new Aluno();
        ListaAlunos listaAlunos = new ListaAlunos();
        char separaAtributo = ';';
        Path arquivoGerado = Paths.get(arquivo);
        Charset utf8 = Charset.forName("UTF-8");
        for (String line : Files.readAllLines(arquivoGerado, utf8)) {
            String[] aln = line.split(String.valueOf(separaAtributo));
            aluno.setNome(aln[line.length()-2]);
            aluno.setEmail(aln[line.length()-1]);
            listaAlunos.setListaAlunos(aluno);
        }
        return listaAlunos;
    }

    /**
     * Método que gerar um arquivo xml à partir dos objetos de entrada.
     * @param turma objeto a se gravado.
     * @param arquivo nome do arquivo.
     * @throws JAXBException lançamento da exeção.
     */
    public static void gerarXml(ListaAlunos turma, String arquivo) throws JAXBException {

        JAXBContext contxt = JAXBContext.newInstance(ListaAlunos.class);
        Marshaller Mll = contxt.createMarshaller();
        Mll.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Mll.marshal(turma, new File(arquivo));
    }
}