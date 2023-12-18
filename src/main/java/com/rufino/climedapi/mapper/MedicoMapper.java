package com.rufino.climedapi.mapper;

import com.rufino.climedapi.dto.MedicoDTO;
import com.rufino.climedapi.dto.MedicoReduzidoDTO;
import com.rufino.climedapi.model.Medico;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

    Medico toMedicoEntity(MedicoDTO medicoDTO);
    List<MedicoReduzidoDTO> toCollectionDto(List<Medico> medicos);
}
