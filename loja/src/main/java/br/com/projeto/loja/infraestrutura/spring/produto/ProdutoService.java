package br.com.projeto.loja.infraestrutura.spring.produto;

import br.com.projeto.loja.dominio.produto.entidade.Produto;
import br.com.projeto.loja.infraestrutura.spring._shared.BaseMapper;
import br.com.projeto.loja.infraestrutura.spring._shared.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends BaseService<ProdutoData, Produto> {

    public ProdutoService(JpaRepository<ProdutoData, Long> repository, BaseMapper<ProdutoData, Produto> mapper) {
        super(repository, mapper);
    }
}
