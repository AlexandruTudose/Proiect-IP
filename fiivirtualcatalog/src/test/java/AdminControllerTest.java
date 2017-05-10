import com.fiivirtualcatalog.login.controllers.AdminController;
import com.fiivirtualcatalog.login.controllers.RegisterController;
import com.fiivirtualcatalog.login.models.User;
import com.fiivirtualcatalog.login.repositories.UserRepository;
import com.fiivirtualcatalog.login.services.UserService;
import com.fiivirtualcatalog.login.services.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Vladd on 10.05.2017.
 */
public class AdminControllerTest {

    @InjectMocks
    private AdminController controller;

    private User user1 = new User();
    private User user2 = new User();
    private static UserServiceImpl mockedUserService;

    @Mock
    private UserRepository userRepository;

    private MockMvc mockMvc;

    @Before
    public void setup(){

        mockedUserService = mock(UserServiceImpl.class);

        user1.setId(5);
        user1.setActive(true);
        user1.setLastName("Test1");
        user1.setName("Test1");
        user1.setPassword("123123");
        user1.setRole(User.Role.student);
        user1.setEmail("test1@gmail.com");

        user2.setId(7);
        user2.setActive(true);
        user2.setLastName("Test2");
        user2.setName("Test2");
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

    }

    @Test
    public void testUsers() throws Exception {

        mockMvc.perform(get("/admin/users"))
                        .andDo(print());

    }

    @Test
    public void testDelete() throws Exception {

        mockMvc.perform(post("/admin/users")
                        .content("{\"id\":" +
                                "5,\"email\":\"test1@gmail.com\", \"pas" +
                                "sword\":\"123123\", \"name\":\"Test1\",\"la" +
                                "stName\":\"Test1\",\"role\":\"st" +
                                "udent\",\"active\":true}"))
                        .andDo(print());

    }



}
