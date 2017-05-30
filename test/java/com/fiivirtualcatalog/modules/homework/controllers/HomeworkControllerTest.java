package com.fiivirtualcatalog.modules.homework.controllers;


import com.fiivirtualcatalog.modules.homework.controller.HomeworkController;
import com.fiivirtualcatalog.modules.homework.service.HomeworkService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


public class HomeworkControllerTest {


    @InjectMocks
    private HomeworkController homeworkController;

    @Autowired
    private WebApplicationContext ctx;

    @Mock
    private HomeworkService homeworkService;

    private MockMvc mockMvc;

    @Before
    public void setup(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(homeworkController).build();

    }

    @Test
    public void createHomework() throws Exception {

        mockMvc.perform(post("/homeworks")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"id_curs\": 2,\n" +
                        "  \"id_student\": 3,\n" +
                        "  \"id_nota\": 4,\n" +
                        "  \"tip_tema\": \"blabla\",\n" +
                        "  \"fisier\": \"pdf\",\n" +
                        "  \"data_notare\": \"2017-05-29\"\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getHomeworkTest() throws Exception {

        mockMvc.perform(get("/homeworks/{id}",1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateHomeworkTest() throws Exception {

        mockMvc.perform(get("/homeworks/{id}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\" +\n" +
                        "                        \"  \\\"id\\\": 1,\\n\" +\n" +
                        "                        \"  \\\"id_curs\\\": 2,\\n\" +\n" +
                        "                        \"  \\\"id_student\\\": 3,\\n\" +\n" +
                        "                        \"  \\\"id_nota\\\": 4,\\n\" +\n" +
                        "                        \"  \\\"tip_tema\\\": \\\"blabla\\\",\\n\" +\n" +
                        "                        \"  \\\"fisier\\\": \\\"pdf\\\",\\n\" +\n" +
                        "                        \"  \\\"data_notare\\\": \\\"2017-05-29\\\"\\n\" +\n" +
                        "                        \"}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteHomeworkTest() throws Exception {

        mockMvc.perform(get("/homeworks/{id}",1))
                .andDo(print())
                .andExpect(status().isOk());
    }


}