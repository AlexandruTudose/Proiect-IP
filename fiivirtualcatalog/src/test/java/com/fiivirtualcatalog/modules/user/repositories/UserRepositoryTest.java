package com.fiivirtualcatalog.modules.user.repositories;


import com.fiivirtualcatalog.FiiVirtualCatalogApplication;
import com.fiivirtualcatalog.modules.user.models.User;
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
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @Before
    public void setup(){
        user = new User();
        user.setId(5);
        user.setActive(true);
        user.setEmail("scurtuvlad22@gmail.com");
        user.setLastName("Scurtu");
        user.setFirstName("Vlad");
        user.setPassword("1234567");
        user.setRole(User.Role.student);

    }
    @Test
    public void repositoryTest(){


        User newUser = userRepository.save(user);

        assertEquals(user.getFirstName(),newUser.getFirstName());
        assertEquals(user.getEmail(),newUser.getEmail());
        assertEquals(user.getLastName(),newUser.getLastName());

    }
}

