package com.rufino.climedapi.repository;

import com.rufino.climedapi.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
    Page<Paciente> findAllByAtivoTrue(Pageable pageable);
    Optional<Paciente> findByIdAndAtivoTrue(Long id);
}
