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
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by Vladd on 10.05.2017.
 */
public class AdminControllerTest {

    private User user = new User();
    private User user2 = new User();
    @InjectMocks
    private AdminController controller;

    @InjectMocks
    private UserServiceImpl userService = new UserServiceImpl();

    @Mock
    private UserRepository userRepository;

    private MockMvc mockMvc;

    @Before
    public void setup(){

        user.setId(5);
        user.setActive(true);
        user.setLastName("Test1");
        user.setName("Test1");
        user.setPassword("123123");
        user.setRole(User.Role.student);
        user.setEmail("test@gmail.com");

        user2.setId(7);
        user2.setActive(true);
        user2.setLastName("Test2");
        user2.setName("Test2");
        user2.setPassword("123123");
        user2.setRole(User.Role.student);
        user2.setEmail("test2@gmail.com");

        MockitoAnnotations.initMocks(this);


        when(userRepository.save(user)).thenReturn(user);
        when(userService.getAll()).thenReturn(Collections.singletonList(user));

    }

    @Test
    public void testgetAll() throws Exception {


        userService.save(user);
        userService.save(user2);
        List<User> students = userService.getAll();
        assertEquals(students.get(0),userService.getAll());
        assertEquals(students.size(),userService.getAll().size());

    }

}
