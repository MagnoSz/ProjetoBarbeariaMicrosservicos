package br.com.projeto.loja.dominio.produto;

import br.com.projeto.loja.dominio._shared.BaseMapper;
import br.com.projeto.loja.dominio.produto.entidade.Produto;
import br.com.projeto.loja.dominio.produto.infra.data.ProdutoData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Produto> toDomain(List<ProdutoData> produtosData) {
        return produtosData.stream().map(this::toDomain).collect(Collectors.toList());
    }

    public ProdutoData toData(Produto produto) {
        ProdutoData produtoData = new ProdutoData();
        produtoData.setId(produto.getId());
        produtoData.setValor(produto.getValor());
        produtoData.setDescricao(produto.getDescricao());
        produtoData.setQuantidade(produto.getQuantidade());
        return produtoData;
    }

    public List<ProdutoData> toData(List<Produto> produtosDominio) {
        return produtosDominio.stream().map(this::toData).collect(Collectors.toList());
    }

}
