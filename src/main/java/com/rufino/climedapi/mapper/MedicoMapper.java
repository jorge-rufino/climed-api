package com.rufino.climedapi.mapper;

import com.rufino.climedapi.dto.MedicoDTO;
import com.rufino.climedapi.model.Medico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

    Medico toMedicoEntity(MedicoDTO medicoDTO);
}
