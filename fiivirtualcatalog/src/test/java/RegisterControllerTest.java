import com.fiivirtualcatalog.login.controllers.RegisterController;
import com.fiivirtualcatalog.login.models.User;
import com.fiivirtualcatalog.login.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Created by Vladd on 09.05.2017.
 */
public class RegisterControllerTest {
    @InjectMocks
    private RegisterController controller;


    @Mock
    private UserService service;

    private MockMvc mockMvc;

    @Before
    public void setup(){

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void test() throws Exception {

        User user = new User();
        user.setId(5);
        user.setActive(true);
        user.setEmail("test@gmail.com");

        when(service.findByEmail(user.getEmail())).thenReturn(user);

        mockMvc.perform(get("/register/validate")
                ).andDo(print());

    }

    @Test
    public void testPost() throws Exception {

        mockMvc.perform(post("/register").content("{\n" +
                "  \"active\": true,\n" +
                "  \"email\": \"yolo@gmail.com\",\n" +
                "  \"id\": 10,\n" +
                "  \"lastName\": \"Vlad\",\n" +
                "  \"name\": \"Vlad\",\n" +
                "  \"password\": \"123123\",\n" +
                "  \"role\": \"student\"\n" +
                "}")
        .contentType(MediaType.APPLICATION_JSON)).andDo(print());
        ;
    }
}
