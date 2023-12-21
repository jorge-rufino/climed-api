package com.rufino.climedapi.mapper;

import com.rufino.climedapi.dto.PacienteDTO;
import com.rufino.climedapi.dto.PacienteReduzidoDTO;
import com.rufino.climedapi.model.Paciente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    Paciente toPacienteEntity(PacienteDTO pacienteDTO);
    List<PacienteReduzidoDTO> toCollectionReduzidoDto(List<Paciente> pacientes);
    PacienteReduzidoDTO toReduzidoDto (Paciente paciente);
}
