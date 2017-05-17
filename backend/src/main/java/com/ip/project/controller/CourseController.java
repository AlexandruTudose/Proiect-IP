package com.ip.project.controller;

import com.ip.project.DTO.CourseDTO;
import com.ip.project.model.Course;
import com.ip.project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by JACK on 5/8/2017.
 */
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    //GET ALL COURSES
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public Page<CourseDTO> getCourses(Pageable pageable) {
        return courseService.getCourses(pageable);
    }

    //GET COURSE BY ID
    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
    public CourseDTO getCourse(@PathVariable("id") Integer id) {
        return courseService.getCourse(id);
    }

    //CREATE COURSE
    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    public void createCourse(@RequestBody CourseDTO courseDTO) {
        courseService.createCourse(courseDTO);
    }

    //UPDATE COURSE BY ID
    @RequestMapping(value = "/courses/{id}", method = RequestMethod.PUT)
    public void updateCourse(@PathVariable("id") Integer id, @RequestBody Course course) {
        courseService.updateCourse(id,course);
    }

    //DELETE COURSE BY ID
    @RequestMapping(value = "/courses/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable("id") Integer id) {
        courseService.deleteCourse(id);
    }
}
