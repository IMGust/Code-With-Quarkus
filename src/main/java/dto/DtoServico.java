package dto;


import java.util.List;

public record DtoServico (long id, String nome, List<Long> oficinas_id){

}
