package br.com.projeto.agendamento.dominio.servico;

import br.com.projeto.agendamento.dominio._shared.BaseMapper;
import br.com.projeto.agendamento.dominio.servico.entidade.Servico;
import br.com.projeto.agendamento.dominio.servico.infra.data.ServicoData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ServicoMapper implements BaseMapper<ServicoData, Servico> {

    @Override
    public Servico toDomain(ServicoData servicoData) {
        return new Servico(
                servicoData.getId(),
                servicoData.getValor(),
                servicoData.getDescricao(),
                servicoData.getTempo()
        );
    }

    public List<Servico> toDomain(List<ServicoData> servicosData) {
        return servicosData.stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public ServicoData toData(Servico servico) {
        ServicoData servicoData = new ServicoData();
        servicoData.setId(servico.getId());
        servicoData.setValor(servico.getValor());
        servicoData.setDescricao(servico.getDescricao());
        servicoData.setTempo(servico.getTempo());
        return servicoData;
    }

    public List<ServicoData> toData(List<Servico> servicosDominio) {
        return servicosDominio.stream().map(this::toData).collect(Collectors.toList());
    }

}
