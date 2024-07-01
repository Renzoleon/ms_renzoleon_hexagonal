package com.rlb.ms_leonbautista_hexagonal.domain.ports.out;

import com.rlb.ms_leonbautista_hexagonal.domain.aggregates.dto.EmpleadoDTO;
import com.rlb.ms_leonbautista_hexagonal.domain.aggregates.requests.RequestEmpleado;

import java.util.List;

public interface EmpleadoServiceOut {

    EmpleadoDTO crearEmpleadoOut(RequestEmpleado requestEmpleado);
    EmpleadoDTO buscarEmpleadoPorDocumentoOut(String numDoc);
    List<EmpleadoDTO> mostrarEmpleadosOut();
    EmpleadoDTO actualizarEmpleadoOut(Long id, EmpleadoDTO empleadoDTO);
    EmpleadoDTO eliminarEmpleadoOut(Long id);
}
