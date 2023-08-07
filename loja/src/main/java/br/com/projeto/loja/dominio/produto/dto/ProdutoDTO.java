package br.com.projeto.loja.dominio.produto.dto;

import br.com.projeto.loja.dominio.produto.entidade.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;
    private BigDecimal valor;
    private String descricao;
    private Long quantidade;

    public Produto toDomain() {
        return new Produto(id, valor, descricao, quantidade);
    }

    public ProdutoDTO from(Produto produto) {
        if (produto == null) return null;

        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produtoDTO.getId());
        produtoDTO.setValor(produto.getValor());
        produtoDTO.setDescricao(produto.getDescricao());
        produtoDTO.setQuantidade(produto.getQuantidade());

        return produtoDTO;
    }

}
