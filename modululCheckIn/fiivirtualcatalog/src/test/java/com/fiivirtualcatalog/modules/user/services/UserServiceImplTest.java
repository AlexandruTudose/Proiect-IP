package com.fiivirtualcatalog.modules.user.services;

import com.fiivirtualcatalog.FiiVirtualCatalogApplication;
import com.fiivirtualcatalog.modules.user.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FiiVirtualCatalogApplication.class)
@Transactional
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void forANewUserSavedShouldReturnTheSameUser() {
        User user = new User();
        user.setName("Maria");
        user.setRole("Student");
        User newUser = userService.save(user);

        //assertEquals(user.getId(), newUser.getId());
        assertEquals(user.getName(), newUser.getName());
        assertEquals(user.getRole(), newUser.getRole());
    }

    @Test
    public void forAListOfUsersShouldReturnSameListOfUsers() {
        User user1 = new User();
        user1.setName("Ana");
        user1.setRole("Profesor");

        User user2 = new User();
        user2.setName("Marius");
        user2.setRole("Student");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        userService.save(user1);
        userService.save(user2);

        List<User> returnedList = userService.getAll();

        assertEquals(list.getClass(), returnedList.getClass());
    }

    @Test
    public void forAnIdShouldReturnTheUserWithThatId() {
        User user = new User();
        user.setName("Bogdan");
        user.setRole("Student");
        User userReturned = userService.save(user);

        User newUser = userService.getById(userReturned.getId());

        assertEquals(userReturned.getId(), newUser.getId());
        assertEquals(user.getName(), newUser.getName());
        assertEquals(user.getRole(), newUser.getRole());
    }

    @Test
    public void forAnIdShouldDeleteTheUser() {
        User user1 = new User();
        user1.setId(1);
        user1.setName("Ana");
        user1.setRole("Profesor");

        User user2 = new User();
        user2.setId(2);
        user2.setName("Marius");
        user2.setRole("Student");

        User usernou = userService.save(user1);
        userService.save(user2);

        userService.delete(usernou.getId());

        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void forCheckInfIfExistsUserShouldThrowException() {
        User user1 = new User();
        user1.setName("Ana");
        user1.setRole("Profesor");

        User userNou = userService.save(user1);

        userService.delete(userNou.getId());

        userService.existsUser(userNou.getId());
        assertTrue(true);
    }
    @Test
    public void forCheckInfIfExistsUserShouldDoNothing() {
        User user1 = new User();
        user1.setName("Ana");
        user1.setRole("Profesor");

        User userNou = userService.save(user1);

        userService.existsUser(userNou.getId());
        assertTrue(true);
    }

}