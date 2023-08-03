package br.com.projeto.loja.dominio.produto.aplicacao;

import br.com.projeto.loja.dominio._shared.BaseService;
import br.com.projeto.loja.dominio.produto.entidade.Produto;
import br.com.projeto.loja.dominio.produto.infra.data.ProdutoData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService extends BaseService<ProdutoData, Produto> {
}
