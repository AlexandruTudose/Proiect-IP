package com.fiivirtualcatalog.modules.homework.service;


import com.fiivirtualcatalog.modules.homework.DTO.CourseDTO;
import com.fiivirtualcatalog.modules.homework.model.Course;
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
