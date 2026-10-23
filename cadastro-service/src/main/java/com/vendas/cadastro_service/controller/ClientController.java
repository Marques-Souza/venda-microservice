package com.vendas.cadastro_service.controller;

import com.vendas.cadastro_service.dto.ClientRequestDto;
import com.vendas.cadastro_service.dto.ClientRequestUpdateDto;
import com.vendas.cadastro_service.dto.ClientResponseDto;
import com.vendas.cadastro_service.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto> findById(@PathVariable UUID id){
        ClientResponseDto resposne = clientService.findById(id);
        return ResponseEntity.ok(resposne);
    }

    @GetMapping
    public ResponseEntity<Page<ClientResponseDto>> findALl(
            @RequestHeader(value = "search", required = false)String search,
            @PageableDefault(page = 0, size = 10, sort = "name")Pageable pageable){

        Page<ClientResponseDto> response = clientService.findAll(search, pageable);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDto> update(
            @PathVariable UUID id,
            @RequestHeader("X-User-Id") UUID userdId,
            @Valid @RequestBody ClientRequestUpdateDto dto){
        ClientResponseDto response = clientService.update(id, dto, userdId);
        return  ResponseEntity.ok(response);
    }
}
