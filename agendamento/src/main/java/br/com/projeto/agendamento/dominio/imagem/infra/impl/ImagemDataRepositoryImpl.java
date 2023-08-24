package br.com.projeto.agendamento.dominio.imagem.infra.impl;

import br.com.projeto.agendamento.dominio.imagem.ImagemMapper;
import br.com.projeto.agendamento.dominio.imagem.entidade.Imagem;
import br.com.projeto.agendamento.dominio.imagem.infra.ImagemDataRepository;
import br.com.projeto.agendamento.dominio.imagem.repository.ImagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class ImagemDataRepositoryImpl implements ImagemRepository {

    private final ImagemMapper mapper;
    private final ImagemDataRepository repository;

    @Override
    public Optional<Imagem> inserir(Imagem imagem) {
        return Optional.empty();
    }

    @Override
    public Optional<Imagem> editar(Imagem imagem) {
        return Optional.empty();
    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public Optional<Imagem> consultar(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Imagem> listar() {
        return null;
    }
}
