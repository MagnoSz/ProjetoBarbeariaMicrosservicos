package br.com.projeto.agendamento.dominio.reserva;

import br.com.projeto.agendamento.dominio._shared.BaseMapper;
import br.com.projeto.agendamento.dominio.pessoa.cliente.ClienteMapper;
import br.com.projeto.agendamento.dominio.pessoa.funcionario.FuncionarioMapper;
import br.com.projeto.agendamento.dominio.reserva.entidade.Reserva;
import br.com.projeto.agendamento.dominio.reserva.infra.data.ReservaData;
import br.com.projeto.agendamento.dominio.servico.ServicoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservaMapper implements BaseMapper<ReservaData, Reserva> {

    private final ClienteMapper clienteMapper;
    private final FuncionarioMapper funcionarioMapper;
    private final ServicoMapper servicoMapper;

    @Override
    public Reserva toDomain(ReservaData reservaData) {
        return Reserva.builder()
                .id(reservaData.getId())
                .cliente(this.clienteMapper.toDomain(reservaData.getCliente()))
                .funcionario(this.funcionarioMapper.toDomain(reservaData.getFuncionario()))
                .servicos(this.servicoMapper.toDomain(reservaData.getServicos()))
                .dataInicial(reservaData.getDataInicial())
                .dataFim(reservaData.getDataFim())
                .build();
    }

    @Override
    public ReservaData toData(Reserva reserva) {
        if (reserva == null) return null;
        return ReservaData.builder()
                .id(reserva.getId())
                .cliente(this.clienteMapper.toData(reserva.getCliente()))
                .funcionario(this.funcionarioMapper.toData(reserva.getFuncionario()))
                .servicos(this.servicoMapper.toData(reserva.getServicos()))
                .dataInicial(reserva.getDataInicial())
                .dataFim(reserva.getDataFim())
                .build();
    }
}
