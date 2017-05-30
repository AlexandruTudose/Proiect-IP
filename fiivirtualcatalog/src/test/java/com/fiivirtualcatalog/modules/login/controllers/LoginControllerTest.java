package com.fiivirtualcatalog.modules.login.controllers;


import com.fiivirtualcatalog.modules.login.email.SmtpMailSender;
import com.fiivirtualcatalog.modules.login.models.ConfirmEmail;
import com.fiivirtualcatalog.modules.login.services.ConfirmEmailServiceImpl;
import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.services.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = LoginController.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext ctx;

    @MockBean
    private ConfirmEmailServiceImpl emailServiceMock;

    @MockBean
    private UserServiceImpl userServiceMock;

    @MockBean
    private SmtpMailSender smtpMock;

    private User user;
    private ConfirmEmail email;

    @Before
    public void setup() {

        user = new User();
        user.setId(5);
        user.setActive(true);
        user.setEmail("scurtuvlad@gmail.com");
        user.setLastName("Scurtu");
        user.setFirstName("Vlad");
        user.setPassword("123456");
        user.setRole(User.Role.student);

        email = new ConfirmEmail();
        email.setEmail("scurtuvlad@gmail.com");
        email.setCode("123456");
        email.setId(5);
    }


    @Test
    public void testSendPassword() throws Exception {

        assertThat(userServiceMock).isNotNull();
        assertThat(emailServiceMock).isNotNull();

        when(userServiceMock.findByEmail("scurtuvlad@gmail.com")).thenReturn(user);
        when(emailServiceMock.findEmail("scurtuvlad@gmail.com")).thenReturn(email);
        when(userServiceMock.update(user)).thenReturn(user);
        when(emailServiceMock.generateCode()).thenReturn("123456");
        when(userServiceMock.save(user)).thenReturn(user);

        mockMvc.perform(post("/login/password")
                .param("email","scurtuvlad@gmail.com"))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void testLoginShouldReturn200() throws Exception {

        assertThat(userServiceMock).isNotNull();
        assertThat(emailServiceMock).isNotNull();


        BCryptPasswordEncoder x = new BCryptPasswordEncoder();
        String y = x.encode("123456");

        user.setPassword(y);
        when(userServiceMock.findByEmail("scurtuvlad@gmail.com")).thenReturn(user);

        mockMvc.perform(post("/login")
                .param("email","scurtuvlad@gmail.com")
                .param("password","123456"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void testLoginShouldReturn401() throws Exception {

        assertThat(userServiceMock).isNotNull();
        assertThat(emailServiceMock).isNotNull();


        BCryptPasswordEncoder x = new BCryptPasswordEncoder();
        String y = x.encode("1234567");

        user.setPassword(y);
        when(userServiceMock.findByEmail("scurtuvlad@gmail.com")).thenReturn(user);

        mockMvc.perform(post("/login")
                .param("email","scurtuvlad@gmail.com")
                .param("password","123456"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
}
