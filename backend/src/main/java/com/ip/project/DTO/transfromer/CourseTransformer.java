package com.ip.project.DTO.transfromer;

import com.ip.project.DTO.CourseDTO;
import com.ip.project.model.Course;
import org.springframework.stereotype.Component;

/**
 * Created by JACK on 5/13/2017.
 */
@Component
public class CourseTransformer implements Transformer<Course, CourseDTO> {

    @Override
    public Course toModel(CourseDTO object) {
        Course course = new Course();
        course.setId(object.getId());
        course.setDenumire(object.getDenumire());
        course.setAn(object.getAn());
        course.setCredite(object.getCredite());

        return course;
    }

    @Override
    public CourseDTO toDTO(Course object) {
        return new CourseDTO(
                object.getId(),
                object.getDenumire(),
                object.getAn(),
                object.getCredite());
    }
}
