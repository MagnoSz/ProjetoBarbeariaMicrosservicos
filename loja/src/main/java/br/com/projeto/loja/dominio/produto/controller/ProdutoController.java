package br.com.projeto.loja.dominio.produto.controller;

import br.com.projeto.loja.dominio.produto.aplicacao.ProdutoService;
import br.com.projeto.loja.dominio.produto.dto.ProdutoDTO;
import br.com.projeto.loja.dominio.produto.entidade.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long incluir(@RequestBody ProdutoDTO dto) {
        return service.inserir(dto).getId();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long editar(@RequestBody ProdutoDTO dto) {
        return service.editar(dto).getId();
    }

    @Transactional(readOnly = true)
    @GetMapping("{id}")
    public ProdutoDTO consultar(@PathVariable Long id) {
        Produto produto = service.consultar(id);
        return new ProdutoDTO().from(produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping
    public List<ProdutoDTO> listar() {
        return service.listar();
    }

}
