package com.rufino.climedapi.controller;

import com.rufino.climedapi.dto.MedicoAtualizarDTO;
import com.rufino.climedapi.dto.MedicoDTO;
import com.rufino.climedapi.dto.MedicoReduzidoDTO;
import com.rufino.climedapi.model.Medico;
import com.rufino.climedapi.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Page<MedicoReduzidoDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return medicoService.listar(pageable);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void > atualizar(@RequestBody MedicoAtualizarDTO dto, @PathVariable Long id){
        Medico medico = medicoService.atualizar(dto, id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        medicoService.deletar(id);
        return ResponseEntity.ok().body("Médico excluído com sucesso.");
    }
}
