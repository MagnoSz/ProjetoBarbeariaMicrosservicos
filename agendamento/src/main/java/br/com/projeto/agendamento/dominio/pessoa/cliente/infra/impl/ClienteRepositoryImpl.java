package br.com.projeto.agendamento.dominio.pessoa.cliente.infra.impl;

import br.com.projeto.agendamento.dominio.pessoa.cliente.ClienteMapper;
import br.com.projeto.agendamento.dominio.pessoa.cliente.entidade.Cliente;
import br.com.projeto.agendamento.dominio.pessoa.cliente.infra.ClienteDataRepository;
import br.com.projeto.agendamento.dominio.pessoa.cliente.infra.data.ClienteData;
import br.com.projeto.agendamento.dominio.pessoa.cliente.repository.ClienteRepository;
import br.com.projeto.agendamento.dominio.pessoa.funcionario.infra.data.FuncionarioData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class ClienteRepositoryImpl implements ClienteRepository {

    private final ClienteMapper mapper;
    private final ClienteDataRepository repository;

    @Override
    public Optional<Cliente> inserir(Cliente cliente) {
        ClienteData data = mapper.toData(cliente);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public Optional<Cliente> editar(Cliente cliente) {
        return Optional.empty();
    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public Optional<Cliente> consultar(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Cliente> listar() {
        return null;
    }
}
