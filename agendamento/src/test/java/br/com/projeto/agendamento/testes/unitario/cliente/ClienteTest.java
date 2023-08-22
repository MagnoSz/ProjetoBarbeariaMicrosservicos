package br.com.projeto.agendamento.testes.unitario.cliente;

import br.com.projeto.agendamento.core.config.exceptions.RegraNegocioException;
import br.com.projeto.agendamento.dominio.pessoa.cliente.entidade.Cliente;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class ClienteTest {

    @Test
    public void deveCriarUmCliente() {
        Cliente cliente = new Cliente(1L, "cliente", "73008160107", "0000", new Date(), true);
        Assert.assertEquals("cliente", cliente.getNome());
    }

    @Test
    public void naoDevePermitirCriarUmClienteComCPFInvalido() {
        try {
            Cliente cliente = new Cliente(1L, "cliente", "73008160100", "0000", new Date(), true);
        } catch (RegraNegocioException e){
            Assert.assertEquals("CPF Inválido!", e.getMensagens().get(0).getTexto());
        }
    }

}
