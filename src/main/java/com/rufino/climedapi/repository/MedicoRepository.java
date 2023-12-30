package com.rufino.climedapi.repository;

import com.rufino.climedapi.model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    boolean existsByEmail(String email);
    boolean existsByCrm(String crm);
    Page<Medico> findAllByAtivoTrue(Pageable pageable);
}

