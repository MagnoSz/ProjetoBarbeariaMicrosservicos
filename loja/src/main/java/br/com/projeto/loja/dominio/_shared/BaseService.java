package br.com.projeto.loja.dominio._shared;

public class BaseService<DOMINIO> {

    protected Regras regras;
    protected BaseRepository<DOMINIO> repository;

    public BaseService(Regras regras, BaseRepository repository){
        this.regras = regras;
        this.repository = repository;
    }

    public DOMINIO inserir(BaseDTO dto) throws Exception {
        DOMINIO dominio = (DOMINIO) dto.toDomain();
        regras.aplicarRegrasBeforeInsert();
        return repository.inserir(dominio).get();
    }

    public DOMINIO editar(BaseDTO dto) throws Exception {
        DOMINIO dominio = (DOMINIO) dto.toDomain();
        regras.aplicarRegrasBeforeUpdate();
        return repository.editar(dominio).get();
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }

    public DOMINIO consultar(Long id) throws Exception {
        return repository.consultar(id).get();
    }

}
