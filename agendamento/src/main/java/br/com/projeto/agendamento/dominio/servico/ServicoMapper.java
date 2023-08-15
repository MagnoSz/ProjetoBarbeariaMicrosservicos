package br.com.projeto.agendamento.dominio.servico;

import br.com.projeto.agendamento.dominio._shared.BaseMapper;
import br.com.projeto.agendamento.dominio.servico.entidade.Servico;
import br.com.projeto.agendamento.dominio.servico.infra.data.ServicoData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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

    @Override
    public ServicoData toData(Servico servico) {
        ServicoData servicoData = new ServicoData();
        servicoData.setId(servico.getId());
        servicoData.setValor(servico.getValor());
        servicoData.setDescricao(servico.getDescricao());
        servicoData.setTempo(servico.getTempo());
        return servicoData;
    }
}
