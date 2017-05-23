package com.fiivirtualcatalog.login.loginregister;

import com.fiivirtualcatalog.login.controllers.MossController;
import com.fiivirtualcatalog.login.controllers.RegisterController;
import com.fiivirtualcatalog.login.email.SmtpMailSender;
import com.fiivirtualcatalog.login.models.ConfirmEmail;
import com.fiivirtualcatalog.login.models.User;
import com.fiivirtualcatalog.login.moss.Moss;
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
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MossController.class)
public class MossControllerTest {

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

    }

    @Test
    public void testMoss() throws Exception {

        mockMvc.perform(post("/profesor/moss")
                .param("path1","C:\\Users\\Vladd\\Desktop\\students_solutions")
                .param("path2","C:\\Users\\Vladd\\Desktop\\base_directory")
                .param("language","java"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
