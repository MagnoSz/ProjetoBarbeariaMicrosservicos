package br.com.projeto.agendamento.dominio.pessoa.cliente.infra.data;

import br.com.projeto.agendamento.dominio._shared.EntidadeGenerica;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_cliente")
public class ClienteData extends EntidadeGenerica {

    private String nome;
    private String cpf;
    private String telefone;

}
