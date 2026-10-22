package com.vendas.cadastro_service.repository;

import com.vendas.cadastro_service.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    boolean existsByCpf(String cpf);
    boolean existsByUsuarioId(UUID usuarioId);
    boolean existsByCpfAndIdNot(String cpf, UUID id);
}
