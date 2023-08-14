package br.com.projeto.agendamento.dominio.servico.aplicacao;

import br.com.projeto.agendamento.dominio.servico.dto.ServicoDTO;
import br.com.projeto.agendamento.dominio.servico.entidade.Servico;
import br.com.projeto.agendamento.dominio.servico.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRegras regras;
    private final ServicoRepository repository;

    public Servico inserir(ServicoDTO dto) {
        Servico produto = dto.toDomain();
        regras.aplicarRegrasBeforeInsert(produto);
        return repository.inserir(produto).get();
    }

    public Servico editar(ServicoDTO dto) {
        Servico produto = dto.toDomain();
        regras.aplicarRegrasBeforeUpdate(produto);
        return repository.editar(produto).get();
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }

    public Servico consultar(Long id) {
        return repository.consultar(id).get();
    }

    public List<ServicoDTO> listar(){
        List<Servico> produtosDominio = repository.listar();
        return ServicoDTO.from(produtosDominio);
    }

}
