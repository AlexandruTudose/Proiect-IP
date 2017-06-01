package com.fiivirtualcatalog.modules.homework.repositories;

import com.fiivirtualcatalog.FiiVirtualCatalogApplication;
import com.fiivirtualcatalog.modules.homework.model.Homework;
import com.fiivirtualcatalog.modules.homework.repository.HomeworkRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FiiVirtualCatalogApplication.class)
@Transactional
public class HomeworkRepositoryTest {

    @Autowired
    private HomeworkRepository homeworkRepository;

    private Homework homework;

    @Before
    public void setup(){

        Date data = new Date();

        data.getTime();

        homework = new Homework();
        homework.setId(5);
        homework.setId_student(3);
        homework.setFisier("Vlad'sHomework");
        homework.setData_predare(data);
        homework.setId_curs(2);
        homework.setId_nota(5);
        homework.setTip_tema("IP");

    }

    @Test
    public void testSaveRepository(){

        //Arrange + Act
        Homework savedHomework = homeworkRepository.save(homework);


        //Assert
        assertEquals(savedHomework.getData_predare(),homework.getData_predare());
        assertEquals(savedHomework.getId(),homework.getId());
        assertEquals(savedHomework.getFisier(),homework.getFisier());
    }

    @Test
    public void testGetRepository(){

        //Arrange + Act
        Homework savedHomework = homeworkRepository.getOne(5);

        //Assert
        assertNotNull(savedHomework);

    }

    @Test
    public void testGetMaxRepository(){

        int maxi = homeworkRepository.getMaxId();

        assertNotNull(maxi);
    }
}
