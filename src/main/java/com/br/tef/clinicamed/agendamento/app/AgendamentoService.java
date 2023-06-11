package com.br.tef.clinicamed.agendamento.app;


import com.br.tef.clinicamed.agendamento.api.dto.AgendamentoConsultaDTO;
import com.br.tef.clinicamed.agendamento.domain.Agendamento;
import com.br.tef.clinicamed.agendamento.domain.AgendamentoRepository;
import com.br.tef.clinicamed.agendamento.validacoes.ValidadorAgendamentoConsulta;
import com.br.tef.clinicamed.medico.domain.Medico;
import com.br.tef.clinicamed.medico.domain.MedicoRepository;
import com.br.tef.clinicamed.paciente.domain.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AgendamentoService {


    private final AgendamentoRepository agendamentoRepository;

    private final MedicoRepository medicoRepository;

    private final PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoConsulta> validadores;

    public void agendar(AgendamentoConsultaDTO dto) {

        var medico = medicoRepository.findById(dto.medicoId()).get();
        var paciente = pacienteRepository.findById(dto.pacienteId()).get();

        validadores.forEach(v -> v.validar(dto));

        var consulta = new Agendamento(null, medico, paciente, dto.date());
        agendamentoRepository.save(consulta);

    }

    private Medico escolherMedico(AgendamentoConsultaDTO dto) {

        return medicoRepository.escolherMedicoLivreNaData(dto.especialidade(), dto.date());

    }

}
