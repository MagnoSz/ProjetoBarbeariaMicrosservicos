package br.com.projeto.loja.dominio.produto.controller;

import br.com.projeto.loja.dominio._shared.BaseController;
import br.com.projeto.loja.dominio.produto.aplicacao.ProdutoService;
import br.com.projeto.loja.dominio.produto.dto.ProdutoDTO;
import br.com.projeto.loja.dominio.produto.entidade.Produto;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController extends BaseController<Produto> {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service){
        super(service);
        this.service = service;
    }

    @Transactional(readOnly = true)
    @GetMapping("{id}")
    public ProdutoDTO consultar(@PathVariable Long id) throws Exception {
        Produto produto = service.consultar(id);
        return new ProdutoDTO().from(produto);
    }

}
