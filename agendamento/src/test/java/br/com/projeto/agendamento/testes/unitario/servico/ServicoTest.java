package br.com.projeto.agendamento.testes.unitario.servico;

import br.com.projeto.agendamento.core.config.exceptions.RegraNegocioException;
import br.com.projeto.agendamento.dominio.servico.entidade.Servico;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ServicoTest {

    @Test
    public void deveCriarUmServico() {
        Servico servico = new Servico(1L, new BigDecimal("10.00"), "servico", 10L);
        Assert.assertEquals("servico", servico.getDescricao());
    }

    @Test
    public void naoDevePermitirCriarUmServicoComTempoNegativo() {
        try {
            Servico servico = new Servico(1L, new BigDecimal("10.00"), "servico", -10L);
        } catch (RegraNegocioException e){
            Assert.assertEquals("Tempo deve ser maior que zero", e.getMensagens().get(0).getTexto());
        }
    }

    @Test
    public void naoDevePermitirCriarUmServicoComValor() {
        try {
            Servico servico = new Servico(1L, new BigDecimal("-10.00"), "servico", 10L);
        } catch (RegraNegocioException e){
            Assert.assertEquals("Valor não deve ser menor ou igual a zero", e.getMensagens().get(0).getTexto());
        }
    }

}
