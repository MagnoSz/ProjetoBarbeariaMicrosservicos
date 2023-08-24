package br.com.projeto.loja.dominio.reserva.aplicacao;

import br.com.projeto.loja.dominio.reserva.dto.ReservaDTO;
import br.com.projeto.loja.dominio.reserva.entidade.Reserva;
import br.com.projeto.loja.dominio.reserva.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
