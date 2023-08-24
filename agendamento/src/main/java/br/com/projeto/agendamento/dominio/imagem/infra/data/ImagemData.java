package br.com.projeto.agendamento.dominio.imagem.infra.data;

import br.com.projeto.agendamento.dominio._shared.EntidadeGenerica;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_imagem")
public class ImagemData extends EntidadeGenerica {

    @Column(name = "nm_imagem", length = 60)
    private String nome;

    @Column(name = "conteudo", length = 20)
    private byte[] conteudo;

    @Column(name = "tamanho", length = 60)
    private String tamanho;

    @Column(name = "tipo", length = 60)
    private String tipo;

    @Column(name = "dimensoes", length = 60)
    private String dimensoes;

}
