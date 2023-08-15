package br.com.projeto.agendamento.dominio.servico.infra;

import br.com.projeto.agendamento.dominio.servico.infra.data.ServicoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoDataRepository extends JpaRepository<ServicoData, Long> {
}
