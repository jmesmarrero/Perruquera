package com.perruquera.backend.adapters.in.especie.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.perruquera.backend.adapters.in.especie.api.EspecieRequestDTO;
import com.perruquera.backend.adapters.in.especie.api.EspecieResponseDTO;
import com.perruquera.backend.entities.Especie;

@Mapper(componentModel = "spring")
public interface EspecieMapper {

    @Mapping(target ="id", ignore = true)
    Especie toDomain(EspecieRequestDTO request);
    EspecieResponseDTO toResponse(Especie especie);

}
