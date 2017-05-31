package com.fiivirtualcatalog.modules.login.services;

import com.fiivirtualcatalog.modules.login.models.ConfirmEmail;
import com.fiivirtualcatalog.modules.login.repositories.ConfirmEmailRepository;
import com.fiivirtualcatalog.modules.login.services.ConfirmEmailServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Vladd on 10.05.2017.
 */
public class ConfirmEmailServiceTest {

    private static ConfirmEmailServiceImpl mockedConfirmEmail;
    private static ConfirmEmail email1 = new ConfirmEmail();
    private static ConfirmEmail email2 = new ConfirmEmail();

    @Mock
    private static ConfirmEmailRepository emailRepository;

    @BeforeClass
    public static void setup(){

        mockedConfirmEmail = mock(ConfirmEmailServiceImpl.class);

        email1.setId(5);
        email1.setCode(new ConfirmEmailServiceImpl().generateCode());
        email1.setEmail("test1@gmail.com");

        email2.setId(6);
        email2.setCode(new ConfirmEmailServiceImpl().generateCode()) ;
        email2.setEmail("test2@gmail.com");

        when(mockedConfirmEmail.findEmail("test1@gmail.com")).thenReturn(email1);
        when(mockedConfirmEmail.findEmail("test2@gmail.com")).thenReturn(email2);
        when(mockedConfirmEmail.save(email1)).thenReturn(email1);
        when(mockedConfirmEmail.save(email2)).thenReturn(email2);

    }

    @Test
    public void testFindEmail(){

        String email = "test1@gmail.com";

        ConfirmEmail testing1 = mockedConfirmEmail.findEmail(email);

        assertNotNull(testing1);
        System.out.println(testing1.getCode());
        assertEquals(5,testing1.getId());
        assertEquals("test1@gmail.com",testing1.getEmail());

    }

    @Test
    public void testSave(){

        ConfirmEmail testing2 = mockedConfirmEmail.save(email2);

        System.out.println(testing2.getCode());
        assertEquals(6,testing2.getId());
        assertEquals("test2@gmail.com",testing2.getEmail());
    }

}
