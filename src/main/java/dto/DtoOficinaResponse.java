package dto;

import model.Oficina;
import java.util.List;
import java.util.stream.Collectors;

public record DtoOficinaResponse(
        Long id,
        String nome,
        String endereco,
        List<Long> servicosIds  // Lista de IDs dos serviços associados
) {
    public static DtoOficinaResponse valueof(Oficina oficina) {
        if(oficina == null) return null;

        List<Long> servicosIds = oficina.getServicos().stream()
                .map(servico -> servico.getId())
                .collect(Collectors.toList());

        return new DtoOficinaResponse(
                oficina.getId(),
                oficina.getNome(),
                oficina.getEndereco(),
                servicosIds
        );
    }
}