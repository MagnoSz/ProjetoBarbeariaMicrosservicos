package br.com.projeto.loja.infraestrutura.spring.produto;

import br.com.projeto.loja.dominio.produto.entidade.Produto;
import br.com.projeto.loja.infraestrutura.spring._shared.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController extends BaseController<ProdutoData, ProdutoDTO, Produto> {

    @Autowired
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        super(produtoService);
        this.produtoService = produtoService;
    }

}
