package com.vendas.cadastro_service.dto;

import java.util.UUID;

public record ClientResponseDto(

        UUID id,
        String name,
        String cpf,
        String phone,
        UUID userId

) {
}
