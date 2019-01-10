package com.longdk.studentstudycase.service.impl;

import com.longdk.studentstudycase.models.Department;
import com.longdk.studentstudycase.repository.DepartmentRepository;
import com.longdk.studentstudycase.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Iterable<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id).get();
    }
}
