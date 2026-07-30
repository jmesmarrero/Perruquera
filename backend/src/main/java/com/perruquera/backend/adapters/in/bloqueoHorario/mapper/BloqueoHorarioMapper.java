package com.perruquera.backend.adapters.in.bloqueoHorario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.perruquera.backend.adapters.in.bloqueoHorario.api.BloqueoHorarioRequestDTO;
import com.perruquera.backend.adapters.in.bloqueoHorario.api.BloqueoHorarioResponseDTO;
import com.perruquera.backend.entities.BloqueoHorario;

import com.perruquera.backend.entities.Usuario;

@Mapper(componentModel = "spring")
public interface BloqueoHorarioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "usuario", source = "usuarioId")
    BloqueoHorario toDomain(BloqueoHorarioRequestDTO requestDTO);

    @Mapping(target = "usuarioId", source = "usuario.id")
    BloqueoHorarioResponseDTO toResponse(BloqueoHorario bloqueoHorario);

    default Usuario map(Long id) {
        return id == null ? null : new Usuario(id);
    }

    
    

}
