package com.br.tef.clinicamed.medico.domain;

import com.br.tef.clinicamed.medico.domain.enums.Especialidade;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Slice<Medico> findAllByAtivoTrue(Pageable paginacao);


    @Query("""
            select m from Medico m
            where
            m.ativo = 1
            and
            m.especialidade = :especialidade
            and
            m.id not in(
                    select ag.medico.id from Agendamentos ag
                    where
                    ag.data = :data
            )
            order by rand()
            limit 1
            """)
    Medico escolherMedicoLivreNaData(Especialidade especialidade, LocalDateTime date);
}
