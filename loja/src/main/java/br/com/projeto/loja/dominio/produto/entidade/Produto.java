package br.com.projeto.loja.dominio.produto.entidade;

import br.com.projeto.loja.core.config.exceptions.RegraNegocioException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class Produto implements ProdutoInterface {

    private Long id;
    private BigDecimal valor;
    private String descricao;
    private Long quantidade;

    public Produto(Long id, BigDecimal valor, String descricao, Long quantidade) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.quantidade = quantidade;
        validar();
    }

    public void validar() {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) throw new RegraNegocioException("Valor não deve ser menor ou igual a zero") ;
        if (quantidade < 0) throw new RegraNegocioException("Quantidade deve ser maior que zero");
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public Long getQuantidade() {
        return quantidade;
    }

    @Override
    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
