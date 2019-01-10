package com.longdk.studentstudycase;

import com.longdk.studentstudycase.service.DepartmentService;
import com.longdk.studentstudycase.service.StudentService;
import com.longdk.studentstudycase.service.impl.DepartmentServiceImpl;
import com.longdk.studentstudycase.service.impl.StudentServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentStudycaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentStudycaseApplication.class, args);
	}

	@Bean
	public StudentService studentService(){
		return new StudentServiceImpl();
	}

	@Bean
	public DepartmentService departmentService(){
		return new DepartmentServiceImpl();
	}
}

