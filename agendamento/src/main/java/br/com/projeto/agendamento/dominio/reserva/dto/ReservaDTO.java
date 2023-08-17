package br.com.projeto.agendamento.dominio.reserva.dto;

import br.com.projeto.agendamento.dominio.pessoa.cliente.dto.ClienteDTO;
import br.com.projeto.agendamento.dominio.pessoa.funcionario.dto.FuncionarioDTO;
import br.com.projeto.agendamento.dominio.reserva.entidade.Reserva;
import br.com.projeto.agendamento.dominio.servico.dto.ServicoDTO;

import java.util.Date;
import java.util.List;

public class ReservaDTO {

    private Long id;
    private ClienteDTO cliente;
    private FuncionarioDTO funcionario;
    private List<ServicoDTO> servicos;
    private Date dataInicial;
    private Date dataFim;

    /*public Reserva toDomain() {
        return new Reserva(id, cliente.toDomain(), funcionario.toDomain(), ServicoDTO.from(servicos), dataInicial, dataFim);
    }*/

    /*public static ReservaDTO from(Reserva reserva) {
        if (reserva == null) return null;

//        ReservaDTO

    }*/

}
