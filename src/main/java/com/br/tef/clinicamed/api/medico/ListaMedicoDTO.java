package com.br.tef.clinicamed.api.medico;

import com.br.tef.clinicamed.api.medico.enums.Especialidade;

public record ListaMedicoDTO(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public ListaMedicoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
