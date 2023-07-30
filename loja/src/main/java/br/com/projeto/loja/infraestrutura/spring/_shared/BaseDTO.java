package br.com.projeto.loja.infraestrutura.spring._shared;

public abstract class BaseDTO<DTO, DOMINIO> {
    public abstract DOMINIO toDomain() throws Exception;
    public abstract DTO from(DOMINIO dominio);
}
