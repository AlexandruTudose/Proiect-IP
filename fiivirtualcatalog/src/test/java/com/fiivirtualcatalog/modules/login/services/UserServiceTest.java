package com.fiivirtualcatalog.modules.login.services;

import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.repositories.UserRepository;
import com.fiivirtualcatalog.modules.user.services.UserServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Vladd on 10.05.2017.
 */
public class UserServiceTest {

    private static UserServiceImpl mockedUserService;
    private static User user1 = new User();
    private static User user2 = new User();

    @Mock
    private static UserRepository userRepository;


    @BeforeClass
    public static void setup(){

        mockedUserService = mock(UserServiceImpl.class);

        user1.setId(5);
        user1.setActive(true);
        user1.setLastName("Test1");
        user1.setFirstName("Test1");
        user1.setPassword("123123");
        user1.setRole(User.Role.student);
        user1.setEmail("test1@gmail.com");

        user2.setId(7);
        user2.setActive(true);
        user2.setLastName("Test2");
        user2.setFirstName("Test2");
        user2.setPassword("123123");
        user2.setRole(User.Role.student);
        user2.setEmail("test2@gmail.com");

        when(mockedUserService.save(user1)).thenReturn(user1);
        when(mockedUserService.save(user2)).thenReturn(user2);
        when(mockedUserService.findByEmail("test1@gmail.com")).thenReturn(user1);
        when(mockedUserService.findByEmail("test2@gmail.com")).thenReturn(user2);
        when(mockedUserService.getAll()).thenReturn(Arrays.asList(user1,user2));

    }

    @Test
    public void testgetAll(){

        List<User> getUsers = mockedUserService.getAll();
        assertEquals(2,getUsers.size());
        User testingUser = getUsers.get(0);
        assertEquals(5,testingUser.getId());
        assertEquals(true,testingUser.isActive());
        assertEquals("Test1",testingUser.getLastName());
        assertEquals("Test1",testingUser.getFirstName());
        assertEquals("123123",testingUser.getPassword());
        assertEquals(User.Role.student,testingUser.getRole());
        assertEquals("test1@gmail.com",testingUser.getEmail());


    }

    @Test
    public void testSave(){

        User testing2=mockedUserService.save(user2);
        assertEquals(7,testing2.getId());
        assertEquals(true,testing2.isActive());
        assertEquals("Test2",testing2.getLastName());
        assertEquals("Test2",testing2.getFirstName());
        assertEquals("123123",testing2.getPassword());
        assertEquals(User.Role.student,testing2.getRole());
        assertEquals("test2@gmail.com",testing2.getEmail());

    }

    @Test
    public void testFindEmail(){
        String email = "test1@gmail.com";

        User testing3=mockedUserService.findByEmail(email);

        assertNotNull(testing3);
        assertEquals(5,testing3.getId());
        assertEquals(true,testing3.isActive());
        assertEquals("Test1",testing3.getLastName());
        assertEquals("Test1",testing3.getFirstName());
        assertEquals("123123",testing3.getPassword());
        assertEquals(User.Role.student,testing3.getRole());
        assertEquals("test1@gmail.com",testing3.getEmail());


    }
}
