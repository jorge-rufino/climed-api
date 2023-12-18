package com.rufino.climedapi.mapper;

import com.rufino.climedapi.dto.MedicoDTO;
import com.rufino.climedapi.dto.MedicoReduzidoDTO;
import com.rufino.climedapi.model.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicoMapper {
    //Adicioando para corrigir o valor "null" após adicionar "telefone"
    public static final MedicoMapper INSTANCE = Mappers.getMapper(MedicoMapper.class);

    Medico toMedicoEntity(MedicoDTO medicoDTO);
    List<MedicoReduzidoDTO> toCollectionDto(List<Medico> medicos);
}
