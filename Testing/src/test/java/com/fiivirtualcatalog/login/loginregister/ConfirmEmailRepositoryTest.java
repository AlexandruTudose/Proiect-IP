package com.fiivirtualcatalog.login.loginregister;

import com.fiivirtualcatalog.login.FiiVirtualCatalogApplication;
import com.fiivirtualcatalog.login.models.ConfirmEmail;
import com.fiivirtualcatalog.login.models.User;
import com.fiivirtualcatalog.login.repositories.ConfirmEmailRepository;
import com.fiivirtualcatalog.login.repositories.UserRepository;
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
    public void repositoryTest(){

        ConfirmEmail newEmail = emailRepository.save(email);

        assertEquals(newEmail.getCode(),email.getCode());
        assertEquals(newEmail.getEmail(),email.getEmail());

    }
}
