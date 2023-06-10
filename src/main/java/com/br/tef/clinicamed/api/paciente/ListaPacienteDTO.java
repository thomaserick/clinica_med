package com.br.tef.clinicamed.api.paciente;

public record ListaPacienteDTO(Long id, String nome, String email, String cpf) {

    public ListaPacienteDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }

}
