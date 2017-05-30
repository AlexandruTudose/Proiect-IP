package com.fiivirtualcatalog.modules.homework.service.impl;


import com.fiivirtualcatalog.modules.homework.DTO.CourseDTO;
import com.fiivirtualcatalog.modules.homework.DTO.transfromer.CourseTransformer;
import com.fiivirtualcatalog.modules.homework.model.Course;
import com.fiivirtualcatalog.modules.homework.repository.CourseRepository;
import com.fiivirtualcatalog.modules.homework.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by JACK on 5/8/2017.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseTransformer courseTransformer;

    //TRANSFORM PAGE(COURSE) TO PAGE(COURSE DTO)
    private Page<CourseDTO> convertToDTO(Page<Course> pageable) {
        return pageable.map(courseTransformer::toDTO);
    }

    //GET ALL COURSES
    @Override
    @Transactional(readOnly = true)
    public Page<CourseDTO> getCourses(Pageable pageable) {

        return convertToDTO(courseRepository.findAll(pageable));
    }

    //GET COURSE BY ID
    @Override
    @Transactional(readOnly = true)
    public CourseDTO getCourse(Integer id) {

        if (courseRepository.findOne(id) != null) {
            return courseTransformer.toDTO(courseRepository.findOne(id));
        }
        else {
            throw new RuntimeException(" Cursul cu id-ul "+ id +" nu exista in baza de date ");
        }
    }

    //CREATE COURSE
    @Override
    public void createCourse(CourseDTO courseDTO) {

        if (courseRepository.findByDenumire(courseDTO.getDenumire()) != null) {
            throw new RuntimeException(" Cursul cu numele "+ courseDTO.getDenumire() +" exista deja in baza de date");
        }
        else {
            courseRepository.save(courseTransformer.toModel(courseDTO));
        }
    }

    //UPDATE COURSE
    @Override
    public void updateCourse(Integer id, Course course) {

        if (courseRepository.findOne(id) == null) {
            throw new RuntimeException("Cursul cu id-ul " + id +" nu exista in baza de date");
        }
        else {
            course.setId(id);
            courseRepository.save(course);
        }
    }

    //DELETE COURSE
    @Override
    public void deleteCourse(Integer id) {
        courseRepository.delete(id);
    }
}
