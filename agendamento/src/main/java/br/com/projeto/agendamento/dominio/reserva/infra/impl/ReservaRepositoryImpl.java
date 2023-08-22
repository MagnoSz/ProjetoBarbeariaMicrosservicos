package br.com.projeto.agendamento.dominio.reserva.infra.impl;

import br.com.projeto.agendamento.core.config.exceptions.NaoEncontradoException;
import br.com.projeto.agendamento.dominio._shared.BaseRepositoryImpl;
import br.com.projeto.agendamento.dominio._utils.DateUtil;
import br.com.projeto.agendamento.dominio.fidelidade.dto.FidelidadeDTO;
import br.com.projeto.agendamento.dominio.horarios.entidade.HorariosDisponiveis;
import br.com.projeto.agendamento.dominio.pessoa.Pessoa;
import br.com.projeto.agendamento.dominio.reserva.ReservaMapper;
import br.com.projeto.agendamento.dominio.reserva.entidade.Reserva;
import br.com.projeto.agendamento.dominio.reserva.entidade.StatusReservaEnum;
import br.com.projeto.agendamento.dominio.reserva.infra.ReservaDataRepository;
import br.com.projeto.agendamento.dominio.reserva.infra.data.ReservaData;
import br.com.projeto.agendamento.dominio.reserva.repository.ReservaRepository;
import br.com.projeto.agendamento.dominio.servico.entidade.Servico;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@Transactional
@RequiredArgsConstructor
public class ReservaRepositoryImpl extends BaseRepositoryImpl implements ReservaRepository { ;

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

    @Override
    public List<Reserva> obterReservasDoFuncionarioPorData(Long idFuncionario, Date dataReserva) {
        final CriteriaBuilder builder = em.getCriteriaBuilder();
        final CriteriaQuery<Tuple> query = builder.createTupleQuery();
        final Root<ReservaData> root = query.from(ReservaData.class);
        final Join<ReservaData, Pessoa> rootFuncionario = root.join("funcionario");

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

        return mapper.toDomain(this.executeQueryAndTransforResult(query, ReservaData.class));
    }

    public List<String> getHorariosReservadosDasReservas(List<Reserva> reservas) {
        List<String> horariosReservados = new ArrayList<>();
        for (Reserva reserva: reservas) {
            Calendar inicio = DateUtil.getCalendarDate(reserva.getDataInicial());
            Calendar fim = DateUtil.getCalendarDate(reserva.getDataFim());
            Calendar temp = (Calendar) inicio.clone();
            temp.add(Calendar.MINUTE, 30);

            horariosReservados.add(DateUtil.getStringHorario(inicio));
            while (temp.before(fim)) {
                horariosReservados.add(DateUtil.getStringHorario(temp));
                temp.add(Calendar.MINUTE, 30);
            }
        }
        return horariosReservados;
    }

    public List<String> getHorariosFiltrados(List<String> horariosReservados, List<Servico> servicos, Date dataPesquisada) {
        List<String> horariosDisponiveis = HorariosDisponiveis.getHorarios().stream().filter(horario -> !horariosReservados.contains(horario)).collect(Collectors.toList());

        int qntHorariosNecessarios = getQntHorariosNecessarios(servicos);
        if (qntHorariosNecessarios > 0) {
            List<String> horariosRemocao = horariosDisponiveis.stream()
                    .filter(horario -> {
                        for (int i = 1; i <= qntHorariosNecessarios; i++) {
                            String horarioTemp = HorariosDisponiveis.getNext(horario, i);
                            if (horarioTemp == null || !horariosDisponiveis.contains(horarioTemp)) {
                                return true;
                            }
                        }
                        return false;
                    })
                    .collect(Collectors.toList());
            horariosDisponiveis.removeIf(horariosRemocao::contains);
        }
        return horariosDisponiveis.stream()
                .filter(horario -> !HorariosDisponiveis.getCalendarData(horario, dataPesquisada).getTime().before(DateUtil.getCalendarDate(new Date()).getTime()))
                .collect(Collectors.toList());
    }

    private int getQntHorariosNecessarios(List<Servico> servicos) {
        return (int) Math.ceil((double) servicos.stream().mapToLong(Servico::getTempo).sum()/30)-1;
    }

    public FidelidadeDTO obterCountFidelidadeCliente(Long id) {
        final CriteriaBuilder builder = em.getCriteriaBuilder();
        final CriteriaQuery<Tuple> query = builder.createTupleQuery();
        final Root<Reserva> root = query.from(Reserva.class);

        query.select(builder.tuple(
                root.get("id").alias("id")));

        query.where(builder.equal(root.get("cliente"), id),
                builder.equal(root.get("statusReserva"), StatusReservaEnum.FINALIZADO));

        FidelidadeDTO fidelidadeDTO = new FidelidadeDTO();
        fidelidadeDTO.setIdCliente(id);
        fidelidadeDTO.setCountReservas(this.executeQueryAndTransforResult(query, Reserva.class).size());

        return fidelidadeDTO;
    }

    public List<Reserva> listarFiltrado(Long funcionarioId, Date dataReserva) {
        final CriteriaBuilder builder = em.getCriteriaBuilder();
        final CriteriaQuery<Tuple> query = builder.createTupleQuery();
        final Root<ReservaData> root = query.from(ReservaData.class);
        final Join<ReservaData, Pessoa> rootCliente = root.join("cliente");
        final Join<ReservaData, Pessoa> rootFuncionario = root.join("funcionario");

        query.select(builder.tuple(
                root.get("id").alias("id"),

                rootCliente.get("id").alias("cliente.id"),
                rootCliente.get("nome").alias("cliente.nome"),

                rootFuncionario.get("id").alias("funcionario.id"),
                rootFuncionario.get("nome").alias("funcionario.nome"),

                root.get("dataInicial").alias("dataInicial"),
                root.get("dataFim").alias("dataFim"),
                root.get("statusReserva").alias("statusReserva")
        ));

        Date dataInicial = DateUtil.converterDateInicioDia(dataReserva);
        Date dataFinal = DateUtil.converterDateFimDia(dataReserva);

        query.where(
                builder.equal(rootFuncionario.get("id"), funcionarioId),
                builder.between(root.get("dataInicial"), dataInicial, dataFinal),
                builder.equal(root.get("statusReserva"), StatusReservaEnum.RESERVADO)
        );

        return mapper.toDomain(this.executeQueryAndTransforResult(query, ReservaData.class));
    }

}
