package com.longdk.studentstudycase.service;

import com.longdk.studentstudycase.models.Department;

public interface DepartmentService {

    Iterable<Department> findAll();

    Department findById(Long id);
}
