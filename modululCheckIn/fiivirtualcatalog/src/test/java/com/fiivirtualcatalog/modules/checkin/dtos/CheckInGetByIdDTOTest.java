package com.fiivirtualcatalog.modules.checkin.dtos;

import com.fiivirtualcatalog.modules.checkin.enums.ClassType;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckInGetByIdDTOTest {

    private CheckInGetByIdDTO checkInGetByIdDTO;

    @Before
    public void setUp() throws Exception {
        checkInGetByIdDTO = new CheckInGetByIdDTO();
    }

    @Test
    public void forANewSimpleUserShouldReturnTheSameSimpleUser() {
        CheckInGetByIdDTO.SimpleUser simpleUser = new CheckInGetByIdDTO.SimpleUser(32, "NAME");
        assertEquals(simpleUser.getId(), 32);
        assertEquals(simpleUser.getUserName(), "NAME");
    }

    @Test
    public void forSettingNewPropertiesToSimpleUserShouldReturnTheSameSimpleUser() {
        CheckInGetByIdDTO.SimpleUser simpleUser = new CheckInGetByIdDTO.SimpleUser(32, "NAME");
        simpleUser.setId(22);
        simpleUser.setUserName("Maria");
        assertEquals(simpleUser.getId(), 22);
        assertEquals(simpleUser.getUserName(), "Maria");
    }

    @Test
    public void forSettinhNewSimpleUsersListShouldReturnTheSameSimpleUsersList() {
        CheckInGetByIdDTO.SimpleUser simpleUser = new CheckInGetByIdDTO.SimpleUser(32, "NAME");
        List<CheckInGetByIdDTO.SimpleUser> simpleUserList = new ArrayList<>();
        simpleUserList.add(simpleUser);
        checkInGetByIdDTO.setSimpleUsers(simpleUserList);
        assertEquals(checkInGetByIdDTO.getSimpleUsers(), simpleUserList);
    }

    @Test
    public void forSettinhNenwSimpleUsersListShouldReturnTheSameSimpleUsersList() throws ParseException {
        CheckInGetByIdDTO.SimpleUser simpleUser = new CheckInGetByIdDTO.SimpleUser(32, "NAME");
        List<CheckInGetByIdDTO.SimpleUser> simpleUserList = new ArrayList<>();
        simpleUserList.add(simpleUser);

        String dDate = "2011-11-11 12:16";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = formatter.parse(dDate);
        String createDate = formatter.format(date);
        CheckInGetByIdDTO.NewBuilder newBuilder = new CheckInGetByIdDTO.NewBuilder();
        CheckInGetByIdDTO newCheckInGetByIdDTO = newBuilder.id(1).subject("Subject").classType(ClassType.Course)
                .numberOfCheckedInUsers(32).finishingFlag(true).createDate(date)
                .createUsers(simpleUserList).create();
        assertEquals(newCheckInGetByIdDTO.getId(), 1);
        assertEquals(newCheckInGetByIdDTO.getSubject(), "Subject");
        assertEquals(newCheckInGetByIdDTO.getClassType(), ClassType.Course);
        assertEquals(newCheckInGetByIdDTO.getNumberOfCheckedInUsers(), 32);
        assertEquals(newCheckInGetByIdDTO.getFinishingFlag(), true);
        assertEquals(newCheckInGetByIdDTO.getCreateDate(), createDate);
        assertEquals(newCheckInGetByIdDTO.getSimpleUsers(), simpleUserList);
    }
}