package com.rlb.ms_leonbautista_hexagonal.infraestructure.adapters;

import com.rlb.ms_leonbautista_hexagonal.domain.aggregates.constants.Constants;
import com.rlb.ms_leonbautista_hexagonal.domain.aggregates.dto.EmpleadoDTO;
import com.rlb.ms_leonbautista_hexagonal.domain.aggregates.requests.RequestEmpleado;
import com.rlb.ms_leonbautista_hexagonal.domain.aggregates.responses.ResponseReniec;
import com.rlb.ms_leonbautista_hexagonal.domain.ports.out.EmpleadoServiceOut;
import com.rlb.ms_leonbautista_hexagonal.infraestructure.dao.EmpleadoRepository;
import com.rlb.ms_leonbautista_hexagonal.infraestructure.entities.EmpleadoEntity;
import com.rlb.ms_leonbautista_hexagonal.infraestructure.mappers.EmpleadoMapper;
import com.rlb.ms_leonbautista_hexagonal.infraestructure.rest.ClienteReniec;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoAdapter implements EmpleadoServiceOut {

    private final EmpleadoRepository empleadoRepository;
    private final ClienteReniec clienteReniec;
    private final EmpleadoMapper empleadoMapper;

    @Value("${token}")
    private String token;

    @Override
    public EmpleadoDTO crearEmpleadoOut(RequestEmpleado requestEmpleado) {
        EmpleadoEntity empleadoEntity = getEmpleadoEntity(requestEmpleado);
        return empleadoMapper.mapToDto(empleadoRepository.save(empleadoEntity));
    }

    @Override
    public EmpleadoDTO buscarEmpleadoPorDocumentoOut(String numDoc) {
        return empleadoMapper.mapToDto(empleadoRepository.findEmpleadoEntityByNumDoc(numDoc));
    }

    @Override
    public List<EmpleadoDTO> mostrarEmpleadosOut() {
        return empleadoMapper.mapToDto(empleadoRepository.findAll());
    }

    @Override
    public EmpleadoDTO actualizarEmpleadoOut(Long id, EmpleadoDTO empleadoDTO) {
        EmpleadoEntity empleadoEntity1 = empleadoRepository.findById(id).orElse(null);
        EmpleadoDTO empleadoDTO1 = empleadoMapper.mapToDto(empleadoEntity1);
        empleadoDTO1.setNumDoc(empleadoDTO.getNumDoc());
        empleadoDTO1.setDateUdpate(getTime());
        empleadoDTO1.setUsuaUpdate(Constants.USU_ADMIN);
        empleadoRepository.save(empleadoMapper.mapToEntity(empleadoDTO1));
        return empleadoDTO1;
    }

    @Override
    public EmpleadoDTO eliminarEmpleadoOut(Long id) {
        EmpleadoEntity empleadoEntity = empleadoRepository.findById(id).orElse(null);
        empleadoEntity.setEstado(Constants.ESTADO_INACTIVO);
        empleadoEntity.setDateDelete(getTime());
        empleadoEntity.setUsuaDelete(Constants.USU_ADMIN);
        empleadoRepository.save(empleadoEntity);
        return empleadoMapper.mapToDto(empleadoEntity);
    }


    private EmpleadoEntity getEmpleadoEntity(RequestEmpleado requestEmpleado){
        ResponseReniec responseReniec = getExec(requestEmpleado.getNumDoc());
        EmpleadoEntity empleadoEntity = new EmpleadoEntity();
        empleadoEntity.setNumDoc(responseReniec.getNumeroDocumento());
        empleadoEntity.setNombre(responseReniec.getNombres());
        empleadoEntity.setApellido(responseReniec.getApellidoPaterno() +" "+responseReniec.getApellidoMaterno());
        empleadoEntity.setTipoDoc(responseReniec.getTipoDocumento());
        empleadoEntity.setEdad(29);
        empleadoEntity.setCargo("Programador");
        empleadoEntity.setTelefono("2811303");
        empleadoEntity.setCorreo("renzoleonb95@gmail.com");
        empleadoEntity.setDireccion("Av. Siempre viva 246");
        empleadoEntity.setDepartamento("Lima");
        empleadoEntity.setSalario(1500.00);
        empleadoEntity.setEstado(Constants.ESTADO_ACTIVO);
        empleadoEntity.setUsuaCrea(Constants.USU_ADMIN);
        empleadoEntity.setDateCrea(getTime());
        return empleadoEntity;
    }

    private Timestamp getTime(){
        long current = System.currentTimeMillis();
        return new Timestamp(current);
    }

    private ResponseReniec getExec(String numero){
        String head = "Bearer "+token;
        ResponseReniec responseReniec = clienteReniec.getInfoReniec(numero,head);
        return responseReniec;
    }
}
