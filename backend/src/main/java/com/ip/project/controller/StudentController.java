package com.ip.project.controller;

import com.ip.project.DTO.StudentDTO;
import com.ip.project.model.Student;
import com.ip.project.service.StudentService;
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

    //GET ALL STUDENTS
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public Page<StudentDTO> getStudents(Pageable pageable) {

        return studentService.getStudents(pageable);
    }

    //GET STUDENT BY ID
    @RequestMapping(value = "/students/{nr_matricol}", method = RequestMethod.GET)
    public StudentDTO getStudent(@PathVariable("nr_matricol") Integer nr_matricol) {

        return studentService.getStudent(nr_matricol);
    }

    //CREATE STUDENT
    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public void createStudent(@RequestBody StudentDTO studentDTO) {

        studentService.createStudent(studentDTO);
    }

    //UPDATE STUDENT BY ID
    @RequestMapping(value = "/students/{nr_matricol}", method = RequestMethod.PUT)
    public void updateStudent(@PathVariable("nr_matricol") Integer nr_matricol, @RequestBody Student student) {

        studentService.updateStudent(nr_matricol,student);
    }

    //DELETE STUDENT BY ID
    @RequestMapping(value = "/students/{nr_matricol}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable("nr_matricol") Integer nr_matricol) {

        studentService.deleteStudent(nr_matricol);
    }
}
