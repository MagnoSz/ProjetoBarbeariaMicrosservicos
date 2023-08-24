package br.com.projeto.agendamento.dominio.imagem.aplicacao;

import br.com.projeto.agendamento.dominio.imagem.repository.ImagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImagemService {

    private final ImagemRegras regras;
    private final ImagemRepository repository;

}
