package br.com.projeto.loja.dominio.produto.dto;

import br.com.projeto.loja.dominio._shared.BaseDTO;
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
public class ProdutoDTO implements BaseDTO<ProdutoDTO, Produto> {

    private Long id;
    private BigDecimal valor;
    private String descricao;
    private Long quantidade;

    @Override
    public Produto toDomain() throws Exception {
        Produto produto = new Produto(id, valor, descricao, quantidade);
        produto.validar();
        return produto;
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
