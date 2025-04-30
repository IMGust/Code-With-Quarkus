package dto;

import model.Oficina;
import model.Servico;
import java.util.List;


public record DtoOficinaResponse(Long id, String nome,String endereco, List<Long> servicosIds) {

    public static DtoOficinaResponse valueof(Oficina oficina) {
        if (oficina == null) return null;
        List<Long> servicosIds = oficina.getServicos().stream()
                .map(Servico::getId)
                .toList();
        return new DtoOficinaResponse(oficina.getId(), oficina.getNome(), oficina.getEndereco(),
                servicosIds);
    }
}
