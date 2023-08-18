package br.com.projeto.agendamento.dominio.reserva.infra.impl;

import br.com.projeto.agendamento.core.config.exceptions.NaoEncontradoException;
import br.com.projeto.agendamento.dominio.pessoa.Pessoa;
import br.com.projeto.agendamento.dominio.reserva.ReservaMapper;
import br.com.projeto.agendamento.dominio.reserva.entidade.Reserva;
import br.com.projeto.agendamento.dominio.reserva.entidade.StatusReservaEnum;
import br.com.projeto.agendamento.dominio.reserva.infra.ReservaDataRepository;
import br.com.projeto.agendamento.dominio.reserva.infra.data.ReservaData;
import br.com.projeto.agendamento.dominio.reserva.repository.ReservaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class ReservaRepositoryImpl implements ReservaRepository {

    @Autowired
    protected EntityManager em;

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

    /*@Override
    public List<Reserva> obterReservasDoFuncionarioPorData(Long idFuncionario, Date dataReserva) {
        final CriteriaBuilder builder = em.getCriteriaBuilder();
        final CriteriaQuery<Tuple> query = builder.createTupleQuery();
        final Root<Reserva> root = query.from(Reserva.class);
        final Join<Reserva, Pessoa> rootFuncionario = root.join("funcionario");

        query.select(builder.tuple(
                root.get("dataInicial").alias("dataInicial"),
                root.get("dataFim").alias("dataFim")
        ));

        Date dataInicial = DateUtil.converterDateInicioDia(dataReserva);
        Date dataFinal = DateUtil.converterDateFimDia(dataReserva);

        query.where(
                builder.equal(rootFuncionario.get("id"), idFuncionario),
                builder.between(root.get("dataInicial"), dataInicial, dataFinal),
                builder.equal(root.get("statusReserva"), StatusReservaEnum.RESERVADO)
        );

        return this.executeQueryAndTransforResult(query, Reserva.class);
    }*/
}
