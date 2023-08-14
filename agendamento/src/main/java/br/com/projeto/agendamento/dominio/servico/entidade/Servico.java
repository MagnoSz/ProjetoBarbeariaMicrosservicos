package br.com.projeto.agendamento.dominio.servico.entidade;

import br.com.projeto.agendamento.core.config.exceptions.RegraNegocioException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class Servico {

    private Long id;
    private BigDecimal valor;
    private String descricao;
    private Long tempo;

    public Servico(Long id, BigDecimal valor, String descricao, Long tempo) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.tempo = tempo;
        validar();
    }

    private void validar() {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) throw new RegraNegocioException("Valor não deve ser menor ou igual a zero") ;
        if (tempo <= 0) throw new RegraNegocioException("Tempo deve ser maior que zero");
    }

}
