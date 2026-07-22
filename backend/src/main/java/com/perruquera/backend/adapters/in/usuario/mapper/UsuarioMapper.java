package com.perruquera.backend.adapters.in.usuario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.perruquera.backend.adapters.in.usuario.api.UsuarioRequestDTO;
import com.perruquera.backend.adapters.in.usuario.api.UsuarioResponseDTO;
import com.perruquera.backend.entities.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "fechaRegistro", ignore = true)
    @Mapping(target = "activo", ignore = true)
    // lo de arriba para que el toDomain lo ignore porque MapStruct simplemente te
    // está avisando de que hay propiedades de destino sin asignar.
    Usuario toDomain(UsuarioRequestDTO requestDTO);

    UsuarioResponseDTO toResponseDTO(Usuario usuario);

}
