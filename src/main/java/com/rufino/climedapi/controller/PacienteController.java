package com.rufino.climedapi.controller;

import com.rufino.climedapi.dto.PacienteDTO;
import com.rufino.climedapi.model.Paciente;
import com.rufino.climedapi.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Paciente> cadastrar(@RequestBody @Valid PacienteDTO pacienteDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.salvar(pacienteDTO));
    }
}
