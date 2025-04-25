package dto;

import model.Servico;
import java.util.List;
import java.util.stream.Collectors;

public record DtoServicoResponse(long id, String nome, List<Long> oficina_id) {


    public static DtoServicoResponse valueof(Servico servico) {
        if(servico == null) return null;

        List<Long> oficinaIds = servico.getOficinas().stream()
                .map(oficina -> oficina.getId())  // Pegando o ID de cada oficina
                .collect(Collectors.toList());    // Coletando os IDs em uma lista

        return new DtoServicoResponse(servico.getId(), servico.getNome(), oficinaIds);
    }
}

