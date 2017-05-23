package com.fiivirtualcatalog.modules.user.dtos;

import com.fiivirtualcatalog.modules.user.models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PostUserDTOTest {
    private PostUserDTO userDTO;

    @Before
    public void setUp() throws Exception {
        userDTO = new PostUserDTO();
    }

    @Test
    public void forANewInitializedUserShouldBeTheSame() {
        PostUserDTO newUserDTO = new PostUserDTO("nume nou", User.Role.valueOf("student"));
        userDTO.setFirstName("nume nou");
        userDTO.setRole(User.Role.valueOf("student"));
        assertEquals(userDTO.getFirstName(), newUserDTO.getFirstName());
        assertEquals(userDTO.getRole(), newUserDTO.getRole());
        assertEquals(userDTO.getClass(), newUserDTO.getClass());
    }

    @Test
    public void forANewCustomUserShouldBeTheSame() {
        PostUserDTO newUserDTO = new PostUserDTO();
        assertEquals(userDTO.getClass(), newUserDTO.getClass());
    }

    @Test
    public void forAUserDTOWithNameIonutShouldHaveNameIonut() {
        userDTO.setFirstName("Ionut");
        assertEquals(userDTO.getFirstName(), "Ionut");
    }

    @Test
    public void forAUserDTOWithName32ShouldHaveNameIonut() {
        userDTO.setFirstName("");
        assertEquals(userDTO.getFirstName(), "");
    }
}