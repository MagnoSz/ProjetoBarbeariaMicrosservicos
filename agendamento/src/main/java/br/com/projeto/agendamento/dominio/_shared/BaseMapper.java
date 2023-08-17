package br.com.projeto.agendamento.dominio._shared;

public interface BaseMapper<DATA, DOMINIO> {
    DOMINIO toDomain(DATA data);
    DATA toData(DOMINIO dominio);
}
