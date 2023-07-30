package br.com.projeto.loja.infraestrutura.spring.produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoDataRepository extends JpaRepository<ProdutoData, Long> {
}
