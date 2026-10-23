package com.vendas.cadastro_service.service;

import com.vendas.cadastro_service.dto.ClientRequestDto;
import com.vendas.cadastro_service.dto.ClientResponseDto;
import com.vendas.cadastro_service.exception.ClientAlreadyExistsException;
import com.vendas.cadastro_service.mapper.ClientMapper;
import com.vendas.cadastro_service.model.Client;
import com.vendas.cadastro_service.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;


    @Transactional
    public ClientResponseDto create (ClientRequestDto dto, UUID userId){
        if (clientRepository.existsByCpf(dto.cpf())){
            throw new ClientAlreadyExistsException("CPF already registered.");
        }

        if (clientRepository.existsByUserId(userId)){
            throw new ClientAlreadyExistsException("User already has client registered");
        }

        Client client = clientMapper.toEntity(dto);
        client.setUserId(userId);
        Client saved = clientRepository.save(client);
        return clientMapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public ClientResponseDto findById(UUID id){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientAlreadyExistsException("Client not found."));
        return  clientMapper.toResponse(client);
    }
}
