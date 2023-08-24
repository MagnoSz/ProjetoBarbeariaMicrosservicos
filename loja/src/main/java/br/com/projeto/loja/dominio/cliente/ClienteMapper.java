package br.com.projeto.loja.dominio.cliente;

import br.com.projeto.loja.dominio.cliente.entidade.Cliente;
import br.com.projeto.loja.dominio.cliente.infra.data.ClienteData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteMapper {

    public Cliente toDomain(ClienteData clienteData) {
        return new Cliente(
                clienteData.getId(),
                clienteData.getNome(),
                clienteData.getCpf(),
                clienteData.getTelefone(),
                clienteData.getDataCadastro(),
                clienteData.getAtivo()
        );
    }

    public ClienteData toData(Cliente cliente) {
        ClienteData clienteData = new ClienteData();
        clienteData.setId(cliente.getId());
        clienteData.setNome(cliente.getNome());
        clienteData.setCpf(cliente.getCpf());
        clienteData.setTelefone(cliente.getTelefone());
        clienteData.setDataCadastro(cliente.getDataCadastro());
        clienteData.setAtivo(cliente.getAtivo());
        return clienteData;
    }

}
