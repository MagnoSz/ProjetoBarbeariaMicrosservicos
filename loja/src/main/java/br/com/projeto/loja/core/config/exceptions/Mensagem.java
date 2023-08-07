package br.com.projeto.loja.core.config.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Mensagem {

    private String texto;
    private Object[] args;

    public Mensagem(String texto) {
        this.texto = texto;
    }

    public static Mensagem of(String texto, String arg) {
        return new Mensagem(texto, new Object[]{arg});
    }

    public static Mensagem of(String texto, List<Object> args) {
        return new Mensagem(texto, args.toArray());
    }


}
