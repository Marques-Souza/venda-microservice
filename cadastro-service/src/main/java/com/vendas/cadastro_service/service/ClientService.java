package com.vendas.cadastro_service.service;

import com.vendas.cadastro_service.mapper.ClientMapper;
import com.vendas.cadastro_service.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;


}
