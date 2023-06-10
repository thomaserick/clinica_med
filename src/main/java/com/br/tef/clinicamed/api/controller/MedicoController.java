package com.br.tef.clinicamed.api.controller;


import com.br.tef.clinicamed.api.medico.ListaMedicoDTO;
import com.br.tef.clinicamed.api.medico.Medico;
import com.br.tef.clinicamed.api.medico.MedicoDTO;
import com.br.tef.clinicamed.api.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.Transient;
import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {


    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transient
    public void insert(@RequestBody @Valid MedicoDTO medico) {

        medicoRepository.save(new Medico(medico));

    }

    @GetMapping
    public List<ListaMedicoDTO> getAll() {
        return medicoRepository.findAll().stream().map(ListaMedicoDTO::new).toList();
    }

}
