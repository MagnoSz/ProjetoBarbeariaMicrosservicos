package br.com.projeto.loja.dominio.produto.aplicacao;

import br.com.projeto.loja.dominio.produto.dto.ProdutoDTO;
import br.com.projeto.loja.dominio.produto.entidade.Produto;
import br.com.projeto.loja.dominio.produto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRegras regras;
    private final ProdutoRepository repository;

    public Produto inserir(ProdutoDTO dto) {
        Produto defeito = dto.toDomain();
        regras.execute(defeito);
        return repository.inserir(defeito).get();
    }

    public Produto editar(ProdutoDTO dto) {
        Produto defeito = dto.toDomain();
        regras.execute(defeito);
        return repository.editar(defeito).get();
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }

    /*public Page<Defeito> listarPaginado(ListagemDto<DefeitoDto> listagemDto) {
        Defeito defeito = listagemDto.getFiltros().toEntity();
        return repository.listarPaginado(defeito, listagemDto.getPaginacao().toPageable());
    }*/

    public Produto consultar(Long id) {
        return repository.consultar(id).get();
    }
}
