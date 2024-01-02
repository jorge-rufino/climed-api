package com.rufino.climedapi.service;

import com.rufino.climedapi.dto.MedicoAtualizarDTO;
import com.rufino.climedapi.dto.MedicoDTO;
import com.rufino.climedapi.dto.MedicoReduzidoDTO;
import com.rufino.climedapi.exception.EmailDuplicadoException;
import com.rufino.climedapi.exception.EntidadeDuplicadaException;
import com.rufino.climedapi.exception.EntidadeNaoExisteException;
import com.rufino.climedapi.mapper.MedicoMapper;
import com.rufino.climedapi.model.Medico;
import com.rufino.climedapi.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

        if(repository.existsByEmail(dto.getEmail())){
            throw new EmailDuplicadoException("E-mail (" + dto.getEmail() + ") já está cadastrado no sistema.");
        }

        if(repository.existsByCrm(dto.getCrm())){
            throw new EntidadeDuplicadaException("Crm nº "+ dto.getCrm()+" já está cadastrado no sistema.");
        }

        Medico newMedico = medicoMapper.toMedicoEntity(dto);
        newMedico.setAtivo(true);

        return repository.save(newMedico);
    }

    public Page<MedicoReduzidoDTO> listar(Pageable pageable){
        return repository.findAllByAtivoTrue(pageable).map(medico -> medicoMapper.toReduzidoDto(medico));
    }

    public Medico buscarPorId(Long id){
        return repository.findByIdAndAtivoTrue(id).orElseThrow(() -> new EntidadeNaoExisteException("Médico de ID " + id + " não existe!"));
    }

    @Transactional
    public Medico atualizar(MedicoAtualizarDTO dto, Long id){
        Medico medico = buscarPorId(id);
        medicoMapper.updateMedico(dto, medico);

        return repository.save(medico);
    }

    @Transactional
    public void deletar(Long id){
        var medico = buscarPorId(id);
        medico.setAtivo(false);
    }
}
