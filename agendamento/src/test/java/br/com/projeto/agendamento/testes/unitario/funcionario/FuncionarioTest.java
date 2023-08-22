package br.com.projeto.agendamento.testes.unitario.funcionario;

import br.com.projeto.agendamento.core.config.exceptions.RegraNegocioException;
import br.com.projeto.agendamento.dominio.pessoa.funcionario.entidade.Funcionario;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class FuncionarioTest {

    @Test
    public void deveCriarUmFuncionario() {
        Funcionario funcionario = new Funcionario(1L, "funcionario", "73008160107", "0000", new Date(), true, "descricao do funcionario");
        Assert.assertEquals("funcionario", funcionario.getNome());
    }

    @Test
    public void naoDevePermitirCriarUmFuncionarioComCPFInvalido() {
        try {
            Funcionario funcionario = new Funcionario(1L, "funcionario", "73008160100", "0000", new Date(), true, "descricao do funcionario");
        } catch (RegraNegocioException e) {
            Assert.assertEquals("CPF Inválido!", e.getMensagens().get(0).getTexto());
        }
    }

    @Test
    public void naoDevePermitirCriarUmFuncionarioSemDescricao() {
        try {
            Funcionario funcionario = new Funcionario(1L, "funcionario", "73008160107", "0000", new Date(), true, null);
        } catch (RegraNegocioException e) {
            Assert.assertEquals("É necessário que o funcionário tenha uma descrição", e.getMensagens().get(0).getTexto());
        }
    }

}
