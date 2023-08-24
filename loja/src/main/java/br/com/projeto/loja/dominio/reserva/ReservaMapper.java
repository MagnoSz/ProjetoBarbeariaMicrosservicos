package br.com.projeto.loja.dominio.reserva;

import br.com.projeto.loja.dominio._shared.BaseMapper;
import br.com.projeto.loja.dominio.cliente.ClienteMapper;
import br.com.projeto.loja.dominio.produto.ProdutoMapper;
import br.com.projeto.loja.dominio.produto.entidade.Produto;
import br.com.projeto.loja.dominio.produto.infra.data.ProdutoData;
import br.com.projeto.loja.dominio.reserva.entidade.Reserva;
import br.com.projeto.loja.dominio.reserva.infra.data.ReservaData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReservaMapper implements BaseMapper<ReservaData, Reserva> {

    private final ClienteMapper clienteMapper;
    private final ProdutoMapper produtoMapper;

    @Override
    public Reserva toDomain(ReservaData reservaData) {
        return Reserva.builder()
                .id(reservaData.getId())
                .cliente(this.clienteMapper.toDomain(reservaData.getCliente()))
                .produtos(this.produtoMapper.toDomain(reservaData.getProdutos()))
                .dataPedido(reservaData.getDataPedido())
                .build();
    }

    public List<Reserva> toDomain(List<ReservaData> reservasData) {
        return reservasData.stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public ReservaData toData(Reserva reserva) {
        if (reserva == null) return null;

        ReservaData reservaData = new ReservaData();
        reservaData.setId(reserva.getId());
        reservaData.setCliente(this.clienteMapper.toData(reserva.getCliente()));
        reservaData.setProdutos(this.produtoMapper.toData(reserva.getProdutos()));
        reservaData.setDataPedido(reservaData.getDataPedido());

        return reservaData;
    }

    public List<ReservaData> toData(List<Reserva> reservasDominio) {
        return reservasDominio.stream().map(this::toData).collect(Collectors.toList());
    }

}
