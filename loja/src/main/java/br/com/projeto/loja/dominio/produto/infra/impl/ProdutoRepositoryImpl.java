package br.com.projeto.loja.dominio.produto.infra.impl;

import br.com.projeto.loja.dominio._shared.BaseMapper;
import br.com.projeto.loja.dominio._shared.BaseRepositoryImpl;
import br.com.projeto.loja.dominio.produto.entidade.Produto;
import br.com.projeto.loja.dominio.produto.infra.data.ProdutoData;
import br.com.projeto.loja.dominio.produto.repository.ProdutoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public class ProdutoRepositoryImpl extends BaseRepositoryImpl<ProdutoData, Produto> implements ProdutoRepository {

    public ProdutoRepositoryImpl(BaseMapper<ProdutoData, Produto> mapper, JpaRepository<ProdutoData, Long> repository) {
        super(mapper, repository);
    }

    @Override
    public Optional<String> validarNomeJaUtilizado(Produto produto) {
        return Optional.empty();
    }

}
