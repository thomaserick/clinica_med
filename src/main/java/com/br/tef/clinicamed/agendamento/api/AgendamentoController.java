package com.br.tef.clinicamed.agendamento.api;


import com.br.tef.clinicamed.agendamento.api.dto.AgendamentoConsultaDTO;
import com.br.tef.clinicamed.agendamento.app.AgendamentoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.beans.Transient;

@RestController
@RequestMapping("/agendamento")
@AllArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    @Transient
    public ResponseEntity agendar(@RequestBody @Valid AgendamentoConsultaDTO dto, UriComponentsBuilder uriBuilder) {
        //   var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.ok().build();
    }


}
