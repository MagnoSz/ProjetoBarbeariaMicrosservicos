package br.com.projeto.loja.dominio.produto.aplicacao;

import br.com.projeto.loja.dominio._shared.Regras;
import br.com.projeto.loja.dominio.produto.entidade.Produto;
import br.com.projeto.loja.dominio.produto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProdutoRegras implements Regras {

    private final ProdutoRepository produtoRepository;

    public void execute(Produto produto) {
        validarNomeJaUtilizado(produto);
    }

    private void validarNomeJaUtilizado(Produto produto) {
        produtoRepository.validarNomeJaUtilizado(produto);
    }

    @Override
    public void aplicarRegrasBeforeInsert() {

    }

    @Override
    public void aplicarRegrasBeforeUpdate() {

    }
}
