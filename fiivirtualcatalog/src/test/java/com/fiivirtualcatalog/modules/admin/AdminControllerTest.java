package com.fiivirtualcatalog.modules.admin;

import com.fiivirtualcatalog.modules.admin.controllers.AdminController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminControllerTest {

    @Autowired private WebApplicationContext ctx;

    @InjectMocks
    private AdminController controller;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testGetAllWhenEntryExists() throws Exception {
        mockMvc.perform(get("/v1/admins")).andExpect(status().isOk())
                .andDo(print()
                );
    }

    @Test
    public void testGetAllWhenNotExists() throws Exception {
        mockMvc.perform(get("/v1/admins")).andExpect(status().isNoContent())
                .andDo(print()
                );
    }
}
