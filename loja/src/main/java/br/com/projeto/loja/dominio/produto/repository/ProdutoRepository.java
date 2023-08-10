package br.com.projeto.loja.dominio.produto.repository;

import br.com.projeto.loja.dominio.produto.entidade.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {
    Optional<Produto> inserir(Produto produto);
    Optional<Produto> editar(Produto produto);
    void deletar(Long id);
    Optional<Produto> consultar(Long id);
    List<Produto> listar();
    Optional<String> validarNomeJaUtilizado(Produto produto);
}
