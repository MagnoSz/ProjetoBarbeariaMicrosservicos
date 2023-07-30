package br.com.projeto.loja.infraestrutura.spring._shared;

public abstract class BaseMapper<DATA, DOMINIO> {
    public abstract DOMINIO toDomain(DATA data) throws Exception;
    public abstract DATA toData(DOMINIO dominio);
}
