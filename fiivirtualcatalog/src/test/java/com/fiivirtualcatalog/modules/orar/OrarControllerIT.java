package com.fiivirtualcatalog.modules.orar;

import com.fiivirtualcatalog.modules.orar.controllers.OrarController;
import com.fiivirtualcatalog.modules.orar.models.Orar;
import com.fiivirtualcatalog.modules.orar.services.OrarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Time;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = OrarController.class)
public class OrarControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext ctx;

    @MockBean
    private OrarService orarServiceMock;

    private Orar orar;

    @Before
    public void setup()
    {
        orar=new Orar();
        orar.setId(1L);
        orar.setGrupa("B4");
        orar.setIdDisciplina(3);
        orar.setIdProf(4);
        orar.setOraInceput(new Time(503000));
        orar.setOraSfarsit(new Time(513000));
        orar.setSala(5);
        orar.setTip("Seminar");
        orar.setZi("Vineri");
    }

    @Test
    public void testGetWhenEntryExists() throws Exception {
        assertThat(this.orarServiceMock).isNotNull();

        List<Orar> listTest= Arrays.asList(orar);
        when (orarServiceMock.getAll()).thenReturn(listTest);

        MvcResult result = mockMvc.perform(get("/v1/orar/crud/read").contentType(MediaType.APPLICATION_JSON) )
               // .content("{\"userName\":\"testUserDetails\",\"firstName\":\"xxx\",\"lastName\":\"xxx\",\"password\":\"xxx\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].grupa", is("B4")))
                .andExpect(jsonPath("$[0].zi", is("Vineri")))
                .andExpect(jsonPath("$[0].idDisciplina", is(3)))
                .andExpect(jsonPath("$[0].tip", is("Seminar")))
                .andExpect(jsonPath("$[0].sala", is(5)))
                .andExpect(jsonPath("$[0].oraInceput", is(new Time(503000).toString())))
                .andExpect(jsonPath("$[0].oraSfarsit", is(new Time(513000).toString())))
                .andExpect(jsonPath("$[0].idProf", is(4)))

                .andDo(print())

                .andReturn();

        String content = result.getResponse().getContentAsString();

        MockHttpServletResponse mockResponse=result.getResponse();
        assertThat(mockResponse.getContentType()).isEqualTo("application/json;charset=UTF-8");

        Collection<String> responseHeaders=mockResponse.getHeaderNames();

        assertNotNull(responseHeaders);
        assertEquals(1, responseHeaders.size());
        assertEquals("Check for Content-Type header", "Content-Type", responseHeaders.iterator().next());

        verify(orarServiceMock, times(1)).getAll();
        verifyNoMoreInteractions(orarServiceMock);

    }

    @Test
    public void testGetWhenNotExists() throws Exception {
        assertThat(this.orarServiceMock).isNotNull();

        mockMvc.perform(get("/v1/orar/crud/read")).andExpect(status().isNoContent())
                .andDo(print()
                );

    }

    @Test
    public void testDeleteEntry() throws Exception {
        assertThat(this.orarServiceMock).isNotNull();
        mockMvc.perform(delete("/v1/orar/delete/12")).andExpect(status().isOk())
                .andDo(print()
                );
    }

    @Test
    public void testRootPost() throws Exception {
        assertThat(this.orarServiceMock).isNotNull();
        mockMvc.perform(post("/v1/orar")).andExpect(status().isOk())
                .andDo(print()
                );
    }

    @Test
    public void testUpdateEntry() throws Exception {
        assertThat(this.orarServiceMock).isNotNull();
        mockMvc.perform(put("/v1/orar/15")).andExpect(status().isOk())
                .andDo(print()
                );
    }

    @Test
    public void testGetAll() throws Exception {
        assertThat(this.orarServiceMock).isNotNull();
        mockMvc.perform(get("/v1/orar")).andExpect(status().isOk())
                .andDo(print()
                );
    }
}