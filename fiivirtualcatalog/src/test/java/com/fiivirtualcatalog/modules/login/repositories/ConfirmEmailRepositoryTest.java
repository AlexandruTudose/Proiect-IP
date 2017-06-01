package com.fiivirtualcatalog.modules.login.repositories;

import com.fiivirtualcatalog.FiiVirtualCatalogApplication;
import com.fiivirtualcatalog.modules.login.models.ConfirmEmail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vladd on 16.05.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FiiVirtualCatalogApplication.class)
@Transactional
public class ConfirmEmailRepositoryTest {

    @Autowired
    private ConfirmEmailRepository emailRepository;

    private ConfirmEmail email;

    @Before
    public void setup(){
        email = new ConfirmEmail();
        email.setEmail("scurtuvlad@gmail.com");
        email.setCode("123456");
        email.setId(5);

    }
    @Test
    public void repositorySaveTest(){

        ConfirmEmail newEmail = emailRepository.save(email);

        assertEquals(newEmail.getCode(),email.getCode());
        assertEquals(newEmail.getEmail(),email.getEmail());

    }

}