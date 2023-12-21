package com.rufino.climedapi.mapper;

import com.rufino.climedapi.dto.PacienteDTO;
import com.rufino.climedapi.model.Paciente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    Paciente toPacienteEntity(PacienteDTO pacienteDTO);
}
