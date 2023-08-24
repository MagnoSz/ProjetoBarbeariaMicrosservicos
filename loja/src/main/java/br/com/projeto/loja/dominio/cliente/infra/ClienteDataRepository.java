package br.com.projeto.loja.dominio.cliente.infra;

import br.com.projeto.loja.dominio.cliente.infra.data.ClienteData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDataRepository extends JpaRepository<ClienteData, Long> {
}
