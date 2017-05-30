package com.fiivirtualcatalog.modules.homework.controllers;


import com.fiivirtualcatalog.modules.homework.controller.CourseController;
import com.fiivirtualcatalog.modules.homework.service.CourseService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



public class CourseControllerTest {


    @InjectMocks
    private CourseController courseController;

    @Autowired
    private WebApplicationContext ctx;

    @Mock
    private CourseService courseService;

    private MockMvc mockMvc;

    @Before
    public void setup(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();

    }

    @Test
    public void createCourse() throws Exception {

        mockMvc.perform(post("/courses")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"denumire\": \"blabla\",\n" +
                        "  \"an\": 2,\n" +
                        "  \"credite\": 5\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void getCourseTest() throws Exception {

        mockMvc.perform(get("/courses/{id}",2))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateCourseTest() throws Exception {

        mockMvc.perform(put("/courses/{id}",1)
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
                    "  \"id\": 1,\n" +
                    "  \"denumire\": \"blabla\",\n" +
                    "  \"an\": 2,\n" +
                    "  \"credite\": 5\n" +
                    "}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteCourseTest() throws Exception {

        mockMvc.perform(delete("/courses/{id}",2))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
