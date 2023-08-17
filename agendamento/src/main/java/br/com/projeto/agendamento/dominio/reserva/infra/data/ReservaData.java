package br.com.projeto.agendamento.dominio.reserva.infra.data;

import br.com.projeto.agendamento.dominio._shared.EntidadeGenerica;
import br.com.projeto.agendamento.dominio.pessoa.cliente.infra.data.ClienteData;
import br.com.projeto.agendamento.dominio.pessoa.funcionario.infra.data.FuncionarioData;
import br.com.projeto.agendamento.dominio.reserva.entidade.StatusReservaEnum;
import br.com.projeto.agendamento.dominio.servico.infra.data.ServicoData;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_reserva")
public class ReservaData extends EntidadeGenerica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private ClienteData cliente;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id")
    private FuncionarioData funcionario;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @JoinTable(name = "tb_reserva_servico", joinColumns = {@JoinColumn(name = "id_reserva")}, inverseJoinColumns = {@JoinColumn(name = "id_servico")})
    private List<ServicoData> servicos;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicial;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;

    @Enumerated(EnumType.STRING)
    private StatusReservaEnum statusReserva = StatusReservaEnum.RESERVADO;

}
