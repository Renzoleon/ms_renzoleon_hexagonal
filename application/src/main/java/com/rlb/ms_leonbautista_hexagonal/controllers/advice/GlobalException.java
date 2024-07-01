package com.rlb.ms_leonbautista_hexagonal.controllers.advice;

import com.rlb.ms_leonbautista_hexagonal.controllers.personalizadas.EmpleadoException;
import com.rlb.ms_leonbautista_hexagonal.domain.aggregates.dto.EmpleadoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleException(Exception ex){
        return new ResponseEntity<>("Error del Servidor", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<String> manejandoNullPointer(NullPointerException ex){
        return new ResponseEntity<>("Hay un dato nulo", HttpStatus.CONFLICT);
    }

    @ExceptionHandler({IOException.class})
    public ResponseEntity<String> manejandoIOException(IOException ex){
        return new ResponseEntity<>("Ocurrió una IOException", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> manejandoRunTime(RuntimeException ex){
        return new ResponseEntity<>("Ocurrió una excepcion en tiempo de ejecucion", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({EmpleadoException.class})
    public ResponseEntity<String> manejandoEmpleadoException(EmpleadoException ex){
        return new ResponseEntity<>("Error en el empleado", HttpStatus.BAD_REQUEST);
    }


}
