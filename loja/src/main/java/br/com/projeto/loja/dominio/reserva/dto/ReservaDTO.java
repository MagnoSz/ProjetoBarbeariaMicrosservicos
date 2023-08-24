package br.com.projeto.loja.dominio.reserva.dto;

import br.com.projeto.loja.dominio.cliente.dto.ClienteDTO;
import br.com.projeto.loja.dominio.produto.dto.ProdutoDTO;
import br.com.projeto.loja.dominio.reserva.entidade.Reserva;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {

    private Long id;
    private ClienteDTO cliente;
    private List<ProdutoDTO> produtos;

    public Reserva toDomain() {

    }

}
