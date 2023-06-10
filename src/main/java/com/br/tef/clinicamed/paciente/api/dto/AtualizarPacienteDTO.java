package com.br.tef.clinicamed.paciente.api.dto;

import com.br.tef.clinicamed.endereco.api.dto.EnderecoDTO;
import jakarta.validation.constraints.NotNull;

public record AtualizarPacienteDTO(@NotNull
                                   Long id,
                                   String nome,
                                   String telefone,
                                   EnderecoDTO endereco) {
}

