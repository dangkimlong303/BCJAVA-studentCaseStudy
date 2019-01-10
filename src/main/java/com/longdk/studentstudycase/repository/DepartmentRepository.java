package com.longdk.studentstudycase.repository;

import com.longdk.studentstudycase.models.Department;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DepartmentRepository extends PagingAndSortingRepository<Department,Long> {
}
