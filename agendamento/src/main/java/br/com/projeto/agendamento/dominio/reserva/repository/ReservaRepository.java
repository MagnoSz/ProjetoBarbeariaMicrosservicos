package br.com.projeto.agendamento.dominio.reserva.repository;

import br.com.projeto.agendamento.dominio._shared.BaseRepository;
import br.com.projeto.agendamento.dominio.fidelidade.dto.FidelidadeDTO;
import br.com.projeto.agendamento.dominio.reserva.entidade.Reserva;
import br.com.projeto.agendamento.dominio.servico.entidade.Servico;

import java.util.Date;
import java.util.List;

public interface ReservaRepository extends BaseRepository<Reserva> {
    List<Reserva> obterReservasDoFuncionarioPorData(Long idFuncionario, Date dataReserva);
    List<String> getHorariosReservadosDasReservas(List<Reserva> reservas);
    List<String> getHorariosFiltrados(List<String> horariosReservados, List<Servico> servicos, Date dataPesquisada);
    FidelidadeDTO obterCountFidelidadeCliente(Long id);
    List<Reserva> listarFiltrado(Long funcionarioId, Date dataReserva);
}
