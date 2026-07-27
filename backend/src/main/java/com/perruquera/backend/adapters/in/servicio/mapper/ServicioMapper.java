package com.perruquera.backend.adapters.in.servicio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.perruquera.backend.adapters.in.servicio.api.ServicioRequestDTO;
import com.perruquera.backend.adapters.in.servicio.api.ServicioResponseDTO;
import com.perruquera.backend.entities.Servicio;

@Mapper(componentModel = "spring")
public interface ServicioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
     Servicio toDomain(ServicioRequestDTO requestDTO);

    ServicioResponseDTO toResponseDTO(Servicio servicio);

}
