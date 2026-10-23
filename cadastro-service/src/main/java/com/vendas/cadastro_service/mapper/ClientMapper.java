package com.vendas.cadastro_service.mapper;

import com.vendas.cadastro_service.dto.ClientRequestDto;
import com.vendas.cadastro_service.dto.ClientRequestUpdateDto;
import com.vendas.cadastro_service.dto.ClientResponseDto;
import com.vendas.cadastro_service.model.Client;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    Client toEntity(ClientRequestDto dto);

    ClientResponseDto toResponse(Client client);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "cpf", ignore = true)
    void updateEntity(ClientRequestUpdateDto dto, @MappingTarget Client client);
}
