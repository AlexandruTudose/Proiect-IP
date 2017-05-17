package com.fiivirtualcatalog.modules.admin;

import com.fiivirtualcatalog.modules.admin.controllers.AdminController;
import com.fiivirtualcatalog.modules.admin.models.Admin;
import com.fiivirtualcatalog.modules.admin.services.AdminService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminControllerTest {

    @Mock
    private AdminService adminService;

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
    public void test_getAllAdmins() throws Exception {
        mockMvc.perform(get("/v1/admins")).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id", is(3)))
                .andExpect(jsonPath("$[0].name", is("poate")))
                .andExpect(jsonPath("$[0].role", is("admin")))
                .andExpect(jsonPath("$[2].id", is(5)))
                .andExpect(jsonPath("$[2].name", is("da1")))
                .andExpect(jsonPath("$[2].role", is("admin")))
                .andDo(print()
                );
    }

    @Test
    public void test_getAnAdminById() throws Exception {
        mockMvc.perform(get("/v1/admins/{userId}", 4L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(4)))
                .andExpect(jsonPath("$.name", is("da")))
                .andExpect(jsonPath("$.role", is("admin")))
                .andDo(print());
    }

    @Test
    public void test_postAnAdmin() throws Exception {
        mockMvc.perform(post("/v1/admins")
                    .content("{\"name\":\"postAdmin1\", \"role\":\"admin\"}")
                    .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", hasSize(7)))
                .andExpect(jsonPath("$.id", is(9)))
                .andExpect(jsonPath("$.name", is("postAdmin1")))
                .andExpect(jsonPath("$.role", is("admin")))
                .andDo(print());
    }

    @Test
    public void test_deleteAnAdminById() throws Exception {
        Admin admin = new Admin();
        Long id = 8L;
        when(adminService.getById(id)).thenReturn(admin);
        doNothing().when(adminService).delete(id);
        mockMvc.perform(
                delete("/v1/admins/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void test_deleteAnAdminThatNotExists() throws Exception {
        Long id = 9999999L;
        doNothing().when(adminService).delete(id);
        mockMvc.perform(
                delete("/v1/admins/{userId}", id))
                .andExpect(status().isNoContent());
    }

    @Test
    public void test_updateAnAdmin() throws Exception {
        Long id = 5L;
        mockMvc.perform(put("/v1/admins/{userId}", id)
                .content("{\"name\":\"postAdmin99\", \"role\":\"admin\"}")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", hasSize(7)))
                .andExpect(jsonPath("$.id", is(5)))
                .andExpect(jsonPath("$.name", is("postAdmin99")))
                .andExpect(jsonPath("$.role", is("admin")))
                .andDo(print());
    }

    @Test
    public void test_updateAnAdminThatNotExists() throws Exception {
        Long id = 9999999L;
        mockMvc.perform(
                put("/v1/admins/{userId}", id)
                        .content("{\"name\":\"postAdmin99\", \"role\":\"admin\"}")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isNoContent());
    }
}