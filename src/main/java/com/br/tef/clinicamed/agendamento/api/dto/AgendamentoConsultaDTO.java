package com.br.tef.clinicamed.agendamento.api.dto;

import com.br.tef.clinicamed.medico.domain.enums.Especialidade;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoConsultaDTO(Long medicoId,
                                     @NotNull
                                     Long pacienteId,

                                     @NotNull
                                     @NotNull(message = "{especialidade.obrigatoria}")
                                     Especialidade especialidade,
                                     @NotNull
                                     @Future
                                     @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                     LocalDateTime date) {
}
