package br.com.projeto.loja.dominio._shared;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EntidadeGenerica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_cadastro")
    private Date dataCadastro;

    @Column(name = "flag_ativo")
    private Boolean ativo;

}
