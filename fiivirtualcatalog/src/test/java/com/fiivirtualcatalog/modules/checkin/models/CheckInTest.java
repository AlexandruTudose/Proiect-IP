package com.fiivirtualcatalog.modules.checkin.models;

import com.fiivirtualcatalog.modules.user.models.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckInTest {
    private CheckIn checkIn;

    @Before
    public void setUp() throws Exception {
        checkIn = new CheckIn();
    }

    @Test
    public void forANewCheckInShoudBeTheSame() {
        checkIn.setId(23);

        java.sql.Date currentTimestamp = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        checkIn.setCreateDate(currentTimestamp);

        User user = new User();
        user.setFirstName("Maria");
        user.setRole(User.Role.profesor);
        checkIn.setUser(user);
        checkIn.setSubject("Subject");
        checkIn.setClassType("class-type");
        checkIn.setNumberOfCheckedInUsers(33);
        checkIn.setFinishingFlag(true);

        User user1 = new User();
        user1.setFirstName("Ana");
        user1.setRole(User.Role.student);
        User user2 = new User();
        user2.setFirstName("Andrei");
        user2.setRole(User.Role.student);
        List<User> list = new ArrayList<>();

        checkIn.setCheckedInUsers(list);

        assertEquals(checkIn.getId(), 23);
        assertEquals(checkIn.getCreateDate(), currentTimestamp);
        assertEquals(checkIn.getUser(), user);
        assertEquals(checkIn.getSubject(), "Subject");
        assertEquals(checkIn.getClassType(), "class-type");
        assertEquals(checkIn.getNumberOfCheckedInUsers(), 33);
        assertEquals(checkIn.getFinishingFlag(), true);
        assertEquals(checkIn.getCheckedInUsers(), list);
        assertEquals(checkIn.getClass(), CheckIn.class);

    }

    @Test
    public void forANewUserWhenAddToCheckedInUsersShouldIncreaseTheSizeOfCheckedUsers() {
        User user = new User();
        user.setFirstName("Maria");
        user.setRole(User.Role.student);

        long numBefore = checkIn.getNumberOfCheckedInUsers();

        checkIn.addToCheckedInUsers(user);

        assertEquals(numBefore + 1, checkIn.getNumberOfCheckedInUsers());
    }

    @Test
    public void forCreatingACheckInShouldReturnTheSameInformation() {
        User user = new User();
        user.setFirstName("Maria");
        user.setRole(User.Role.profesor);

        CheckIn.Builder builder = new CheckIn.Builder();
        builder.user(user).subject("Subject").classType("Laboratory");

        CheckIn newCheckIn = builder.create();

        assertEquals(newCheckIn.getUser(), user);
        assertEquals(newCheckIn.getSubject(), "Subject");
        assertEquals(newCheckIn.getClassType(), "Laboratory");
        assertEquals(newCheckIn.getNumberOfCheckedInUsers(), 0);
        assertEquals(newCheckIn.getFinishingFlag(), false);
        assertEquals(newCheckIn.getCheckedInUsers(), Collections.emptyList());
    }

}