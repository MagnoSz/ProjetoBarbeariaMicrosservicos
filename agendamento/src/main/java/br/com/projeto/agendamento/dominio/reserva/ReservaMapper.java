package br.com.projeto.agendamento.dominio.reserva;

import br.com.projeto.agendamento.dominio._shared.BaseMapper;
import br.com.projeto.agendamento.dominio.pessoa.cliente.ClienteMapper;
import br.com.projeto.agendamento.dominio.pessoa.funcionario.FuncionarioMapper;
import br.com.projeto.agendamento.dominio.reserva.entidade.Reserva;
import br.com.projeto.agendamento.dominio.reserva.infra.data.ReservaData;
import br.com.projeto.agendamento.dominio.servico.ServicoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Reserva> toDomain(List<ReservaData> reservasData) {
        return reservasData.stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public ReservaData toData(Reserva reserva) {
        if (reserva == null) return null;

        ReservaData reservaData = new ReservaData();
        reservaData.setId(reserva.getId());
        reservaData.setCliente(this.clienteMapper.toData(reserva.getCliente()));
        reservaData.setFuncionario(this.funcionarioMapper.toData(reserva.getFuncionario()));
        reservaData.setServicos(this.servicoMapper.toData(reserva.getServicos()));
        reservaData.setDataInicial(reserva.getDataInicial());
        reservaData.setDataFim(reserva.getDataFim());

        return reservaData;
    }

    public List<ReservaData> toData(List<Reserva> reservasDominio) {
        return reservasDominio.stream().map(this::toData).collect(Collectors.toList());
    }

}
