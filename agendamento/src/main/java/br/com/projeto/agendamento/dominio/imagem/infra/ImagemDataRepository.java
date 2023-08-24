package br.com.projeto.agendamento.dominio.imagem.infra;

import br.com.projeto.agendamento.dominio.imagem.infra.data.ImagemData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemDataRepository extends JpaRepository<ImagemData, Long> {
}
