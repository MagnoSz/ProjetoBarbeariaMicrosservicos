package br.com.projeto.agendamento.dominio.pessoa.funcionario.aplicacao;

import br.com.projeto.agendamento.dominio._shared.Regras;
import br.com.projeto.agendamento.dominio.pessoa.funcionario.entidade.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FuncionarioRegras implements Regras<Funcionario> {
    @Override
    public void aplicarRegrasBeforeInsert(Funcionario funcionario) {

    }

    @Override
    public void aplicarRegrasBeforeUpdate(Funcionario funcionario) {

    }
}
