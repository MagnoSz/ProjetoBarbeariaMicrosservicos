package br.com.projeto.loja.dominio._shared;

import br.com.projeto.loja.core.config.exceptions.NaoEncontradoException;
import br.com.projeto.loja.dominio._utils.TransformerTuple;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BaseRepositoryImpl{

    @Autowired
    protected EntityManager em;

    protected <T> List<T> executeQueryAndTransforResult(CriteriaQuery<Tuple> query, Class<T> clazz) {
        final TypedQuery<Tuple> typedQuery = em.createQuery(query);
        final List<Tuple> tuples = typedQuery.getResultList();
        final List<T> result =  tuples
                .stream()
                .map(tuple -> TransformerTuple.transformer(tuple, clazz))
                .collect(Collectors.toList());
        this.cleanAndCloseEntityConnection();
        return result;
    }

    protected void cleanAndCloseEntityConnection() {
        em.clear();
        em.close();
    }

}
