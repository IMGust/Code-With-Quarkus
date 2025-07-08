package org.acme.dto;

import org.acme.model.Pedido;
import org.acme.model.StatusPedido;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoResponseDTO(
        Long id,
        LocalDateTime date,
        Double totalPedido,
        List<ItemPedidoResponseDto> lista,
        EnderecoResponseDTO  endereco,
        StatusPedido status


) {

    public static PedidoResponseDTO valueOf(Pedido pedido){
        return new PedidoResponseDTO(
                pedido.getId(),
                pedido.getDataHora(),
                pedido.getTotalPedido(),
                pedido.getItens().stream().map(i -> ItemPedidoResponseDto.valueOf(i)).toList(),
                EnderecoResponseDTO.valueOf(pedido.getEndereco()),
                pedido.getStatus()

        );
    }

}