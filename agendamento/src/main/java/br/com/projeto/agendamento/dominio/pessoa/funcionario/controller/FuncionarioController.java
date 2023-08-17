package br.com.projeto.agendamento.dominio.pessoa.funcionario.controller;

import br.com.projeto.agendamento.dominio.pessoa.funcionario.aplicacao.FuncionarioService;
import br.com.projeto.agendamento.dominio.pessoa.funcionario.dto.FuncionarioDTO;
import br.com.projeto.agendamento.dominio.pessoa.funcionario.entidade.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long incluir(@RequestBody FuncionarioDTO dto) {
        return service.inserir(dto).getId();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long editar(@RequestBody FuncionarioDTO dto) {
        return service.editar(dto).getId();
    }

    @Transactional(readOnly = true)
    @GetMapping("{id}")
    public FuncionarioDTO consultar(@PathVariable Long id) {
        Funcionario funcionario = service.consultar(id);
        return new FuncionarioDTO().from(funcionario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping
    public List<FuncionarioDTO> listar() {
        return service.listar();
    }

}
