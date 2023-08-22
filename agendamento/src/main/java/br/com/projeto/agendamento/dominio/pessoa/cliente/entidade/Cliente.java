package br.com.projeto.agendamento.dominio.pessoa.cliente.entidade;

import br.com.projeto.agendamento.core.config.exceptions.RegraNegocioException;
import br.com.projeto.agendamento.dominio._utils.CPFUtil;
import br.com.projeto.agendamento.dominio.pessoa.Pessoa;

import java.util.Date;

public class Cliente extends Pessoa {

    public Cliente(Long id, String nome, String cpf, String telefone, Date dataCadastro, Boolean ativo) {
        super(id, nome, cpf, telefone, dataCadastro, ativo);
        validar();
    }

    public Cliente(Long id) {
        super(id);
    }

    private void validar() {
        if (!CPFUtil.cpfValido(getCpf().replace(".", "").replace("-", ""))) throw new RegraNegocioException("CPF Inválido!");
    }

}
