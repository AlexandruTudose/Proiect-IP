package com.ip.project.controller;

import com.ip.project.DTO.TeacherDTO;
import com.ip.project.model.Teacher;
import com.ip.project.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by JACK on 5/9/2017.
 */
@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //GET ALL TEACHERS
    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public Page<TeacherDTO> getTeachers(Pageable pageable) {

        return teacherService.getTeachers(pageable);
    }

    //GET TEACHER BY ID
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET)
    public TeacherDTO getTeacher(@PathVariable("id") Integer id) {

        return teacherService.getTeacher(id);
    }

    //CREATE TEACHER
    @RequestMapping(value = "/teachers", method = RequestMethod.POST)
    public void createTeacher(@RequestBody TeacherDTO teacherDTO) {

        teacherService.createTeacher(teacherDTO);
    }

    //UPDATE TEACHER BY ID
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.PUT)
    public void updateTeacher(@PathVariable("id") Integer id, @RequestBody Teacher teacher) {

        teacherService.updateTeacher(id,teacher);
    }

    //DELETE TEACHER BY ID
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.DELETE)
    public void deleteTeacher(@PathVariable("id") Integer id) {

        teacherService.deleteTeacher(id);
    }
}
