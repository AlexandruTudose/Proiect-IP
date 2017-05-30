package com.fiivirtualcatalog.modules.user.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @Test
    public void forUserWithId32ShouldReturn32() {
        user.setId(32);
        assertEquals(user.getId(), 32);
    }


    @Test
    public void forUserWithNameMAriaShouldReturnMaria() {
        user.setFirstName("Maria");
        assertEquals(user.getFirstName(), "Maria");
    }

    @Test
    public void forUserWithRoleStudentShouldReturnStudent() {
        user.setRole(User.Role.student);
        assertEquals(user.getRole(), User.Role.student);
    }

}