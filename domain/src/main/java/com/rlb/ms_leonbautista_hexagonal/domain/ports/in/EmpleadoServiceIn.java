package com.rlb.ms_leonbautista_hexagonal.domain.ports.in;

import com.rlb.ms_leonbautista_hexagonal.domain.aggregates.dto.EmpleadoDTO;
import com.rlb.ms_leonbautista_hexagonal.domain.aggregates.requests.RequestEmpleado;

import java.util.List;

public interface EmpleadoServiceIn {

    EmpleadoDTO crearEmpleadoIn(RequestEmpleado requestEmpleado);
    EmpleadoDTO buscarEmpleadoPorDocumentoIn(String numDoc);
    List<EmpleadoDTO> mostrarEmpleadosIn();
    EmpleadoDTO actualizarEmpleadoIn(Long id, EmpleadoDTO empleadoDTO);
    EmpleadoDTO eliminarEmpleadoIn(Long id);
}
