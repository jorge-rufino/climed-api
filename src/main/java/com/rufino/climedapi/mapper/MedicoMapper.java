package com.rufino.climedapi.mapper;

import com.rufino.climedapi.dto.MedicoAtualizarDTO;
import com.rufino.climedapi.dto.MedicoDTO;
import com.rufino.climedapi.dto.MedicoReduzidoDTO;
import com.rufino.climedapi.model.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MedicoMapper {
    Medico toMedicoEntity(MedicoDTO medicoDTO);
    MedicoReduzidoDTO toReduzidoDto(Medico medico);

    void updateMedico(MedicoAtualizarDTO medicoAtualizarDTO, @MappingTarget Medico medico);
}
