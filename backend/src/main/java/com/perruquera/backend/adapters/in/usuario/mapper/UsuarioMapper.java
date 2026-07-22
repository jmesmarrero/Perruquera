package com.perruquera.backend.adapters.in.usuario.mapper;

import org.mapstruct.Mapper;

import com.perruquera.backend.adapters.in.usuario.api.UsuarioRequestDTO;
import com.perruquera.backend.adapters.in.usuario.api.UsuarioResponseDTO;
import com.perruquera.backend.entities.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toDomain(UsuarioRequestDTO requestDTO);

    UsuarioResponseDTO toResponseDTO(Usuario usuario);

}
