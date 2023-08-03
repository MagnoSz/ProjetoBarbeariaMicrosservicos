package br.com.projeto.loja.dominio._shared;

public interface BaseDTO<DTO, DOMINIO> {
    DOMINIO toDomain() throws Exception;
    DTO from(DOMINIO dominio);
}
