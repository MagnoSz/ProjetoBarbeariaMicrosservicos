package br.com.projeto.agendamento.dominio.servico.repository;

import br.com.projeto.agendamento.dominio._shared.BaseRepository;
import br.com.projeto.agendamento.dominio.servico.entidade.Servico;

import java.util.Optional;

public interface ServicoRepository extends BaseRepository<Servico> {
    Optional<String> validarNomeJaUtilizado(Servico servico);
}
