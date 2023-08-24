package br.com.projeto.loja.dominio.cliente.controller;

import br.com.projeto.loja.dominio.cliente.aplicacao.ClienteService;
import br.com.projeto.loja.dominio.cliente.dto.ClienteDTO;
import br.com.projeto.loja.dominio.cliente.entidade.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long incluir(@RequestBody ClienteDTO dto) {
        return service.inserir(dto).getId();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long editar(@RequestBody ClienteDTO dto) {
        return service.editar(dto).getId();
    }

    @Transactional(readOnly = true)
    @GetMapping("{id}")
    public ClienteDTO consultar(@PathVariable Long id) {
        Cliente cliente = service.consultar(id);
        return new ClienteDTO().from(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping
    public List<ClienteDTO> listar() {
        return service.listar();
    }

}
