package com.br.tef.clinicamed.paciente.api;

import com.br.tef.clinicamed.paciente.api.dto.AtualizarPacienteDTO;
import com.br.tef.clinicamed.paciente.api.dto.ListaPacienteDTO;
import com.br.tef.clinicamed.paciente.api.dto.PacienteDTO;
import com.br.tef.clinicamed.paciente.domain.Paciente;
import com.br.tef.clinicamed.paciente.domain.PacienteRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void insert(@RequestBody @Valid PacienteDTO dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<ListaPacienteDTO> getAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable).map(ListaPacienteDTO::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid AtualizarPacienteDTO dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.delete();
    }


}
