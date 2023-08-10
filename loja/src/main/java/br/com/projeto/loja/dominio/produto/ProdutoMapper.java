package br.com.projeto.loja.dominio.produto;

import br.com.projeto.loja.dominio._shared.BaseMapper;
import br.com.projeto.loja.dominio.produto.entidade.Produto;
import br.com.projeto.loja.dominio.produto.infra.data.ProdutoData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProdutoMapper implements BaseMapper<ProdutoData, Produto> {

    public Produto toDomain(ProdutoData produtoData) {
        return new Produto(
                produtoData.getId(),
                produtoData.getValor(),
                produtoData.getDescricao(),
                produtoData.getQuantidade()
        );
    }

    public ProdutoData toData(Produto produto) {
        ProdutoData produtoData = new ProdutoData();
        produtoData.setId(produto.getId());
        produtoData.setValor(produto.getValor());
        produtoData.setDescricao(produto.getDescricao());
        produtoData.setQuantidade(produto.getQuantidade());
        return produtoData;
    }



}
