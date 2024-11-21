package com.codinghshuttle.departmentmanagementsystem.controlles;

import com.codinghshuttle.departmentmanagementsystem.dto.DeparmentDTO;
import com.codinghshuttle.departmentmanagementsystem.entities.DepartmentEntity;
import com.codinghshuttle.departmentmanagementsystem.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DeparmentDTO> getDepartmentByID(@PathVariable Long departmentId){
        return ResponseEntity.ok(departmentService.getDepartmentByID(departmentId));
    }

    @GetMapping
    public ResponseEntity<List<DeparmentDTO>> getAllDepartment(){
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }

    @PostMapping
    public ResponseEntity<DeparmentDTO> createNewDepartment(@RequestBody @Valid DeparmentDTO deparmentDTO){
        return new ResponseEntity<>(departmentService.createNewDepartment(deparmentDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{departmentId}")
    public  ResponseEntity<DeparmentDTO> updateDepartmentById(@PathVariable Long departmentId,@RequestBody @Valid DeparmentDTO deparmentDTO){
        return ResponseEntity.ok(departmentService.updateDepartmentById(departmentId,deparmentDTO));
    }

    @PatchMapping("/{departmentId}")
    public  ResponseEntity<DeparmentDTO> updatePartialDepartmentById(@PathVariable Long departmentId,@RequestBody Map<String,Object> updates){
        return ResponseEntity.ok(departmentService.updatePartialDepartmentById(departmentId,updates));
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable Long departmentId){
        boolean gotDeleted = departmentService.deleteDepartmentById(departmentId);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

}
