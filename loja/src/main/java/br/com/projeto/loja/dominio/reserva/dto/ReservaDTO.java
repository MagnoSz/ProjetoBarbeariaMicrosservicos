package br.com.projeto.loja.dominio.reserva.dto;

import br.com.projeto.loja.dominio._utils.Util;
import br.com.projeto.loja.dominio.cliente.dto.ClienteDTO;
import br.com.projeto.loja.dominio.cliente.entidade.Cliente;
import br.com.projeto.loja.dominio.produto.dto.ProdutoDTO;
import br.com.projeto.loja.dominio.reserva.entidade.Reserva;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {

    private Long id;
    private List<ProdutoDTO> produtos;
    private ClienteDTO cliente;
    private Date dataPedido;

    public Reserva toDomain() {
        return new Reserva(
                id,
                ProdutoDTO.toDomain(produtos),
                Util.isDiferenteDeNullEDeVazio(cliente.getId()) ? new Cliente(cliente.getId()) : null,
                dataPedido
        );
    }

    public static List<Reserva> toDomain(List<ReservaDTO> reservasDTO) {
        return Util.isDiferenteDeNullEDeVazio(reservasDTO) ? reservasDTO.stream().map(ReservaDTO::toDomain).collect(Collectors.toList()) : new ArrayList<>();
    }

    public static ReservaDTO from(Reserva reserva) {
        if (reserva == null) return null;

        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setId(reserva.getId());
        reservaDTO.setCliente(ClienteDTO.from(reserva.getCliente()));
        reservaDTO.setProdutos(ProdutoDTO.from(reserva.getProdutos()));
        reservaDTO.setDataPedido(reserva.getDataPedido());

        return reservaDTO;
    }

    public static List<ReservaDTO> from(List<Reserva> reservasDominio) {
        return Util.isDiferenteDeNullEDeVazio(reservasDominio) ? reservasDominio.stream().map(ReservaDTO::from).collect(Collectors.toList()) : new ArrayList<>();
    }

}
