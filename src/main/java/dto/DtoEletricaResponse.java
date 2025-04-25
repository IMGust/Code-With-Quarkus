package dto;
import model.PecaEletrica;
import model.Servico;

public record DtoEletricaResponse(Long id, String nome, String marca) {


    public static DtoEletricaResponse valueof(PecaEletrica eletrica){
        if(eletrica == null) return null;
            return new DtoEletricaResponse(eletrica.getId(), eletrica.getNome(), eletrica.getMarca());

    }


}
