package com.perruquera.backend.adapters.in.raza.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.perruquera.backend.adapters.in.raza.api.RazaRequestDTO;
import com.perruquera.backend.adapters.in.raza.api.RazaResponseDTO;
import com.perruquera.backend.entities.Especie;
import com.perruquera.backend.entities.Raza;

@Mapper(componentModel = "spring")
public interface RazaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "especie", source = "especieId")
    Raza toDomain(RazaRequestDTO requestDTO);

    @Mapping(target = "especieId", source = "especie.id")
    @Mapping(target = "especieNombre", source = "especie.nombre")
    RazaResponseDTO toResponseDTO(Raza raza);

    default Especie map(Long id) {
        return id == null ? null : new Especie(id);
    }

    default Long map(Especie especie) {
        return especie == null ? null : especie.getId();
    }
}