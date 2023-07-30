package br.com.projeto.loja.infraestrutura.spring._shared;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class BaseRepositoryImpl<T, ID> {

    @Autowired
    protected EntityManager entityManager;
    protected JpaRepository<T, ID> repository;

    public T save(T entity) {
        return repository.save(entity);
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

}
