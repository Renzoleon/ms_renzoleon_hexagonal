package com.rlb.ms_leonbautista_hexagonal.domain.aggregates.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseReniec {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoDocumento;
    private String numeroDocumento;
    private String digitoVerificador;
}
