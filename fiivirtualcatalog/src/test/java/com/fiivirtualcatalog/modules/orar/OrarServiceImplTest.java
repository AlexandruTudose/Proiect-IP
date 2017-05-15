package com.fiivirtualcatalog.modules.orar;

import com.fiivirtualcatalog.modules.orar.models.Orar;
import com.fiivirtualcatalog.modules.orar.repositories.OrarRepository;
import com.fiivirtualcatalog.modules.orar.services.OrarServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

public class OrarServiceImplTest {

    @InjectMocks
    private OrarServiceImpl orarServiceImpl;

    @Mock
    private Orar orar;
    @Mock
    private Orar orar2;

    @Mock
    private OrarRepository orarRepository;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnOrar_whenGetByIdIsCalled()
    {
        when(orarRepository.findOne(5L)).thenReturn(orar);

        Orar retrievedOrar=orarServiceImpl.getById(5L);

        assertThat(retrievedOrar,is(equalTo(orar)));
    }

    @Test
    public void shouldReturnOrar_whenSaveIsCalled()
    {
        when(orarRepository.save(orar)).thenReturn(orar);

        Orar savedOrar=orarServiceImpl.save(orar);

        assertThat(savedOrar,is(equalTo(orar)));
    }

    @Test
    public void shouldCallDeleteOfRepository_whenDeleteIsCalled()
    {
        doNothing().when(orarRepository).delete(5L);

        orarServiceImpl.delete(5L);

        verify(orarRepository,times(1)).delete(5L);

    }

    @Test
    public void shoudReturnOrarList_whenGetAllIsCalled()
    {
        List<Orar> orarList= Arrays.asList(orar,orar2);
        when(orarRepository.findAll()).thenReturn(orarList);

        List<Orar> retrievedList= orarServiceImpl.getAll();

        assertThat(retrievedList,is(equalTo(orarList)));

    }
}
