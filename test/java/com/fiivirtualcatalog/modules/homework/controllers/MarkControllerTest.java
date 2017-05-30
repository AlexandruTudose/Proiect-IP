package com.fiivirtualcatalog.modules.homework.controllers;

import com.fiivirtualcatalog.modules.homework.controller.MarkController;
import com.fiivirtualcatalog.modules.homework.service.MarkService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class MarkControllerTest {


    @InjectMocks
    private MarkController markController;

    @Autowired
    private WebApplicationContext ctx;

    @Mock
    private MarkService markService;

    private MockMvc mockMvc;

    @Before
    public void setup(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(markController).build();

    }

    @Test
    public void createMark() throws Exception {

        mockMvc.perform(post("/marks")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"id_profesor\": 2,\n" +
                        "  \"valoare\": 10,\n" +
                        "  \"data_notare\": \"2017-05-29\"\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
