package br.com.projeto.agendamento.dominio.servico.repository;

import br.com.projeto.agendamento.core.config.exceptions.NaoEncontradoException;
import br.com.projeto.agendamento.dominio.servico.entidade.Servico;

import java.util.List;
import java.util.Optional;

public interface ServicoRepository {
    Optional<Servico> inserir(Servico servico);
    Optional<Servico> editar(Servico servico);
    void deletar(Long id);
    Optional<Servico> consultar(Long id) throws NaoEncontradoException;
    List<Servico> listar();
    Optional<String> validarNomeJaUtilizado(Servico servico);
}
