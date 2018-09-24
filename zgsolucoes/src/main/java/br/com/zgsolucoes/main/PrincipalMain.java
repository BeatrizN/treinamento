package br.com.zgsolucoes.main;

import br.com.zgsolucoes.Bootstrap;
import br.com.zgsolucoes.entidades.PromocaoNovo;
import br.com.zgsolucoes.leitura.ManterCsv;
import br.com.zgsolucoes.persistencia.ProdutoDAO;
import br.com.zgsolucoes.persistencia.PromocaoDAO;
import br.com.zgsolucoes.leitura.Regex;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;

public class PrincipalMain {
    public static void main(String[] args) throws IOException {

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.inicializa();
    }
}
