import com.fiivirtualcatalog.login.controllers.BlogEntryController;
import com.fiivirtualcatalog.login.controllers.RegisterController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by Vladd on 09.05.2017.
 */
public class BlogEntryControllerTest {

    @InjectMocks
    private BlogEntryController controller;

    private MockMvc mockMvc;

    @Before
    public void setup(){

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void test() throws Exception {

        mockMvc.perform(get("/test")).andDo(print());

    }
}
