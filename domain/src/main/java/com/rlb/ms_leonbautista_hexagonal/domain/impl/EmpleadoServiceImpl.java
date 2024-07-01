package com.rlb.ms_leonbautista_hexagonal.domain.impl;

import com.rlb.ms_leonbautista_hexagonal.domain.aggregates.dto.EmpleadoDTO;
import com.rlb.ms_leonbautista_hexagonal.domain.aggregates.requests.RequestEmpleado;
import com.rlb.ms_leonbautista_hexagonal.domain.ports.in.EmpleadoServiceIn;
import com.rlb.ms_leonbautista_hexagonal.domain.ports.out.EmpleadoServiceOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoServiceIn {

    private final EmpleadoServiceOut empleadoServiceOut;

    @Override
    public EmpleadoDTO crearEmpleadoIn(RequestEmpleado requestEmpleado) {
        return empleadoServiceOut.crearEmpleadoOut(requestEmpleado);
    }

    @Override
    public EmpleadoDTO buscarEmpleadoPorDocumentoIn(String numDoc) {
        return empleadoServiceOut.buscarEmpleadoPorDocumentoOut(numDoc);
    }

    @Override
    public List<EmpleadoDTO> mostrarEmpleadosIn() {
        return empleadoServiceOut.mostrarEmpleadosOut();
    }

    @Override
    public EmpleadoDTO actualizarEmpleadoIn(Long id, EmpleadoDTO empleadoDTO) {
        return empleadoServiceOut.actualizarEmpleadoOut(id,empleadoDTO);
    }

    @Override
    public EmpleadoDTO eliminarEmpleadoIn(Long id) {
        return empleadoServiceOut.eliminarEmpleadoOut(id);
    }
}
