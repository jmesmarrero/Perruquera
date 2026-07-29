package com.perruquera.backend.adapters.in.cita.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.perruquera.backend.adapters.in.cita.api.CitaRequestDTO;
import com.perruquera.backend.adapters.in.cita.api.CitaResponseDTO;
import com.perruquera.backend.entities.Cita;
import com.perruquera.backend.entities.EstadoCita;
import com.perruquera.backend.entities.Mascota;

@Mapper(componentModel = "spring")
public interface CitaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "duracionEstimada", ignore = true)
    @Mapping(target = "precioTotal", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "mascota", source = "mascotaId")
    Cita toDomain(CitaRequestDTO requestDTO);

    @Mapping(target = "mascotaId", source = "mascota.id")
    @Mapping(target = "mascotaNombre", source = "mascota.nombre")
    @Mapping(target = "estadoId", source = "estado.id")
    @Mapping(target = "estadoNombre", source = "estado.nombre")
    CitaResponseDTO toResponseDTO(Cita cita);

    default Mascota map(Long id) {
        return id == null ? null : new Mascota(id);
    }

    default EstadoCita mapEstado(Long id) {
        return id == null ? null : new EstadoCita(id);
    }
}