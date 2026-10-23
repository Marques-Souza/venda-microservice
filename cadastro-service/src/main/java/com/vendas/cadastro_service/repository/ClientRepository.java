package com.vendas.cadastro_service.repository;

import com.vendas.cadastro_service.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    boolean existsByCpf(String cpf);
    boolean existsByUserId(UUID userId);
    boolean existsByCpfAndIdNot(String cpf, UUID id);
    Optional<Client> findByIdAndUserId(UUID id, UUID userId);



    @Query("""
        SELECT c
        FROM Client c
        WHERE LOWER(c.cpf) LIKE LOWER(CONCAT('%', :search, '%'))
        OR LOWER(c.name) LIKE LOWER(CONCAT('%', :search, '%'))
""")
    Page<Client> findBySearch(@Param("search")String search, Pageable pageable);
}
