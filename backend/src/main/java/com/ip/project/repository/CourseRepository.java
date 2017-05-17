package com.ip.project.repository;

import com.ip.project.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by JACK on 5/8/2017.
 */
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findByDenumire(String denumire);
}
