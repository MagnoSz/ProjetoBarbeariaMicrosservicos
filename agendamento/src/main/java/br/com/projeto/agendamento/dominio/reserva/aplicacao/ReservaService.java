package br.com.projeto.agendamento.dominio.reserva.aplicacao;

import br.com.projeto.agendamento.dominio.fidelidade.dto.FidelidadeDTO;
import br.com.projeto.agendamento.dominio.reserva.dto.ReservaDTO;
import br.com.projeto.agendamento.dominio.reserva.entidade.Reserva;
import br.com.projeto.agendamento.dominio.reserva.repository.ReservaRepository;
import br.com.projeto.agendamento.dominio.servico.entidade.Servico;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRegras regras;
    private final ReservaRepository repository;

    public Reserva inserir(ReservaDTO dto) {
        Reserva reserva = dto.toDomain();
        regras.aplicarRegrasBeforeInsert(reserva);
        return repository.inserir(reserva).get();
    }

    public Reserva editar(ReservaDTO dto) {
        Reserva reserva = dto.toDomain();
        regras.aplicarRegrasBeforeUpdate(reserva);
        return repository.editar(reserva).get();
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }

    public Reserva consultar(Long id) {
        return repository.consultar(id).get();
    }

    public List<ReservaDTO> listar(){
        List<Reserva> reservasDominio = repository.listar();
        return ReservaDTO.from(reservasDominio);
    }

    public List<Reserva> obterReservasDoFuncionarioPorData(Long funcionarioId, Date dataReserva) {
        return repository.obterReservasDoFuncionarioPorData(funcionarioId, dataReserva);
    }

    public List<String> getHorariosReservadosDasReservas(List<Reserva> reservas) {
        return repository.getHorariosReservadosDasReservas(reservas);
    }

    public List<String> getHorariosFiltrados(List<String> horariosReservados, List<Servico> servicos, Date dataPesquisada) {
        return repository.getHorariosFiltrados(horariosReservados, servicos, dataPesquisada);
    }

    public FidelidadeDTO obterCountFidelidadeCliente(Long id){
        return repository.obterCountFidelidadeCliente(id);
    }

    public List<ReservaDTO> listarFiltrado(Long funcionarioId, Date dataReserva){
        return ReservaDTO.from(repository.listarFiltrado(funcionarioId, dataReserva));
    }

}
