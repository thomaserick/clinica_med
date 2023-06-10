package com.br.tef.clinicamed.paciente.api;


import com.br.tef.clinicamed.medico.api.dto.AtualizarMedicoDTO;
import com.br.tef.clinicamed.medico.api.dto.ListaMedicoDTO;
import com.br.tef.clinicamed.medico.api.dto.MedicoDTO;
import com.br.tef.clinicamed.medico.domain.Medico;
import com.br.tef.clinicamed.medico.domain.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.beans.Transient;

@RestController
@RequestMapping("medicos")
public class MedicoController {


    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transient
    public ResponseEntity insert(@RequestBody @Valid MedicoDTO dto, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(dto);
        medicoRepository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarMedicoDTO dto) {
        var medico = medicoRepository.getReferenceById(dto.id());
        medico.atualizarDados(dto);
        medicoRepository.save(medico);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.delete();
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity<Slice<ListaMedicoDTO>> getAll(Pageable pageable) {
        var page = medicoRepository.findAllByAtivoTrue(pageable).map(ListaMedicoDTO::new);
        return ResponseEntity.ok(page);
    }


}
