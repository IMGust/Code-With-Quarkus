package org.acme.dto;

import java.util.List;

public record PedidoDto(

        // pagamento
        Long idEndereco,
        Double total,
        List<ItemPedidoDto> itens

) {

}
