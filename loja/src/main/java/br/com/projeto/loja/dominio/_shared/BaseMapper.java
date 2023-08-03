package br.com.projeto.loja.dominio._shared;

public interface BaseMapper<DATA, DOMINIO> {
    DOMINIO toDomain(DATA data) throws Exception;
    DATA toData(DOMINIO dominio);
}
