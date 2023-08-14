package br.com.projeto.agendamento.dominio.servico.aplicacao;

import br.com.projeto.agendamento.dominio._shared.Regras;
import br.com.projeto.agendamento.dominio.servico.entidade.Servico;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServicoRegras implements Regras<Servico> {
    @Override
    public void aplicarRegrasBeforeInsert(Servico servico) {

    }

    @Override
    public void aplicarRegrasBeforeUpdate(Servico servico) {

    }
}
