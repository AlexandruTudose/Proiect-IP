package com.ip.project.controllers;

import com.ip.project.entities.Student;
import com.ip.project.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by JACK on 5/2/2017.
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public void createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public Page<Student> getStudents(Pageable pageable) {
        return studentService.getStudents(pageable);
    }

    @RequestMapping(value = "/students/{nr_matricol}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable("nr_matricol") Integer nr_matricol) {
        return studentService.getStudent(nr_matricol);
    }

    @RequestMapping(value = "/students/{nr_matricol}", method = RequestMethod.PUT)
    public void updateStudent(@PathVariable("nr_matricol") Integer nr_matricol, @RequestBody Student student) {
        studentService.updateStudent(nr_matricol,student);
    }

    @RequestMapping(value = "/students/{nr_matricol}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable("nr_matricol") Integer nr_matricol) {
        studentService.deleteStudent(nr_matricol);
    }
}
