package org.acme.dto;

import org.acme.model.ItemPedido;

public record ItemPedidoResponseDto(

        Long idProduto,
        Integer qtd,
        Double preco) {

    public static ItemPedidoResponseDto valueOf(ItemPedido itemPedido){
        return new ItemPedidoResponseDto(itemPedido.getMotor().getId(), itemPedido.getEstoque(), itemPedido.getPreco());
    }

}