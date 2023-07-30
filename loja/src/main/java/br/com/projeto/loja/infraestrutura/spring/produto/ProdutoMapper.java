package br.com.projeto.loja.infraestrutura.spring.produto;

import br.com.projeto.loja.dominio.produto.entidade.Produto;
import br.com.projeto.loja.infraestrutura.spring._shared.BaseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProdutoMapper extends BaseMapper<ProdutoData, Produto> {

    @Override
    public Produto toDomain(ProdutoData produtoData) {
        return new Produto(
                produtoData.getId(),
                produtoData.getValor(),
                produtoData.getDescricao(),
                produtoData.getQuantidade()
        );
    }

    @Override
    public ProdutoData toData(Produto produto) {
        ProdutoData produtoData = new ProdutoData();
        produtoData.setId(produto.getId());
        produtoData.setValor(produto.getValor());
        produtoData.setDescricao(produto.getDescricao());
        produtoData.setQuantidade(produto.getQuantidade());
        return produtoData;
    }

}
