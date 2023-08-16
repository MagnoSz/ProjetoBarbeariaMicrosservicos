package br.com.projeto.agendamento.dominio.imagem.dto;

import br.com.projeto.agendamento.dominio.imagem.entidade.Imagem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImagemDTO {

    private Long id;
    private String nome;
    private byte[] conteudo;
    private String tamanho;
    private String tipo;
    private String dimensoes;

    public Imagem toDomain() {
        return new Imagem(id, nome, conteudo, tamanho, tipo, dimensoes);
    }

    public static ImagemDTO from(Imagem imagem) {
        if (imagem == null) return null;

        ImagemDTO imagemDTO = new ImagemDTO();
        imagemDTO.setId(imagem.getId());
        imagemDTO.setNome(imagem.getNome());
        imagemDTO.setConteudo(imagem.getConteudo());
        imagemDTO.setTamanho(imagem.getTamanho());
        imagemDTO.setTipo(imagem.getTipo());
        imagemDTO.setDimensoes(imagem.getDimensoes());

        return imagemDTO;
    }

}
