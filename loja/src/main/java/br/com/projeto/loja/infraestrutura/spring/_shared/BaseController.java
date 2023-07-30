package br.com.projeto.loja.infraestrutura.spring._shared;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class BaseController<DATA, DTO extends BaseDTO<DTO, DOMINIO>, DOMINIO> {

    private BaseService<DATA, DOMINIO> service;

    public BaseController(BaseService<DATA, DOMINIO> service) {
        this.service = service;
    }

    @GetMapping
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<DATA> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DATA buscarPorId(@PathVariable Long id) {
        return (DATA) service.findById(id);
    }

    @PostMapping
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void incluir(@RequestBody DTO objetoDTO) throws Exception {
        DOMINIO dominio = objetoDTO.toDomain();
        service.save(dominio);
    }

    @PutMapping("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<DATA> atualizar(@PathVariable Long id, @RequestBody DTO objetoDTO) throws Exception {
        Optional<DATA> objetoExistente = service.findById(id);
        return objetoExistente.isPresent() ? ResponseEntity.ok(service.save(objetoDTO.toDomain())) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deletar (@PathVariable Long id){
        service.deleteById(id);
    }

}
