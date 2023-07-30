package br.com.projeto.loja.infraestrutura.spring.produto;

import br.com.projeto.loja.dominio.produto.entidade.Produto;
import br.com.projeto.loja.infraestrutura.spring._shared.BaseDTO;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO extends BaseDTO<ProdutoDTO, Produto> {

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
