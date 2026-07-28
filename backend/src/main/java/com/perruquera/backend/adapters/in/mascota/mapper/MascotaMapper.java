package com.perruquera.backend.adapters.in.mascota.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.perruquera.backend.adapters.in.mascota.api.MascotaRequestDTO;
import com.perruquera.backend.adapters.in.mascota.api.MascotaResponseDTO;
import com.perruquera.backend.entities.Mascota;

@Mapper(componentModel = "spring")
public interface MascotaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "usuario.id", source = "usuarioId")
    @Mapping(target = "raza.id", source = "razaId")
    Mascota toDomain(MascotaRequestDTO reuest);

    @Mapping(target = "usuarioId", source = "usuario.id")
    @Mapping(target = "razaId", source = "raza.id")
    MascotaResponseDTO toResponseDTO(Mascota mascota);

}
