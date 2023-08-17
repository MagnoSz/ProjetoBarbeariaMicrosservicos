package br.com.projeto.agendamento.dominio.imagem.entidade;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class Imagem {

    private Long id;
    private String nome;
    private byte[] conteudo;
    private String tamanho;
    private String tipo;
    private String dimensoes;

    public Imagem(Long id, String nome, byte[] conteudo, String tamanho, String tipo, String dimensoes) {
        this.id = id;
        this.nome = nome;
        this.conteudo = conteudo;
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.dimensoes = dimensoes;
    }

}
