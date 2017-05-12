package com.fiivirtualcatalog.modules.user.dtos;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetUserDTOTest {
    private GetUserDTO getUserDTO;
    @Before
    public void setUp() throws Exception {
        getUserDTO = new GetUserDTO();
    }

    @Test
    public void forANewInitializedUserShouldBeTheSame(){
        GetUserDTO newUserDTO = new GetUserDTO("nume nou","rol nou",2);
        getUserDTO.setId(2);
        getUserDTO.setName("nume nou");
        getUserDTO.setRole("rol nou");
        assertEquals(getUserDTO.getId(),newUserDTO.getId());
        assertEquals(getUserDTO.getName(),newUserDTO.getName());
        assertEquals(getUserDTO.getRole(),newUserDTO.getRole());
        assertEquals(getUserDTO.getClass(),newUserDTO.getClass());
    }

    @Test
    public void forANewCustomUserShouldBeTheSame(){
        GetUserDTO newUserDTO = new GetUserDTO();
        assertEquals(getUserDTO.getClass(),newUserDTO.getClass());
    }

    @Test
    public void forAUserDTOWithNameIonutShouldHaveNameIonut(){
        getUserDTO.setName("Ionut");
        assertEquals(getUserDTO.getName(),"Ionut");
    }

    @Test
    public void forAUserDTOWithName32ShouldHaveNameIonut(){
        getUserDTO.setName("");
        assertEquals(getUserDTO.getName(),"");
    }



}