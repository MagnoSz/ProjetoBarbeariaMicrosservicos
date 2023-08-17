package br.com.projeto.agendamento.dominio.pessoa.funcionario.infra.impl;

import br.com.projeto.agendamento.core.config.exceptions.NaoEncontradoException;
import br.com.projeto.agendamento.dominio.pessoa.funcionario.FuncionarioMapper;
import br.com.projeto.agendamento.dominio.pessoa.funcionario.entidade.Funcionario;
import br.com.projeto.agendamento.dominio.pessoa.funcionario.infra.FuncionarioDataRepository;
import br.com.projeto.agendamento.dominio.pessoa.funcionario.infra.data.FuncionarioData;
import br.com.projeto.agendamento.dominio.pessoa.funcionario.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class FuncionarioRepositoryImpl implements FuncionarioRepository {

    private final FuncionarioMapper mapper;
    private final FuncionarioDataRepository repository;

    @Override
    public Optional<Funcionario> inserir(Funcionario funcionario) {
        FuncionarioData data = mapper.toData(funcionario);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public Optional<Funcionario> editar(Funcionario funcionario) {
        FuncionarioData data = mapper.toData(funcionario);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public void deletar(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public Optional<Funcionario> consultar(Long id) {
        FuncionarioData data = repository.findById(id).orElseThrow(NaoEncontradoException::new);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public List<Funcionario> listar() {
        List<FuncionarioData> funcionariosData = repository.findAll();
        List<Funcionario> funcionariosDominio = new ArrayList<>();
        funcionariosData.forEach(funcionarioData -> funcionariosDominio.add(mapper.toDomain(funcionarioData)));
        return funcionariosDominio;
    }
}
