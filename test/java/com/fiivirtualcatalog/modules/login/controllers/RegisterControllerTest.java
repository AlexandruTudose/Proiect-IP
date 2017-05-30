package com.fiivirtualcatalog.modules.login.controllers;


import com.fiivirtualcatalog.modules.login.email.SmtpMailSender;
import com.fiivirtualcatalog.modules.login.models.ConfirmEmail;
import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.login.repositories.ConfirmEmailRepository;
import com.fiivirtualcatalog.modules.user.repositories.UserRepository;
import com.fiivirtualcatalog.modules.login.services.ConfirmEmailServiceImpl;
import com.fiivirtualcatalog.modules.user.services.UserService;
import com.fiivirtualcatalog.modules.user.services.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.mail.MessagingException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Vladd on 09.05.2017.
 */
public class RegisterControllerTest {
    @InjectMocks
    private RegisterController controller;

    private User user1 = new User();
    private User user2 = new User();
    private static UserServiceImpl mockedUserService;

    @Autowired
    private static ConfirmEmailServiceImpl confirmEmailService;

    @Autowired
    private UserService userService;

    private static ConfirmEmailServiceImpl mockedConfirmEmail;
    private static ConfirmEmail email1 = new ConfirmEmail();
    private static ConfirmEmail email2 = new ConfirmEmail();

    private static SmtpMailSender mockedSender;

    @Mock
    private static ConfirmEmailRepository emailRepository;

    @Mock
    private UserRepository userRepository;

    private MockMvc mockMvc;

    @Before
    public void setup() throws MessagingException {

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

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        when(mockedUserService.save(user1)).thenReturn(user1);
        when(mockedUserService.save(user2)).thenReturn(user2);
        when(mockedUserService.findByEmail("test1@gmail.com")).thenReturn(user1);
        when(mockedUserService.findByEmail("test2@gmail.com")).thenReturn(user2);
        when(mockedUserService.getAll()).thenReturn(Arrays.asList(user1,user2));

        mockedConfirmEmail = mock(ConfirmEmailServiceImpl.class);

        email1.setId(5);
        email1.setCode("230");
        email1.setEmail("test1@gmail.com");

        email2.setId(6);
        email2.setCode("120") ;
        email2.setEmail("test2@gmail.com");

        when(mockedConfirmEmail.findEmail("test1@gmail.com")).thenReturn(email1);
        when(mockedConfirmEmail.findEmail("test2@gmail.com")).thenReturn(email2);
        when(mockedConfirmEmail.save(email1)).thenReturn(email1);
        when(mockedConfirmEmail.save(email2)).thenReturn(email2);


    }

    @Test
    public void testRegister() throws Exception {

        mockMvc.perform(post("/register")
                .content("{\"id\":" +
                        "5,\"email\":\"test1@gmail.com\", \"pas" +
                        "sword\":\"123123\", \"name\":\"Test1\",\"la" +
                        "stName\":\"Test1\",\"role\":\"st" +
                        "udent\",\"active\":true}"))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    public void testValidate() throws Exception {

      ConfirmEmail confirmEmail=mockedConfirmEmail.findEmail(email1.getEmail());

      assertEquals(confirmEmail.getCode(),email1.getCode());



    }
}
