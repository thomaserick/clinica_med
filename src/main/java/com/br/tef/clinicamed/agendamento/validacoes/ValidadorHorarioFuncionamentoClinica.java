package com.br.tef.clinicamed.agendamento.validacoes;

import com.br.tef.clinicamed.agendamento.api.dto.AgendamentoConsultaDTO;
import jakarta.validation.ValidationException;

import java.time.DayOfWeek;

public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoConsulta {


    @Override
    public void validar(AgendamentoConsultaDTO dto) {
        var dataConsulta = dto.date();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = dataConsulta.getHour() < 7;
        var depoisDoEcerramento = dataConsulta.getHour() > 18;

        if (domingo || antesDaAbertura || depoisDoEcerramento) {
            throw new ValidationException("Consulta fora do horário de funcionamento da clínica");
        }

    }
}
