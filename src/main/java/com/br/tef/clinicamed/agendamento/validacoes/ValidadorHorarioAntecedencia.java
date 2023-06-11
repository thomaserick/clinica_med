package com.br.tef.clinicamed.agendamento.validacoes;

import com.br.tef.clinicamed.agendamento.api.dto.AgendamentoConsultaDTO;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;


@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoConsulta {

    @Override
    public void validar(AgendamentoConsultaDTO dados) {
        var dataConsulta = dados.date();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidationException("Consulta deve ser agendada com antecedência mínima de 30 minutos");
        }
    }
}
