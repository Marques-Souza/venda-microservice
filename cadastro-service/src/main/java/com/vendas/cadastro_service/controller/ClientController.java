package com.vendas.cadastro_service.controller;

import com.vendas.cadastro_service.dto.ClientRequestDto;
import com.vendas.cadastro_service.dto.ClientResponseDto;
import com.vendas.cadastro_service.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientResponseDto> create(
            @RequestHeader("X-User-Id") UUID userId,
            @Valid @RequestBody ClientRequestDto dto){
        ClientResponseDto respnse = clientService.create(dto, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(respnse);
    }
}
