package br.com.projeto.agendamento.dominio.reserva.infra;

import br.com.projeto.agendamento.dominio.reserva.infra.data.ReservaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaDataRepository extends JpaRepository<ReservaData, Long> {
}
