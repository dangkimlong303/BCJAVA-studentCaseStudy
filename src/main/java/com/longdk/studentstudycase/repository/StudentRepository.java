package com.longdk.studentstudycase.repository;

import com.longdk.studentstudycase.models.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student,Long> {
}
