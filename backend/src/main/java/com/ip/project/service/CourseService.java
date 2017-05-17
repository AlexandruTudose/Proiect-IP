package com.ip.project.service;

import com.ip.project.DTO.CourseDTO;
import com.ip.project.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by JACK on 5/8/2017.
 */
public interface CourseService {

    Page<CourseDTO> getCourses(Pageable pageable);
    CourseDTO getCourse(Integer id);

    void createCourse(CourseDTO courseDTO);
    void updateCourse(Integer id, Course course);
    void deleteCourse(Integer id);
}
