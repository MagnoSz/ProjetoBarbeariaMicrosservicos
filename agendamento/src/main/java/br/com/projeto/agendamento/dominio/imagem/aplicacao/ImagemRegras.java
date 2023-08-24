package br.com.projeto.agendamento.dominio.imagem.aplicacao;

import br.com.projeto.agendamento.dominio._shared.Regras;
import br.com.projeto.agendamento.dominio.imagem.entidade.Imagem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ImagemRegras implements Regras<Imagem> {
    @Override
    public void aplicarRegrasBeforeInsert(Imagem imagem) {

    }

    @Override
    public void aplicarRegrasBeforeUpdate(Imagem imagem) {

    }
}
