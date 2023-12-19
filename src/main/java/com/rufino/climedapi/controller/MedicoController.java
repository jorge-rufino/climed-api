package com.rufino.climedapi.controller;

import com.rufino.climedapi.dto.MedicoDTO;
import com.rufino.climedapi.dto.MedicoReduzidoDTO;
import com.rufino.climedapi.model.Medico;
import com.rufino.climedapi.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<Medico> cadastrar(@RequestBody @Valid MedicoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<MedicoReduzidoDTO>> listar(){
        return ResponseEntity.ok(medicoService.listar());
    }
}
