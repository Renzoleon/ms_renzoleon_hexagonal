package com.rlb.ms_leonbautista_hexagonal.infraestructure.mappers;

import com.rlb.ms_leonbautista_hexagonal.domain.aggregates.dto.EmpleadoDTO;
import com.rlb.ms_leonbautista_hexagonal.infraestructure.entities.EmpleadoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public EmpleadoDTO mapToDto(EmpleadoEntity empleadoEntity){
        return modelMapper.map(empleadoEntity, EmpleadoDTO.class);
    }

    public EmpleadoEntity mapToEntity(EmpleadoDTO empleadoDTO){
        return modelMapper.map(empleadoDTO, EmpleadoEntity.class);
    }

    public List<EmpleadoDTO> mapToDto(List<EmpleadoEntity> empleadoEntityList){
        List<EmpleadoDTO> empleadoDTOList = new ArrayList<>();
        for(EmpleadoEntity empleadoEntity : empleadoEntityList){
            empleadoDTOList.add(mapToDto(empleadoEntity));
        }
        return empleadoDTOList;
    }

    public List<EmpleadoEntity> mapToEntity(List<EmpleadoDTO> empleadoDTOList){
        List<EmpleadoEntity> empleadoEntityList = new ArrayList<>();
        for(EmpleadoDTO empleadoDTO : empleadoDTOList){
            empleadoEntityList.add(mapToEntity(empleadoDTO));
        }
        return empleadoEntityList;
    }
}
