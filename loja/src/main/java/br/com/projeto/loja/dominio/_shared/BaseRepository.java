package br.com.projeto.loja.dominio._shared;

import java.util.Optional;

public interface BaseRepository<DATA> {
    Optional<DATA> inserir(DATA classe) throws Exception;
    Optional<DATA> editar(DATA classe) throws Exception;
    void deletar(Long id);
    Optional<DATA> consultar(Long id) throws Exception;
}
