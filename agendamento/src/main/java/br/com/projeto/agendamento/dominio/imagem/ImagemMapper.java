package br.com.projeto.agendamento.dominio.imagem;

import br.com.projeto.agendamento.dominio._shared.BaseMapper;
import br.com.projeto.agendamento.dominio.imagem.entidade.Imagem;
import br.com.projeto.agendamento.dominio.imagem.infra.data.ImagemData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ImagemMapper implements BaseMapper<ImagemData, Imagem> {

    @Override
    public Imagem toDomain(ImagemData imagemData) {
        return new Imagem(
                imagemData.getId(),
                imagemData.getNome(),
                imagemData.getConteudo(),
                imagemData.getTamanho(),
                imagemData.getTipo(),
                imagemData.getDimensoes()
        );
    }

    @Override
    public ImagemData toData(Imagem imagem) {
        return null;
    }

}
