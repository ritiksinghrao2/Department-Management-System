package com.codinghshuttle.departmentmanagementsystem.services;

import com.codinghshuttle.departmentmanagementsystem.dto.DeparmentDTO;
import com.codinghshuttle.departmentmanagementsystem.entities.DepartmentEntity;
import com.codinghshuttle.departmentmanagementsystem.exceptions.ResourceNotFoundException;
import com.codinghshuttle.departmentmanagementsystem.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public DeparmentDTO getDepartmentByID(Long departmentId) {
        existsDepartmentById(departmentId);
        return departmentRepository.findById(departmentId).map(departmentEntity -> modelMapper.map(departmentEntity,DeparmentDTO.class)).get();
    }

    public List<DeparmentDTO> getAllDepartment() {
        List<DepartmentEntity> departmentEntityList = departmentRepository.findAll();
        return departmentEntityList
                .stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity,DeparmentDTO.class))
                .collect(Collectors.toList());
    }

    public DeparmentDTO createNewDepartment(DeparmentDTO deparmentDTO) {
        DepartmentEntity saveToBeEntity = modelMapper.map(deparmentDTO,DepartmentEntity.class);
        return modelMapper.map(departmentRepository.save(saveToBeEntity),DeparmentDTO.class);
    }

    public DeparmentDTO updateDepartmentById(Long departmentId, DeparmentDTO deparmentDTO) {
        existsDepartmentById(departmentId);
        DepartmentEntity upateToBeEntity = modelMapper.map(deparmentDTO,DepartmentEntity.class);
        upateToBeEntity.setId(departmentId);
        return modelMapper.map(departmentRepository.save(upateToBeEntity),DeparmentDTO.class);
    }

    public DeparmentDTO updatePartialDepartmentById(Long departmentId, Map<String, Object> updates) {
        existsDepartmentById(departmentId);
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).get();
        updates.forEach((field,value)->{
            Field fieldToBeUpdated = ReflectionUtils.findFieldIgnoreCase(DepartmentEntity.class,field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,departmentEntity,value);
        });
        return modelMapper.map(departmentRepository.save(departmentEntity),DeparmentDTO.class);
    }

    public Boolean deleteDepartmentById(Long departmentId) {
        existsDepartmentById(departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }

    private void existsDepartmentById(Long departmentId){
        boolean exists = departmentRepository.existsById(departmentId);
        if(!exists) throw new ResourceNotFoundException("Department not found with id: "+departmentId);
    }
}
