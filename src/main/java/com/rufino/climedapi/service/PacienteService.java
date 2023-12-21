package com.rufino.climedapi.service;

import com.rufino.climedapi.dto.PacienteDTO;
import com.rufino.climedapi.dto.PacienteReduzidoDTO;
import com.rufino.climedapi.mapper.PacienteMapper;
import com.rufino.climedapi.model.Paciente;
import com.rufino.climedapi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteMapper pacienteMapper;

    @Autowired
    private PacienteRepository repository;

    public Paciente salvar(PacienteDTO pacienteDTO){
        return repository.save(pacienteMapper.toPacienteEntity(pacienteDTO));
    }

    public List<PacienteReduzidoDTO> listar(){
        return pacienteMapper.toCollectionReduzidoDto(repository.findAll());
    }
}
