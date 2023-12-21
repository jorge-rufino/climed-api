package com.rufino.climedapi.service;

import com.rufino.climedapi.dto.PacienteDTO;
import com.rufino.climedapi.dto.PacienteReduzidoDTO;
import com.rufino.climedapi.mapper.PacienteMapper;
import com.rufino.climedapi.model.Paciente;
import com.rufino.climedapi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteMapper pacienteMapper;

    @Autowired
    private PacienteRepository repository;

    public Paciente salvar(PacienteDTO pacienteDTO){
        return repository.save(pacienteMapper.toPacienteEntity(pacienteDTO));
    }

    public Page<PacienteReduzidoDTO> listar(Pageable pageable){
        return repository.findAll(pageable).map(paciente -> pacienteMapper.toReduzidoDto(paciente));
    }
}
