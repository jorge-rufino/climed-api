package com.rufino.climedapi.controller;

import com.rufino.climedapi.dto.MedicoDTO;
import com.rufino.climedapi.dto.MedicoReduzidoDTO;
import com.rufino.climedapi.mapper.MedicoMapper;
import com.rufino.climedapi.model.Medico;
import com.rufino.climedapi.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
    public Page<MedicoReduzidoDTO> listar(Pageable pageable){
        return medicoService.listar(pageable);
    }
}
