package com.rufino.climedapi.controller;

import com.rufino.climedapi.dto.PacienteDTO;
import com.rufino.climedapi.model.Paciente;
import com.rufino.climedapi.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public Paciente cadastrar(@RequestBody PacienteDTO pacienteDTO){

        return pacienteService.salvar(pacienteDTO);
    }
}
