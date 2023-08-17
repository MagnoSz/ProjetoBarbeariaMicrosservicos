package br.com.projeto.agendamento.dominio.pessoa.cliente.infra;

import br.com.projeto.agendamento.dominio.pessoa.cliente.infra.data.ClienteData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDataRepository extends JpaRepository<ClienteData, Long> {
}
