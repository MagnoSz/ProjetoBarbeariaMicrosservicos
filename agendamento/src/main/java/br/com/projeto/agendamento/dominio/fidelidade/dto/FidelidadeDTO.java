package br.com.projeto.agendamento.dominio.fidelidade.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FidelidadeDTO {
    private int countReservas;
    private Long idCliente;
}
