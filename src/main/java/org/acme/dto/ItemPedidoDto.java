package org.acme.dto;


public record ItemPedidoDto(
        Long idProduto,
        Double preco,
        Integer qtd
        // desconto
) {

}