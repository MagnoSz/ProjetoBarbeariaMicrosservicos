package br.com.projeto.agendamento.dominio.reserva.infra.impl;

import br.com.projeto.agendamento.dominio.reserva.ReservaMapper;
import br.com.projeto.agendamento.dominio.reserva.entidade.Reserva;
import br.com.projeto.agendamento.dominio.reserva.infra.ReservaDataRepository;
import br.com.projeto.agendamento.dominio.reserva.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class ReservaRepositoryImpl implements ReservaRepository {

    private final ReservaMapper reservaMapper;
    private final ReservaDataRepository repository;

    @Override
    public Optional<Reserva> inserir(Reserva reserva) {
        return Optional.empty();
    }

    @Override
    public Optional<Reserva> editar(Reserva reserva) {
        return Optional.empty();
    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public Optional<Reserva> consultar(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Reserva> listar() {
        return null;
    }
}
