package br.com.projeto.loja.dominio.cliente.infra.impl;

import br.com.projeto.loja.core.config.exceptions.NaoEncontradoException;
import br.com.projeto.loja.dominio.cliente.ClienteMapper;
import br.com.projeto.loja.dominio.cliente.entidade.Cliente;
import br.com.projeto.loja.dominio.cliente.infra.ClienteDataRepository;
import br.com.projeto.loja.dominio.cliente.infra.data.ClienteData;
import br.com.projeto.loja.dominio.cliente.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        ClienteData data = mapper.toData(cliente);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public void deletar(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public Optional<Cliente> consultar(Long id) {
        ClienteData data = repository.findById(id).orElseThrow(NaoEncontradoException::new);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public List<Cliente> listar() {
        List<ClienteData> clientesData = repository.findAll();
        List<Cliente> clientesDominio = new ArrayList<>();
        clientesData.forEach(clienteData -> clientesDominio.add(mapper.toDomain(clienteData)));
        return clientesDominio;
    }
}
