package br.com.zgsolucoes.entidades;

import br.com.zgsolucoes.persistencia.PromocaoDAO;

import java.util.ArrayList;
import java.util.List;

public class Promocoes {
    private List<PromocaoNovo> promocoes = new ArrayList<PromocaoNovo>();

    PromocaoDAO dao = new PromocaoDAO();

    public Promocoes() {
        this.promocoes = dao.listarTodosPromocao();
    }

    public Promocoes(List<PromocaoNovo> promocoes) {
        this.promocoes = promocoes;
    }

    public PromocaoNovo getPromocoes(String promocao) {

        for (PromocaoNovo promo : promocoes) {
            if (promo.getDescricao().equals(promocao)) {
                return promo;
            }
        }

        return null;
    }

    public void setPromocoes(PromocaoNovo promocao) {
        this.promocoes.add(promocao);
    }
}