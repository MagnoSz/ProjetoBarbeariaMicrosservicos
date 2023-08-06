package br.com.projeto.loja.dominio.produto.infra.impl;

import br.com.projeto.loja.dominio._shared.BaseRepositoryImpl;
import br.com.projeto.loja.dominio.produto.ProdutoMapper;
import br.com.projeto.loja.dominio.produto.entidade.Produto;
import br.com.projeto.loja.dominio.produto.infra.ProdutoDataRepository;
import br.com.projeto.loja.dominio.produto.infra.data.ProdutoData;
import br.com.projeto.loja.dominio.produto.repository.ProdutoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public class ProdutoRepositoryImpl extends BaseRepositoryImpl<ProdutoData, Produto> implements ProdutoRepository {

    private ProdutoMapper produtoMapper;
    private ProdutoDataRepository produtoDataRepository;

    public ProdutoRepositoryImpl(ProdutoMapper produtoMapper, ProdutoDataRepository produtoDataRepository) {
        super(produtoMapper, produtoDataRepository);
        this.produtoMapper = produtoMapper;
        this.produtoDataRepository = produtoDataRepository;
    }

    @Override
    public Optional<String> validarNomeJaUtilizado(Produto produto) {
        return Optional.empty();
    }

}
