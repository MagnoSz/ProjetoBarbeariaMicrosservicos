package br.com.projeto.loja.dominio._shared;

import br.com.projeto.loja.core.config.exceptions.NaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class BaseRepositoryImpl<DATA, DOMINIO> {

    private final BaseMapper<DATA, DOMINIO> mapper;
    private final JpaRepository<DATA, Long> repository;

    public Optional<DOMINIO> inserir(DOMINIO dominio) throws Exception {
        DATA data = mapper.toData(dominio);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    public Optional<DOMINIO> editar(DOMINIO dominio) throws Exception {
        DATA data = mapper.toData(dominio);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    public void deletar(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    public Optional<DOMINIO> consultar(Long id) throws Exception {
        DATA data = repository.findById(id).orElseThrow(NaoEncontradoException::new);
        return Optional.of(mapper.toDomain(data));
    }

}
