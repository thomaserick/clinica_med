package com.br.tef.clinicamed.api.paciente;

import com.br.tef.clinicamed.api.endereco.EnderecoDTO;
import jakarta.validation.constraints.NotNull;

public record AtualizarPacienteDTO(@NotNull
                                   Long id,
                                   String nome,
                                   String telefone,
                                   EnderecoDTO endereco) {
}

