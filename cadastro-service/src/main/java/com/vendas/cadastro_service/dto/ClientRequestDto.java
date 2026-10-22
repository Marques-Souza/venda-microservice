package com.vendas.cadastro_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record ClientRequestDto(

        @NotBlank(message = "Name is required")
        @Size(max = 150, message = "Name must have a maximum of 150 characters")
        String name,

        @NotBlank(message = "CPF is required")
        @Pattern(regexp = "^\\d{11}$", message = "CPF must be a valid 11-digit number")
        @CPF(message = "CPF must be a valid CPF number")
        String cpf,

        @NotBlank(message = "Phone is required")
        @Size(max = 20, message = "Phone must have a maximum of 20 characters")
        String phone

) {
}
