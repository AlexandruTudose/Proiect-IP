package com.fiivirtualcatalog.modules.user.services;


import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static sun.nio.cs.Surrogate.is;

/**
 * Created by Vladd on 16.05.2017.
 */
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Mock
    private UserRepository userRepository;

    @Mock
    private User user;

    @Mock
    private User user2;

    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void shouldReturnUser_whenFindByEmailIsCalled(){

        //Arrange
        when(userRepository.findByEmail("scurtuvlad@gmail.com")).thenReturn(user);

        //Act
        User foundUser = userServiceImpl.findByEmail("scurtuvlad@gmail.com");

        //Assert
        assertEquals(foundUser,user);
    }


    @Test
    public void shouldReturnUser_whenUpdateIsCalled(){

        //Arrange
        when(userRepository.save(user)).thenReturn(user);

        //Act
        User updateUser = userServiceImpl.update(user);

        //Assert
        assertEquals(updateUser,user);

    }

    @Test
    public void shouldReturnUserList_whenGetAllIsCalled(){

        //Arrange
        List<User> userList = Arrays.asList(user,user2);
        when(userRepository.findAll()).thenReturn(userList);

        //Act
        List<User> retrievedList = userServiceImpl.getAll();

        //Assert
        assertEquals(retrievedList,userList);

    }
}

