package com.br.tef.clinicamed.medico.api.dto;

import com.br.tef.clinicamed.endereco.api.dto.EnderecoDTO;
import jakarta.validation.constraints.NotNull;

public record AtualizarMedicoDTO(@NotNull
                                 Long id,
                                 String nome,
                                 String telefone,
                                 EnderecoDTO endereco) {
}
