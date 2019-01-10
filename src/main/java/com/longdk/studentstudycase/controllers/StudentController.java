package com.longdk.studentstudycase.controllers;

import com.longdk.studentstudycase.models.Department;
import com.longdk.studentstudycase.models.Student;
import com.longdk.studentstudycase.service.DepartmentService;
import com.longdk.studentstudycase.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private DepartmentService departmentService;

    @ModelAttribute("department")
    public Iterable<Department> departments(){
        return departmentService.findAll();
    }

    @GetMapping("student-create")
    public ModelAndView showCreateStudentForm(){
        return new ModelAndView("student/create","student",new Student());
    }

    @PostMapping("studentcreate")
    public ModelAndView createStudent(@ModelAttribute("student") Student student){
        studentService.save(student);
        return new ModelAndView("student/create","message","Create student success!!");
    }
    @GetMapping("student-list")
    public ModelAndView showListStudentForm(@PageableDefault(size = 4)Pageable pageable){
        Page<Student> students = studentService.findAll(pageable);
        return new ModelAndView("student/list","students",students);
    }
    @GetMapping("student-edit/{id}")
    public ModelAndView showEditStudentForm(@PathVariable Long id){
        Student student = studentService.findById(id);
        return new ModelAndView("student/edit","student",student);
    }
    @PostMapping("studentedit")
    public ModelAndView editStudent(@ModelAttribute("student") Student student){
        studentService.save(student);
        return new ModelAndView("student/edit","mess","Student edit success!");
    }
    @GetMapping("student-delete/{id}")
    public ModelAndView showDeleteStudentForm(@PathVariable Long id){
        Student student = studentService.findById(id);
        return new ModelAndView("student/delete","student",student);
    }

    @PostMapping("studentdelete")
    public String deleteStudent(@ModelAttribute("student")Student student){
        studentService.remove(student.getId());
        return "redirect:student-list";
    }
}
