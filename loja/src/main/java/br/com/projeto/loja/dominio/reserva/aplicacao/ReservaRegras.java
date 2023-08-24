package br.com.projeto.loja.dominio.reserva.aplicacao;

import br.com.projeto.loja.dominio._shared.Regras;
import br.com.projeto.loja.dominio.reserva.entidade.Reserva;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservaRegras implements Regras<Reserva> {
    @Override
    public void aplicarRegrasBeforeInsert(Reserva reserva) {

    }

    @Override
    public void aplicarRegrasBeforeUpdate(Reserva reserva) {

    }
}
