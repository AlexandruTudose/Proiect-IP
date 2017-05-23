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
    private Orar updatedOrar;
    private Orar orar2;

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

        updatedOrar=new Orar();
        updatedOrar.setId(1L);
        updatedOrar.setGrupa("B4");
        updatedOrar.setIdDisciplina(3);
        updatedOrar.setIdProf(4);
        updatedOrar.setOraInceput(new Time(503000));
        updatedOrar.setOraSfarsit(new Time(513000));
        updatedOrar.setTip("Seminar");
        updatedOrar.setZi("Vineri");
        updatedOrar.setSala(20); //the only modification from orar

        orar2=new Orar();
        orar2.setId(2L); //the only modification from orar just to represent a new "different" entry
        orar2.setGrupa("B4");
        orar2.setIdDisciplina(3);
        orar2.setIdProf(4);
        orar2.setOraInceput(new Time(503000));
        orar2.setOraSfarsit(new Time(513000));
        orar2.setSala(5);
        orar2.setTip("Seminar");
        orar2.setZi("Vineri");
        orar2.setId(2L);
    }

    private static String createOrarInJson (long id, String zi, Time oraInceput, Time oraSfarsit, int idDisciplina,int idProf, int sala, String tip, String grupa) {
        return "{\"id\":" + Long.toString(id) + "," +
            "\"zi\":\"" + zi + "\"," +
            "\"oraInceput\":\"" + oraInceput .toString()+ "\"," +
            "\"oraSfarsit\":\"" + oraSfarsit.toString() + "\"," +
            "\"idDisciplina\":" + Integer.toString(idDisciplina) + "," +
            "\"idProf\":" + Integer.toString(idProf) + "," +
            "\"sala\":" + Integer.toString(sala) + "," +
            "\"tip\":\"" + tip + "\"," +
            "\"grupa\":\"" + grupa + "\"}";
}

    private static String createOrarInJsonForUpdate( String zi, Time oraInceput, Time oraSfarsit, int idDisciplina,int idProf, int sala, String tip, String grupa)
    {
        return "{" +
                "\"zi\":\"" + zi + "\"," +
                "\"ora_inceput\":\"" + oraInceput .toString()+ "\"," +
                "\"ora_sfarsit\":\"" + oraSfarsit.toString() + "\"," +
                "\"id_disciplina\":" + Integer.toString(idDisciplina) + "," +
                "\"id_prof\":" + Integer.toString(idProf) + "," +
                "\"sala\":" + Integer.toString(sala) + "," +
                "\"tip\":\"" + tip + "\"," +
                "\"grupa\":\"" + grupa + "\"}";
    }

    @Test
    public void testGetWhenEntryExists() throws Exception {

        assertThat(this.orarServiceMock).isNotNull();

        List<Orar> listTest= Arrays.asList(orar);
        when (orarServiceMock.getAll()).thenReturn(listTest);

        MvcResult result = mockMvc.perform(get("/v1/orar/crud/read").contentType(MediaType.APPLICATION_JSON) )
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

        List<Orar> listTest= Arrays.asList();
        when (orarServiceMock.getAll()).thenReturn(listTest);

        MvcResult result = mockMvc.perform(get("/v1/orar/crud/read"))
                .andExpect(status().isNoContent())
                .andDo(print())
                .andReturn();

        MockHttpServletResponse mockResponse=result.getResponse();
        assertThat(mockResponse.getContentType()).isNull();

        Collection<String> responseHeaders=mockResponse.getHeaderNames();

        assertNotNull(responseHeaders);
        assertEquals(0, responseHeaders.size());

        verify(orarServiceMock, times(1)).getAll();
        verifyNoMoreInteractions(orarServiceMock);
    }

    @Test
    public void testDeleteEntryWhenExists() throws Exception {
        assertThat(this.orarServiceMock).isNotNull();

        //list without first orar to be returned after removal
        List<Orar> orarList=Arrays.asList(orar2);

        when (orarServiceMock.getById(1L)).thenReturn(orar);
        when (orarServiceMock.getAll()).thenReturn(orarList);

        MvcResult result = mockMvc.perform(delete("/v1/orar/crud/delete/{deleteId}",1L))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        MockHttpServletResponse mockResponse=result.getResponse();
        assertThat(mockResponse.getContentType()).isEqualTo("application/json;charset=UTF-8");

        Collection<String> responseHeaders=mockResponse.getHeaderNames();

        assertNotNull(responseHeaders);
        assertEquals(1, responseHeaders.size());
        assertEquals("Check for Content-Type header", "Content-Type", responseHeaders.iterator().next());

        //should not contain the removed entity
        String responseAsString=mockResponse.getContentAsString();
        String orarJson=createOrarInJson(orar.getId(),orar.getZi(),orar.getOraInceput()
                ,orar.getOraSfarsit(),orar.getIdDisciplina(),orar.getIdProf(),orar.getSala(),orar.getTip(),orar.getGrupa());

        assertFalse(responseAsString.contains(orarJson));

        verify(orarServiceMock, times(1)).getById(1L);
        verify(orarServiceMock, times(1)).delete(1L);
        verify(orarServiceMock, times(1)).getAll();
        verifyNoMoreInteractions(orarServiceMock);

    }

    @Test
    public void testDeleteEntryWhenNotExists() throws Exception {
        assertThat(this.orarServiceMock).isNotNull();

        when (orarServiceMock.getById(1L)).thenReturn(null);

        MvcResult result = mockMvc.perform(delete("/v1/orar/crud/delete/{deleteId}",1L))
                .andExpect(status().isNoContent())
                .andDo(print())
                .andReturn();

        MockHttpServletResponse mockResponse=result.getResponse();
        assertThat(mockResponse.getContentType()).isNull();

        Collection<String> responseHeaders=mockResponse.getHeaderNames();

        assertNotNull(responseHeaders);
        assertEquals(0, responseHeaders.size());

        verify(orarServiceMock, times(1)).getById(1L);
        verifyNoMoreInteractions(orarServiceMock);

    }

    @Test
    public void testUpdateEntryWhenExists() throws Exception {
        assertThat(this.orarServiceMock).isNotNull();

        when (orarServiceMock.getById(orar.getId())).thenReturn(orar);
        when (orarServiceMock.save(orar)).thenReturn(updatedOrar);

        String updatedOrarJson=createOrarInJsonForUpdate(updatedOrar.getZi(),updatedOrar.getOraInceput()
                ,updatedOrar.getOraSfarsit(),updatedOrar.getIdDisciplina(),updatedOrar.getIdProf(),updatedOrar.getSala(),updatedOrar.getTip(),updatedOrar.getGrupa());

        MvcResult result=mockMvc.perform(put("/v1/orar/crud/update/{updateId}", orar.getId()).contentType(MediaType.APPLICATION_JSON).
                content(updatedOrarJson))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        MockHttpServletResponse mockResponse=result.getResponse();
        assertThat(mockResponse.getContentType()).isEqualTo("application/json;charset=UTF-8");

        Collection<String> responseHeaders=mockResponse.getHeaderNames();

        assertNotNull(responseHeaders);
        assertEquals(1, responseHeaders.size());
        assertEquals("Check for Content-Type header", "Content-Type", responseHeaders.iterator().next());

        String responseAsString=mockResponse.getContentAsString();
        String orarJson=createOrarInJson(updatedOrar.getId(),updatedOrar.getZi(),updatedOrar.getOraInceput()
                ,updatedOrar.getOraSfarsit(),updatedOrar.getIdDisciplina(),updatedOrar.getIdProf(),updatedOrar.getSala(),updatedOrar.getTip(),updatedOrar.getGrupa());

        assertTrue(responseAsString.equals(orarJson));

        verify(orarServiceMock, times(1)).getById(orar.getId());
        verify(orarServiceMock, times(1)).save(orar);
        verifyNoMoreInteractions(orarServiceMock);
    }

    @Test
    public void testUpdateEntryWhenNotExists() throws Exception {
        assertThat(this.orarServiceMock).isNotNull();

        when (orarServiceMock.getById(orar.getId())).thenReturn(null);

        String updatedOrarJson=createOrarInJsonForUpdate(updatedOrar.getZi(),updatedOrar.getOraInceput()
                ,updatedOrar.getOraSfarsit(),updatedOrar.getIdDisciplina(),updatedOrar.getIdProf(),updatedOrar.getSala(),updatedOrar.getTip(),updatedOrar.getGrupa());

        MvcResult result = mockMvc.perform(put("/v1/orar/crud/update/{updateId}",orar.getId()).contentType(MediaType.APPLICATION_JSON).
                content(updatedOrarJson))
                .andExpect(status().isNoContent())
                .andDo(print())
                .andReturn();

        MockHttpServletResponse mockResponse=result.getResponse();
        assertThat(mockResponse.getContentType()).isNull();

        Collection<String> responseHeaders=mockResponse.getHeaderNames();

        assertNotNull(responseHeaders);
        assertEquals(0, responseHeaders.size());

        verify(orarServiceMock, times(1)).getById(orar.getId());
        verifyNoMoreInteractions(orarServiceMock);
    }
}