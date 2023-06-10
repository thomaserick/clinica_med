package com.br.tef.clinicamed.api.medico;

import com.br.tef.clinicamed.api.endereco.EnderecoDTO;
import jakarta.validation.constraints.NotNull;

public record AtualizarMedicoDTO(@NotNull
                                 Long id,
                                 String nome,
                                 String telefone,
                                 EnderecoDTO endereco) {
}
