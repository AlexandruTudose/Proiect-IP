package com.fiivirtualcatalog.modules.orar;

import com.fiivirtualcatalog.modules.orar.controllers.OrarController;
import com.fiivirtualcatalog.modules.orar.services.OrarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = OrarController.class)
public class OrarControllerIT {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext ctx;

    @MockBean
    private OrarService orarServiceMock;

    @Before
    public void setup(){

        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testGetAllWhenEntryExists() throws Exception {
        assertThat(this.orarServiceMock).isNotNull();
        mockMvc.perform(get("/v1/orar/crud/read")).andExpect(status().isOk())
                .andDo(print()
                );
    }

    @Test
    public void testGetAllWhenNotExists() throws Exception {
        mockMvc.perform(get("/v1/orar/crud/read")).andExpect(status().isNoContent())
                .andDo(print()
                );

    }

    @Test
    public void testDeleteEntry() throws Exception {
        mockMvc.perform(delete("/v1/orar/delete/12")).andExpect(status().isOk())
                .andDo(print()
                );
    }

    @Test
    public void testRootPost() throws Exception {
        mockMvc.perform(post("/v1/orar")).andExpect(status().isOk())
                .andDo(print()
                );
    }

    @Test
    public void testUpdateEntry() throws Exception {
        mockMvc.perform(put("/v1/orar/15")).andExpect(status().isOk())
                .andDo(print()
                );
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/v1/orar")).andExpect(status().isOk())
                .andDo(print()
                );
    }
}