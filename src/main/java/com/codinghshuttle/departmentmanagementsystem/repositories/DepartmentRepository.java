package com.codinghshuttle.departmentmanagementsystem.repositories;

import com.codinghshuttle.departmentmanagementsystem.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
}
