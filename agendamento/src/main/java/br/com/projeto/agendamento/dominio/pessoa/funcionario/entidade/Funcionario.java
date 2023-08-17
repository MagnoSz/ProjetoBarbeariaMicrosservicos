package br.com.projeto.agendamento.dominio.pessoa.funcionario.entidade;

import br.com.projeto.agendamento.core.config.exceptions.RegraNegocioException;
import br.com.projeto.agendamento.dominio._utils.CPFUtil;
import br.com.projeto.agendamento.dominio._utils.Util;
import br.com.projeto.agendamento.dominio.pessoa.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends Pessoa {

    private String descricaoFuncionario;

    public Funcionario(Long id, String nome, String cpf, String telefone, Date dataCadastro, Boolean ativo, String descricaoFuncionario) {
        super(id, nome, cpf, telefone, dataCadastro, ativo);
        this.descricaoFuncionario = descricaoFuncionario;
        validar();
    }

    private void validar() {
        if (!CPFUtil.cpfValido(getCpf().replace(".", "").replace("-", ""))) throw new RegraNegocioException("CPF Invávlido!");
        if (!Util.isDiferenteDeNullEDeVazio(descricaoFuncionario)) throw new RegraNegocioException("É necessário que o funcionário tenha uma descrição");
    }

}
