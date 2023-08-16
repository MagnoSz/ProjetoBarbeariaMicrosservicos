package br.com.projeto.agendamento.dominio.servico.controller;

import br.com.projeto.agendamento.dominio.servico.aplicacao.ServicoService;
import br.com.projeto.agendamento.dominio.servico.dto.ServicoDTO;
import br.com.projeto.agendamento.dominio.servico.entidade.Servico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/servico")
public class ServicoController {

    private final ServicoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long incluir(@RequestBody ServicoDTO dto) {
        return service.inserir(dto).getId();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long editar(@RequestBody ServicoDTO dto) {
        return service.editar(dto).getId();
    }

    @Transactional(readOnly = true)
    @GetMapping("{id}")
    public ServicoDTO consultar(@PathVariable Long id) {
        Servico servico = service.consultar(id);
        return new ServicoDTO().from(servico);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping
    public List<ServicoDTO> listar() {
        return service.listar();
    }

}
