package com.fiivirtualcatalog.login.loginregister;

import com.fiivirtualcatalog.login.models.ConfirmEmail;
import com.fiivirtualcatalog.login.repositories.ConfirmEmailRepository;
import com.fiivirtualcatalog.login.services.ConfirmEmailServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Vladd on 16.05.2017.
 */
public class ConfirmEmailServiceTest {

    @InjectMocks
    private ConfirmEmailServiceImpl emailServiceImpl;

    @Mock
    private ConfirmEmailRepository emailRepository;

    @Mock
    private ConfirmEmail email;

    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnEmail_whenFindEmailIsCalled(){

        //Arrange
        when(emailRepository.findByEmail("scurtuvlad@gmail.com")).thenReturn(email);

        //Act
        ConfirmEmail foundEmail = emailServiceImpl.findEmail("scurtuvlad@gmail.com");

        //Assert
        assertEquals(foundEmail,email);

    }

    @Test
    public void shouldReturnEmail_whenSaveIsCalled(){

        //Arrange
        when(emailRepository.save(email)).thenReturn(email);

        //Act
        ConfirmEmail savedEmail = emailServiceImpl.save(email);

        //Assert
        assertEquals(email,savedEmail);
    }

    @Test
    public void shouldCallDeleteMethodOfEmailRepository_whenDeleteIsCalled(){

        //Arrange
        doNothing().when(emailRepository).deleteByEmail("scurtuvlad@gmail.com");

        //Act
        emailServiceImpl.delete("scurtuvlad@gmail.com");

        //Assert
        verify(emailRepository, times(1)).deleteByEmail("scurtuvlad@gmail.com");


    }
    @Test
    public void shouldReturnString_whenGenerateCodeIsCalled(){

        //Act
        String c1 = emailServiceImpl.generateCode();
        String c2 = emailServiceImpl.generateCode();

        //Assert
        assertThat(c1,not(c2));
    }

}
