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
        Servico servico = dto.toDomain();
        regras.aplicarRegrasBeforeInsert(servico);
        return repository.inserir(servico).get();
    }

    public Servico editar(ServicoDTO dto) {
        Servico servico = dto.toDomain();
        regras.aplicarRegrasBeforeUpdate(servico);
        return repository.editar(servico).get();
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }

    public Servico consultar(Long id) {
        return repository.consultar(id).get();
    }

    public List<ServicoDTO> listar(){
        List<Servico> servicosDominio = repository.listar();
        return ServicoDTO.from(servicosDominio);
    }

}
