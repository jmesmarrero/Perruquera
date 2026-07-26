package com.perruquera.backend.adapters.in.raza.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.perruquera.backend.adapters.in.raza.api.RazaRequestDTO;
import com.perruquera.backend.adapters.in.raza.api.RazaResponseDTO;
import com.perruquera.backend.entities.Especie;
import com.perruquera.backend.entities.Raza;

@Mapper(componentModel = "spring")
public interface RazaMapper {

    @Mapping(target = "especie", source = "especieId")
    Raza toDomain(RazaRequestDTO dto);

    default Especie map(Long id) {
        if (id == null) {
            return null;
        }
        return new Especie(id);
    }

    RazaResponseDTO toResponse(Raza raza);
}