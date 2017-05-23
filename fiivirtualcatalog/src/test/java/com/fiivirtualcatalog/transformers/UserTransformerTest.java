package com.fiivirtualcatalog.transformers;


import com.fiivirtualcatalog.modules.user.dtos.GetUserDTO;
import com.fiivirtualcatalog.modules.user.dtos.PostUserDTO;
import com.fiivirtualcatalog.modules.user.models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTransformerTest {

    private UserTransformer userTransformer;

    @Before
    public void setUp() throws Exception {
        userTransformer = new UserTransformer();
    }

    @Test
    public void whenICallToModelShouldReceiveAUserWithSameCharacteristics() {
        PostUserDTO postUserDTO = new PostUserDTO();
        postUserDTO.setFirstName("Name");
        postUserDTO.setRole("student");
        User user = userTransformer.toModel(postUserDTO);
        assertEquals(user.getFirstName(), postUserDTO.getFirstName());
        assertEquals(user.getRole(), postUserDTO.getRole());
    }

    @Test
    public void whenICallToDTOShouldReceiveAUserWithSameCharacteristics() {
        User user = new User();
        user.setId(12);
        user.setFirstName("Name");
        user.setRole(User.Role.student);
        GetUserDTO getUserDTO = userTransformer.toDTO(user);
        assertEquals(user.getId(), getUserDTO.getId());
        assertEquals(user.getFirstName(), getUserDTO.getFirstName());
        assertEquals(user.getRole(), getUserDTO.getRole());
    }
}