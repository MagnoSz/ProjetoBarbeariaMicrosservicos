package br.com.projeto.loja.dominio.reserva.infra.impl;

import br.com.projeto.loja.core.config.exceptions.NaoEncontradoException;
import br.com.projeto.loja.dominio._shared.BaseRepositoryImpl;
import br.com.projeto.loja.dominio.reserva.ReservaMapper;
import br.com.projeto.loja.dominio.reserva.entidade.Reserva;
import br.com.projeto.loja.dominio.reserva.infra.ReservaDataRepository;
import br.com.projeto.loja.dominio.reserva.infra.data.ReservaData;
import br.com.projeto.loja.dominio.reserva.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class ReservaRepositoryImpl extends BaseRepositoryImpl implements ReservaRepository {

    private final ReservaMapper mapper;
    private final ReservaDataRepository repository;

    @Override
    public Optional<Reserva> inserir(Reserva reserva) {
        ReservaData data = mapper.toData(reserva);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public Optional<Reserva> editar(Reserva reserva) {
        ReservaData data = mapper.toData(reserva);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public void deletar(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public Optional<Reserva> consultar(Long id) {
        ReservaData data = repository.findById(id).orElseThrow(NaoEncontradoException::new);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public List<Reserva> listar() {
        List<ReservaData> servicosData = repository.findAll();
        List<Reserva> servicosDominio = new ArrayList<>();
        servicosData.forEach(produtoData -> servicosDominio.add(mapper.toDomain(produtoData)));
        return servicosDominio;
    }
}
