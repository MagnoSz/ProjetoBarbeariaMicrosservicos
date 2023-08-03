package br.com.projeto.loja.dominio.produto.repository;

import br.com.projeto.loja.dominio._shared.BaseRepository;
import br.com.projeto.loja.dominio.produto.entidade.Produto;

import java.util.Optional;

public interface ProdutoRepository extends BaseRepository<Produto> {
    Optional<String> validarNomeJaUtilizado(Produto produto);
}
