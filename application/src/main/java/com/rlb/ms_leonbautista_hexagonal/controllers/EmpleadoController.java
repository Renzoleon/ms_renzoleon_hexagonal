package com.rlb.ms_leonbautista_hexagonal.controllers;

import com.rlb.ms_leonbautista_hexagonal.controllers.personalizadas.EmpleadoException;
import com.rlb.ms_leonbautista_hexagonal.domain.aggregates.dto.EmpleadoDTO;
import com.rlb.ms_leonbautista_hexagonal.domain.aggregates.requests.RequestEmpleado;
import com.rlb.ms_leonbautista_hexagonal.domain.aggregates.responses.ResponseReniec;
import com.rlb.ms_leonbautista_hexagonal.domain.ports.in.EmpleadoServiceIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/empleado")
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoServiceIn empleadoServiceIn;

    @PostMapping("/crear")
    public ResponseEntity<EmpleadoDTO> registrar(@RequestBody RequestEmpleado empleado){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(empleadoServiceIn.crearEmpleadoIn(empleado));
    }
    @GetMapping("/{numDoc}")
    public ResponseEntity<EmpleadoDTO> buscarEmpleado(@PathVariable String numDoc) {
        EmpleadoDTO empleadoDTO = empleadoServiceIn.buscarEmpleadoPorDocumentoIn(numDoc);
        return ResponseEntity.ok(empleadoDTO);
        //throw new EmpleadoException("Empleado ya existe");


    }

    @GetMapping("/todos")
    public ResponseEntity<List<EmpleadoDTO>> buscarTodos(){
        List<EmpleadoDTO> lista = empleadoServiceIn.mostrarEmpleadosIn();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EmpleadoDTO> actualizar(@PathVariable Long id, @RequestBody EmpleadoDTO empleado){
        EmpleadoDTO empleadoDTO = empleadoServiceIn.actualizarEmpleadoIn(id,empleado);
        return ResponseEntity.ok(empleadoDTO);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<EmpleadoDTO> borrar(@PathVariable Long id){
         EmpleadoDTO empleadoDTO = empleadoServiceIn.eliminarEmpleadoIn(id);
         return ResponseEntity.ok(empleadoDTO);
    }

}
