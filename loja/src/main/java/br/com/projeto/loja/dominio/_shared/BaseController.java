package br.com.projeto.loja.dominio._shared;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
public class BaseController <DOMINIO> {

    private BaseService<DOMINIO> service;

    public BaseController(BaseService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void incluir(@RequestBody BaseDTO dto) throws Exception {
        service.inserir(dto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void editar(@RequestBody BaseDTO dto) throws Exception {
        service.editar(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}
