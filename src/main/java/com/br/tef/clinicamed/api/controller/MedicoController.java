package com.br.tef.clinicamed.api.controller;


import com.br.tef.clinicamed.api.medico.AtualizarMedicoDTO;
import com.br.tef.clinicamed.api.medico.ListaMedicoDTO;
import com.br.tef.clinicamed.api.medico.Medico;
import com.br.tef.clinicamed.api.medico.MedicoDTO;
import com.br.tef.clinicamed.api.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.Transient;

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

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarMedicoDTO dto) {
        var medico = medicoRepository.getReferenceById(dto.id());
        medico.atualizarDados(dto);
        medicoRepository.save(medico);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void atualizar(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.delete();
        medicoRepository.save(medico);
    }


    @GetMapping
    public Slice<ListaMedicoDTO> getAll(Pageable pageable) {
        return medicoRepository.findAllByAtivoTrue(pageable).map(ListaMedicoDTO::new);
    }


}
