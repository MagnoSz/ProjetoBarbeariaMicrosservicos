package br.com.projeto.loja.infraestrutura.spring._shared;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class BaseService <T, M> {

    protected JpaRepository<T, Long> repository;
    protected BaseMapper<T, M> mapper;

    public BaseService(JpaRepository<T, Long> repository, BaseMapper<T, M> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public T save(M entidadeDominio) {
        T entidadeData = mapper.toData(entidadeDominio);
        return repository.save(entidadeData);
    }

    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
