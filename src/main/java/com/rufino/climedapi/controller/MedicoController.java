package com.rufino.climedapi.controller;

import com.rufino.climedapi.dto.MedicoDTO;
import com.rufino.climedapi.model.Endereco;
import com.rufino.climedapi.model.Medico;
import com.rufino.climedapi.service.MedicoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<Medico> cadastrar(@RequestBody MedicoDTO dto){
        return ResponseEntity.ok(medicoService.salvar(dto));
    }
}
