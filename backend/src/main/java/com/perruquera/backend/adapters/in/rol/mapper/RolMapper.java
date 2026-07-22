package com.perruquera.backend.adapters.in.rol.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.perruquera.backend.adapters.in.rol.api.RolRequestDTO;
import com.perruquera.backend.adapters.in.rol.api.RolResponseDTO;
import com.perruquera.backend.entities.Rol;

@Mapper(componentModel = "spring")
public interface RolMapper {

    @Mapping(target = "id", ignore = true)
    Rol toDomain(RolRequestDTO request);

    RolResponseDTO toResponseDTO(Rol rol);


}
