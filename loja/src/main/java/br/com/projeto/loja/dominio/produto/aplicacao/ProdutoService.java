package br.com.projeto.loja.dominio.produto.aplicacao;

import br.com.projeto.loja.dominio._shared.BaseService;
import br.com.projeto.loja.dominio.produto.entidade.Produto;
import br.com.projeto.loja.dominio.produto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends BaseService<Produto> {
    public ProdutoService(ProdutoRegras produtoRegras, ProdutoRepository produtoRepository){
        super(produtoRegras, produtoRepository);
    }
}
