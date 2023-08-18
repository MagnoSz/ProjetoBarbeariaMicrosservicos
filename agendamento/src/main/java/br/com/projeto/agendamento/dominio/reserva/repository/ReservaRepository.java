package br.com.projeto.agendamento.dominio.reserva.repository;

import br.com.projeto.agendamento.dominio._shared.BaseRepository;
import br.com.projeto.agendamento.dominio.reserva.entidade.Reserva;

import java.util.Date;
import java.util.List;

public interface ReservaRepository extends BaseRepository<Reserva> {

    List<Reserva> obterReservasDoFuncionarioPorData(Long idFuncionario, Date dataReserva);

}
