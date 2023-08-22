package br.com.projeto.agendamento.testes.unitario.reserva;

import br.com.projeto.agendamento.core.config.exceptions.RegraNegocioException;
import br.com.projeto.agendamento.dominio.pessoa.cliente.entidade.Cliente;
import br.com.projeto.agendamento.dominio.pessoa.funcionario.entidade.Funcionario;
import br.com.projeto.agendamento.dominio.reserva.entidade.Reserva;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class ReservaTest {

    @Test
    public void deveCriarUmaReserva() {
        Reserva reserva = new Reserva(1L, new Cliente(1L), new Funcionario(1L), new ArrayList<>(), new Date(), new Date());
        Assert.assertEquals(Optional.of(1L), Optional.of(reserva.getId()));
    }

    @Test
    public void naoDevePermitirCriarUmaReservaSemCliente() {
        try {
            Reserva reserva = new Reserva(1L, null, new Funcionario(1L), new ArrayList<>(), new Date(), new Date());
        } catch (RegraNegocioException e){
            Assert.assertEquals("É necessário que um cliente esteja associado a reserva", e.getMensagens().get(0).getTexto());
        }
    }

    @Test
    public void naoDevePermitirCriarUmaReservaSemFuncionario() {
        try {
            Reserva reserva = new Reserva(1L, new Cliente(1L), null, null, new Date(), new Date());
        } catch (RegraNegocioException e){
            Assert.assertEquals("É necessário que um funcionário esteja associado a reserva", e.getMensagens().get(0).getTexto());
        }
    }

    @Test
    public void naoDevePermitirCriarUmaReservaSemServico() {
        try {
            Reserva reserva = new Reserva(1L, new Cliente(1L), new Funcionario(1L), null, new Date(), new Date());
        } catch (RegraNegocioException e){
            Assert.assertEquals("É necessário que a reserva tenha ao menos um serviço", e.getMensagens().get(0).getTexto());
        }
    }

}
