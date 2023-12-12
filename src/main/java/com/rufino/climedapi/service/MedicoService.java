package com.rufino.climedapi.service;

import com.rufino.climedapi.dto.MedicoDTO;
import com.rufino.climedapi.model.Endereco;
import com.rufino.climedapi.model.Medico;
import com.rufino.climedapi.repository.MedicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public Medico salvar(MedicoDTO dto){
        Medico newMedico = new Medico();
        Endereco newEndereco = new Endereco();

        BeanUtils.copyProperties(dto.endereco(), newEndereco);
        BeanUtils.copyProperties(dto, newMedico,"id");

        newMedico.setEndereco(newEndereco);

        System.out.println(newMedico);
        return repository.save(newMedico);
    }
}
