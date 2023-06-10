package com.br.tef.clinicamed.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(EnderecoDTO dto) {
        this.logradouro = dto.logradouro();
        this.bairro = dto.bairro();
        this.cep = dto.cep();
        this.uf = dto.uf();
        this.cidade = dto.cidade();
        this.numero = dto.numero();
        this.complemento = dto.complemento();
    }

    public void atualizarDados(EnderecoDTO dto) {
        if (dto.logradouro() != null) {
            this.logradouro = dto.logradouro();
        }
        if (dto.bairro() != null) {
            this.bairro = dto.bairro();
        }
        if (dto.cep() != null) {
            this.cep = dto.cep();
        }
        if (dto.uf() != null) {
            this.uf = dto.uf();
        }
        if (dto.cidade() != null) {
            this.cidade = dto.cidade();
        }
        if (dto.numero() != null) {
            this.numero = dto.numero();
        }
        if (dto.complemento() != null) {
            this.complemento = dto.complemento();
        }
    }

}