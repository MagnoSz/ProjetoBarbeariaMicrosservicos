package br.com.projeto.agendamento.dominio._shared;

public interface Regras<DOMINIO> {
    void aplicarRegrasBeforeInsert(DOMINIO dominio);
    void aplicarRegrasBeforeUpdate(DOMINIO dominio);
}
