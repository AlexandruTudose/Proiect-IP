package com.fiivirtualcatalog.modules.user.dtos;

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
        PostUserDTO newUserDTO = new PostUserDTO("nume nou", "rol nou");
        userDTO.setName("nume nou");
        userDTO.setRole("rol nou");
        assertEquals(userDTO.getName(), newUserDTO.getName());
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
        userDTO.setName("Ionut");
        assertEquals(userDTO.getName(), "Ionut");
    }

    @Test
    public void forAUserDTOWithName32ShouldHaveNameIonut() {
        userDTO.setName("");
        assertEquals(userDTO.getName(), "");
    }
}