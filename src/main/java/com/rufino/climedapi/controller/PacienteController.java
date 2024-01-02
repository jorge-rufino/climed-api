package com.rufino.climedapi.controller;

import com.rufino.climedapi.dto.PacienteAtualizarDTO;
import com.rufino.climedapi.dto.PacienteDTO;
import com.rufino.climedapi.dto.PacienteReduzidoDTO;
import com.rufino.climedapi.model.Paciente;
import com.rufino.climedapi.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Page<PacienteReduzidoDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return pacienteService.listar(pageable);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Paciente> atualizar(@RequestBody PacienteAtualizarDTO pacienteDto, @PathVariable Long id){
        Paciente paciente = pacienteService.atualizar(pacienteDto, id);
        return ResponseEntity.ok(paciente);
    }
}
