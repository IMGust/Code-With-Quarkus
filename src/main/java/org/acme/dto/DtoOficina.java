package org.acme.dto;

import java.util.List;

public record DtoOficina(String nome, String endereco, List<Long> servicosIds) {
}
