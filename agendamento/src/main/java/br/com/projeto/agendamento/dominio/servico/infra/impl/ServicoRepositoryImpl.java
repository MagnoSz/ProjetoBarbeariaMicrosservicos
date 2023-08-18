package br.com.projeto.agendamento.dominio.servico.infra.impl;

import br.com.projeto.agendamento.core.config.exceptions.NaoEncontradoException;
import br.com.projeto.agendamento.dominio.servico.ServicoMapper;
import br.com.projeto.agendamento.dominio.servico.entidade.Servico;
import br.com.projeto.agendamento.dominio.servico.infra.ServicoDataRepository;
import br.com.projeto.agendamento.dominio.servico.infra.data.ServicoData;
import br.com.projeto.agendamento.dominio.servico.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class ServicoRepositoryImpl implements ServicoRepository {

    private final ServicoMapper mapper;
    private final ServicoDataRepository repository;

    @Override
    public Optional<Servico> inserir(Servico servico) {
        ServicoData data = mapper.toData(servico);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public Optional<Servico> editar(Servico servico) {
        ServicoData data = mapper.toData(servico);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public void deletar(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public Optional<Servico> consultar(Long id) {
        ServicoData data = repository.findById(id).orElseThrow(NaoEncontradoException::new);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public List<Servico> listar() {
        List<ServicoData> servicosData = repository.findAll();
        List<Servico> servicosDominio = new ArrayList<>();
        servicosData.forEach(servicoData -> servicosDominio.add(mapper.toDomain(servicoData)));
        return servicosDominio;
    }

    @Override
    public Optional<String> validarNomeJaUtilizado(Servico servico) {
        return Optional.empty();
    }
}
