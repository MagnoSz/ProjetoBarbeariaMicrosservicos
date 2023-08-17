package br.com.projeto.agendamento.dominio.pessoa.funcionario.aplicacao;

import br.com.projeto.agendamento.dominio.pessoa.funcionario.dto.FuncionarioDTO;
import br.com.projeto.agendamento.dominio.pessoa.funcionario.entidade.Funcionario;
import br.com.projeto.agendamento.dominio.pessoa.funcionario.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRegras regras;
    private final FuncionarioRepository repository;

    public Funcionario inserir(FuncionarioDTO dto) {
        Funcionario funcionario = dto.toDomain();
        regras.aplicarRegrasBeforeInsert(funcionario);
        return repository.inserir(funcionario).get();
    }

    public Funcionario editar(FuncionarioDTO dto) {
        Funcionario funcionario = dto.toDomain();
        regras.aplicarRegrasBeforeUpdate(funcionario);
        return repository.editar(funcionario).get();
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }

    public Funcionario consultar(Long id) {
        return repository.consultar(id).get();
    }

    public List<FuncionarioDTO> listar(){
        List<Funcionario> funcionariosDominio = repository.listar();
        return FuncionarioDTO.from(funcionariosDominio);
    }

}
