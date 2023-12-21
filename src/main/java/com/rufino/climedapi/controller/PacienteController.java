package com.rufino.climedapi.controller;

import com.rufino.climedapi.dto.PacienteDTO;
import com.rufino.climedapi.dto.PacienteReduzidoDTO;
import com.rufino.climedapi.model.Paciente;
import com.rufino.climedapi.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> cadastrar(@RequestBody @Valid PacienteDTO pacienteDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.salvar(pacienteDTO));
    }

    @GetMapping
    public ResponseEntity<List<PacienteReduzidoDTO>> listar(){
        return ResponseEntity.ok().body(pacienteService.listar());
    }
}
