package com.vendas.cadastro_service.dto;

import jakarta.validation.constraints.Size;

public record ClientRequestUpdateDto(


        @Size(max = 150, message = "Name must have a maximum of 150 characters")
        String name,

        @Size(max = 20, message = "Phone must have a maximum of 20 characters")
        String phone

) {
}
