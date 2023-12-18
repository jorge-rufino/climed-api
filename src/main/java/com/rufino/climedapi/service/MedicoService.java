package com.rufino.climedapi.service;

import com.rufino.climedapi.dto.MedicoDTO;
import com.rufino.climedapi.mapper.MedicoMapper;
import com.rufino.climedapi.model.Endereco;
import com.rufino.climedapi.model.Medico;
import com.rufino.climedapi.repository.MedicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    @Autowired
    private MedicoMapper medicoMapper;

    @Transactional
    public Medico salvar(MedicoDTO dto){
        Medico newMedico = medicoMapper.toMedicoEntity(dto);

        return repository.save(newMedico);
    }
}
