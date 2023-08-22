package br.com.projeto.agendamento.dominio.horarios.dto;

import br.com.projeto.agendamento.dominio.pessoa.funcionario.entidade.Funcionario;
import br.com.projeto.agendamento.dominio.servico.entidade.Servico;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PesquisaHorariosDTO {
    private List<Servico> servicos;
    private Funcionario profissional;
    private Date data;
}
