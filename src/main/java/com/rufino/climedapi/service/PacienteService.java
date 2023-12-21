package com.rufino.climedapi.service;

import com.rufino.climedapi.dto.PacienteDTO;
import com.rufino.climedapi.mapper.PacienteMapper;
import com.rufino.climedapi.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteMapper pacienteMapper;

    public Paciente salvar(PacienteDTO pacienteDTO){
        return pacienteMapper.toPacienteEntity(pacienteDTO);
    }
}
