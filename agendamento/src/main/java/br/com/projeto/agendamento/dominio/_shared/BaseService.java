package br.com.projeto.agendamento.dominio._shared;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BaseService<DTO, DOMINIO> {

    private Regras regras;
    private BaseRepository repository;
    private BaseDTO dto;

    public DOMINIO inserir(BaseDTO dto) throws Exception {
        DOMINIO dominio = (DOMINIO) dto.toDomain();
        regras.aplicarRegrasBeforeInsert(dominio);
        return (DOMINIO) repository.inserir(dominio).get();
    }

    public DOMINIO editar(BaseDTO dto) throws Exception {
        DOMINIO dominio = (DOMINIO) dto.toDomain();
        regras.aplicarRegrasBeforeUpdate(dominio);
        return (DOMINIO) repository.editar(dominio).get();
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }

    public DOMINIO consultar(Long id) {
        return (DOMINIO) repository.consultar(id).get();
    }

    public List<DTO> listar(){
        List<DOMINIO> dominios = repository.listar();
        return (List<DTO>) dto.from(dominios);
    }

}
