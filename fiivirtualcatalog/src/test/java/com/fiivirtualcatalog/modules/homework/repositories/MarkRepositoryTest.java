package com.fiivirtualcatalog.modules.homework.repositories;

import com.fiivirtualcatalog.FiiVirtualCatalogApplication;
import com.fiivirtualcatalog.modules.homework.model.Mark;
import com.fiivirtualcatalog.modules.homework.repository.MarkRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FiiVirtualCatalogApplication.class)
@Transactional
public class MarkRepositoryTest {

    @Autowired
    private MarkRepository markRepository;

    private Mark mark;

    @Before
    public void setup(){

        Date data = new Date();

        data.setTime(data.getTime());

        mark = new Mark();
        mark.setValoare(5);
        mark.setId_profesor(5);
        mark.setId(5);
        mark.setData_notare(data);

    }

    @Test
    public void testSaveRepository(){

        //Act + Arrange
        Mark newMark = markRepository.save(mark);


        //Assert
        assertEquals(mark.getId(),newMark.getId());
        assertEquals(mark.getValoare(),newMark.getValoare());
        assertEquals(mark.getId_profesor(),newMark.getId_profesor());

    }

    @Test
    public void testGetRepository(){

        //Act + Arrange
        Mark newMark = markRepository.getOne(5);


        //Assert
        assertNotNull(newMark);
    }


}
