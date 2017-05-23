package com.fiivirtualcatalog.login.loginregister;

import com.fiivirtualcatalog.login.controllers.RegisterController;
import com.fiivirtualcatalog.login.email.SmtpMailSender;
import com.fiivirtualcatalog.login.models.ConfirmEmail;
import com.fiivirtualcatalog.login.models.User;
import com.fiivirtualcatalog.login.services.ConfirmEmailService;
import com.fiivirtualcatalog.login.services.ConfirmEmailServiceImpl;
import com.fiivirtualcatalog.login.services.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import javax.mail.MessagingException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by Vladd on 17.05.2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = RegisterController.class)
public class RegisterControllerTest {

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
        user.setName("Vlad");
        user.setPassword("123456");
        user.setRole(User.Role.student);

        email = new ConfirmEmail();
        email.setEmail("scurtuvlad@gmail.com");
        email.setCode("123456");
        email.setId(5);
    }

    @Test
    public void testGetWhenEntryExists() throws Exception {

        assertThat(userServiceMock).isNotNull();
        assertThat(emailServiceMock).isNotNull();

        when(userServiceMock.findByEmail("scurtuvlad@gmail.com")).thenReturn(user);
        when(emailServiceMock.findEmail("scurtuvlad@gmail.com")).thenReturn(email);
        when(userServiceMock.update(user)).thenReturn(user);

        mockMvc.perform(get("/register/validate")
                .param("email","scurtuvlad@gmail.com")
                .param("code","123456"))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    public void testRegister() throws Exception {

        assertThat(userServiceMock).isNotNull();
        assertThat(emailServiceMock).isNotNull();

        when(userServiceMock.save(user)).thenReturn(user);
        when(userServiceMock.findByEmail("scurtuvlad@gmail.com")).thenReturn(user);
        when(emailServiceMock.generateCode()).thenReturn("123456");
        doNothing().when(emailServiceMock).delete("scurtuvlad@gmail.com");
        when(emailServiceMock.save(email)).thenReturn(email);

        mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":" +
                        "5,\"email\":\"scurtuvlad2@gmail.com\", \"pas" +
                        "sword\":\"1234567\", \"name\":\"Vlad2\",\"la" +
                        "stName\":\"Scurtu2\",\"role\":\"st" +
                        "udent\",\"active\":true}"))
                .andDo(print())
                .andExpect(status().isOk());

    }


}
