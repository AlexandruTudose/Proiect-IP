package com.fiivirtualcatalog.modules.admin;

import com.fiivirtualcatalog.modules.admin.models.Admin;
import com.fiivirtualcatalog.modules.admin.services.AdminService;
import com.fiivirtualcatalog.modules.user.models.User;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdminServiceTest {

    private static AdminService mockedAdminService;
    private static Admin admin1 = new Admin();
    private static Admin admin2 = new Admin();

    @BeforeClass
    public static void setup(){

        mockedAdminService = mock(AdminService.class);

        admin1.setId(5);
        admin1.setName("AdminTest1");

        admin2.setId(7);
        admin2.setName("AdminTest2");

        when(mockedAdminService.save(admin1)).thenReturn(admin1);
        when(mockedAdminService.save(admin2)).thenReturn(admin2);
        when(mockedAdminService.getById(5L)).thenReturn(admin1);
        when(mockedAdminService.getById(7L)).thenReturn(admin2);
        when(mockedAdminService.getAll()).thenReturn(Arrays.asList(admin1,admin2));

    }

    @Test
    public void test_getAllAdmins(){

        List<User> admins = mockedAdminService.getAll();
        assertEquals(2,admins.size());
        Admin testingAdmin = (Admin) admins.get(0);
        assertEquals(5,testingAdmin.getId());
        assertEquals("AdminTest1",testingAdmin.getName());

    }

    @Test
    public void test_saveAnAdmin(){
        Admin testing2 = (Admin) mockedAdminService.save(admin2);
        assertEquals("AdminTest2",testing2.getName());
    }

    @Test
    public void test_getAdminById(){
        Long id = 7L;

        Admin testing3 = (Admin) mockedAdminService.getById(id);

        assertNotNull(testing3);
        assertEquals(7,testing3.getId());
        assertEquals("AdminTest2",testing3.getName());

    }
}