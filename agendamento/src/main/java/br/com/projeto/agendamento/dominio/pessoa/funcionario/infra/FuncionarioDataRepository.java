package br.com.projeto.agendamento.dominio.pessoa.funcionario.infra;

import br.com.projeto.agendamento.dominio.pessoa.funcionario.infra.data.FuncionarioData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioDataRepository extends JpaRepository<FuncionarioData, Long> {
}
