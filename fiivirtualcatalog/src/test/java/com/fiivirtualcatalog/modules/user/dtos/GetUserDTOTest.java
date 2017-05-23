package com.fiivirtualcatalog.modules.user.dtos;

import com.fiivirtualcatalog.modules.user.models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetUserDTOTest {
    private GetUserDTO getUserDTO;

    @Before
    public void setUp() throws Exception {
        getUserDTO = new GetUserDTO();
    }

    @Test
    public void forANewInitializedUserShouldBeTheSame() {
        GetUserDTO newUserDTO = new GetUserDTO("nume nou",User.Role.valueOf( "student"), 2);
        getUserDTO.setId(2);
        getUserDTO.setFirstName("nume nou");
        getUserDTO.setRole(User.Role.valueOf("student"));
        assertEquals(getUserDTO.getId(), newUserDTO.getId());
        assertEquals(getUserDTO.getFirstName(), newUserDTO.getFirstName());
        assertEquals(getUserDTO.getRole(), newUserDTO.getRole());
        assertEquals(getUserDTO.getClass(), newUserDTO.getClass());
    }

    @Test
    public void forANewCustomUserShouldBeTheSame() {
        GetUserDTO newUserDTO = new GetUserDTO();
        assertEquals(getUserDTO.getClass(), newUserDTO.getClass());
    }

    @Test
    public void forAUserDTOWithNameIonutShouldHaveNameIonut() {
        getUserDTO.setFirstName("Ionut");
        assertEquals(getUserDTO.getFirstName(), "Ionut");
    }

    @Test
    public void forAUserDTOWithName32ShouldHaveNameIonut() {
        getUserDTO.setFirstName("");
        assertEquals(getUserDTO.getFirstName(), "");
    }


}