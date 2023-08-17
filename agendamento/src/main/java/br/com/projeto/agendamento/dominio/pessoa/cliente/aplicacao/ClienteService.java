package br.com.projeto.agendamento.dominio.pessoa.cliente.aplicacao;

import br.com.projeto.agendamento.dominio.pessoa.cliente.dto.ClienteDTO;
import br.com.projeto.agendamento.dominio.pessoa.cliente.entidade.Cliente;
import br.com.projeto.agendamento.dominio.pessoa.cliente.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRegras regras;
    private final ClienteRepository repository;

    public Cliente inserir(ClienteDTO dto) {
        Cliente funcionario = dto.toDomain();
        regras.aplicarRegrasBeforeInsert(funcionario);
        return repository.inserir(funcionario).get();
    }

    public Cliente editar(ClienteDTO dto) {
        Cliente cliente = dto.toDomain();
        regras.aplicarRegrasBeforeUpdate(cliente);
        return repository.editar(cliente).get();
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }

    public Cliente consultar(Long id) {
        return repository.consultar(id).get();
    }

    public List<ClienteDTO> listar(){
        List<Cliente> clientesDominio = repository.listar();
        return ClienteDTO.from(clientesDominio);
    }

}
