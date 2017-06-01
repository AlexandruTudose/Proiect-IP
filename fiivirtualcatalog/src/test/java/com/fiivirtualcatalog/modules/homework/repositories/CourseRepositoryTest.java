package com.fiivirtualcatalog.modules.homework.repositories;

import com.fiivirtualcatalog.FiiVirtualCatalogApplication;
import com.fiivirtualcatalog.modules.homework.model.Course;
import com.fiivirtualcatalog.modules.homework.repository.CourseRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FiiVirtualCatalogApplication.class)
@Transactional
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    private Course course;

    @Before
    public void setup(){


        course = new Course();

        course.setAn(5);
        course.setCredite(100);
        course.setDenumire("VladCourse");
        course.setId(5);

    }

    @Test
    public void repositorySaveTest(){


        //Arrange + Act
        Course newCourse = repository.save(course);

        //Assert
        assertEquals(newCourse.getAn(),course.getAn());
        assertEquals(newCourse.getCredite(),course.getCredite());
        assertEquals(newCourse.getDenumire(),course.getDenumire());
        assertEquals(newCourse.getId(),course.getId());
    }

    @Test
    public void repositoryFindTest(){

        //Arrange + Act
        Course newCourse = repository.findByDenumire("SGBD");

        //Assert
        assertNotNull(newCourse);

    }


}
