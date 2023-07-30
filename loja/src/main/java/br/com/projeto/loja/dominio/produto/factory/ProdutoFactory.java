package br.com.projeto.loja.dominio.produto.factory;

import br.com.projeto.loja.dominio.produto.entidade.Produto;
import br.com.projeto.loja.dominio.produto.entidade.ProdutoInterface;

import java.math.BigDecimal;

public class ProdutoFactory {

    public static ProdutoInterface criar(Long id, BigDecimal valor, String descricao, Long quantidade) throws Exception {
        return new Produto(id, valor, descricao, quantidade);
    }

}
