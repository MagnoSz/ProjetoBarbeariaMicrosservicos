package br.com.projeto.loja.dominio.cliente.aplicacao;

import br.com.projeto.loja.dominio._shared.Regras;
import br.com.projeto.loja.dominio.cliente.entidade.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteRegras implements Regras<Cliente> {
    @Override
    public void aplicarRegrasBeforeInsert(Cliente cliente) {

    }

    @Override
    public void aplicarRegrasBeforeUpdate(Cliente cliente) {

    }
}
