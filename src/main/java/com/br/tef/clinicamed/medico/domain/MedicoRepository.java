package com.br.tef.clinicamed.medico.domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Slice<Medico> findAllByAtivoTrue(Pageable paginacao);
}
