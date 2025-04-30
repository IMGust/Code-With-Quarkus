package dto;

import model.Servico;
public record DtoServicoResponse(long id, String nome) {


    public static DtoServicoResponse valueof(Servico servico) {
        if(servico == null) return null;

        return new DtoServicoResponse(servico.getId(), servico.getNome());
    }
}

