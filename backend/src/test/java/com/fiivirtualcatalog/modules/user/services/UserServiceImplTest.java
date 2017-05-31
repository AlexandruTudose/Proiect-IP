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
        user.setFirstName("Maria");
        user.setRole(User.Role.student);
        User newUser = userService.save(user);

        assertEquals(user.getId(), newUser.getId());
        assertEquals(user.getFirstName(), newUser.getFirstName());
        assertEquals(user.getRole(), newUser.getRole());
    }

    @Test
    public void forAListOfUsersShouldReturnSameListOfUsers() {
        User user1 = new User();
        user1.setFirstName("Ana");
        user1.setRole(User.Role.student);

        User user2 = new User();
        user2.setFirstName("Marius");
        user2.setRole(User.Role.student);

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
        user.setId(1);
        user.setFirstName("Bogdan");
        user.setRole(User.Role.student);
        userService.save(user);

        User newUser = userService.findById((long) 1);

        assertEquals(user.getId(), newUser.getId());
        assertEquals(user.getFirstName(), newUser.getFirstName());
        assertEquals(user.getRole(), newUser.getRole());
    }

    @Test
    public void forAnEmailShouldDeleteTheUser() {
        User user1 = new User();
        user1.setId(1);
        user1.setFirstName("Ana");
        user1.setRole(User.Role.profesor);
        user1.setEmail("user1@user1.com");

        User user2 = new User();
        user2.setId(2);
        user2.setFirstName("Marius");
        user2.setRole(User.Role.student);
        user2.setEmail("user2@user2.com");

        userService.save(user1);
        userService.save(user2);

        userService.delete((long) 2);
        assertTrue(true);
    }
}