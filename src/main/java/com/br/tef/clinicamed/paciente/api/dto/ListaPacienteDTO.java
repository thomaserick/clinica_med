package com.br.tef.clinicamed.paciente.api.dto;

import com.br.tef.clinicamed.paciente.domain.Paciente;

public record ListaPacienteDTO(Long id, String nome, String email, String cpf) {

    public ListaPacienteDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }

}
