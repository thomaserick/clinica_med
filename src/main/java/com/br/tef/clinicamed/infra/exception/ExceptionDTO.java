package com.br.tef.clinicamed.infra.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

public record ExceptionDTO(String status, String field, String message) {
    public ExceptionDTO(FieldError erro) {
        this(erro.getCode(), erro.getField(), erro.getDefaultMessage());
    }

    public ExceptionDTO(HttpStatus status, String message) {
        this(status.name(), StringUtils.EMPTY, message);
    }
}
