package br.com.projeto.loja.dominio.reserva.infra.data;

import br.com.projeto.loja.dominio._shared.EntidadeGenerica;
import br.com.projeto.loja.dominio.cliente.infra.data.ClienteData;
import br.com.projeto.loja.dominio.produto.infra.data.ProdutoData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_reserva")
public class ReservaData extends EntidadeGenerica {

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private ClienteData cliente;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @JoinTable(name = "tb_reserva_produtos", joinColumns = {@JoinColumn(name = "id_reserva")}, inverseJoinColumns = {@JoinColumn(name = "id_produto")})
    private List<ProdutoData> produtos;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPedido;

}
