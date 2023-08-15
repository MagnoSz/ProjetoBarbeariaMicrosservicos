package br.com.projeto.agendamento.dominio._shared;

import java.util.List;

public interface BaseDTO<DTO, DOMINIO> {
    DOMINIO toDomain() throws Exception;
    DOMINIO toDomain(List<DTO> dtos) throws Exception;
    DTO from(DOMINIO dominio);
    DTO from(List<DOMINIO> dominios);
}
