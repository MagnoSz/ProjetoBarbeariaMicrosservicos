package br.com.projeto.loja.dominio.produto.infra;

import br.com.projeto.loja.dominio.produto.infra.data.ProdutoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoDataRepository extends JpaRepository<ProdutoData, Long> {
}
