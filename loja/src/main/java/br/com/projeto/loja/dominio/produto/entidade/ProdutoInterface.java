package br.com.projeto.loja.dominio.produto.entidade;

import java.math.BigDecimal;

public interface ProdutoInterface {
    Long getId();
    String getDescricao();
    Long getQuantidade();
    BigDecimal getValor();
    void setQuantidade(Long quantidade);
}
