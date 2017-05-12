package com.fiivirtualcatalog.modules.checkin.dtos;

import com.fiivirtualcatalog.modules.checkin.enums.ClassType;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class CheckInGetDTOTest {
    private CheckInGetDTO checkInGetDTO;

    @Before
    public void setUp() throws Exception {
        checkInGetDTO = new CheckInGetDTO();
    }

    @Test
    public void forANewCheckInDTOShouldBeTheSame() throws ParseException {
        String dDate="2011-11-11 12:16";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = formatter.parse(dDate);
        String createDate = formatter.format(date);
        checkInGetDTO.setId(12);
        checkInGetDTO.setSubject("Subject");
        checkInGetDTO.setClassType(ClassType.Course);
        checkInGetDTO.setCreateDate(date);
        checkInGetDTO.setNumberOfCheckedInUsers(32);
        checkInGetDTO.setFinishingFlag(false);

        assertEquals(checkInGetDTO.getId(),12);
        assertEquals(checkInGetDTO.getSubject(),"Subject");
        assertEquals(checkInGetDTO.getClassType(),ClassType.Course);
        assertEquals(checkInGetDTO.getCreateDate(),createDate);
        assertEquals(checkInGetDTO.getNumberOfCheckedInUsers(),32);
        assertEquals(checkInGetDTO.getFinishingFlag(),false);
    }

    @Test
    public void forCreatingACheckInGetDTOShouldReturnTheSameInformation() throws ParseException {
        String dDate="2011-11-11 12:16";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = formatter.parse(dDate);
        String createDate = formatter.format(date);
        checkInGetDTO.setSubject("Subject");
        checkInGetDTO.setClassType(ClassType.Course);
        checkInGetDTO.setCreateDate(date);
        checkInGetDTO.setNumberOfCheckedInUsers(32);
        checkInGetDTO.setFinishingFlag(false);

        CheckInGetDTO.Builder builder = new CheckInGetDTO.Builder();
        builder.subject("Subject").classType(ClassType.Course).createDate(date).numberOfCheckedInUsers(32).finishingFlag(false);

        CheckInGetDTO newCheckIn = builder.create();

        assertEquals(newCheckIn.getSubject(),"Subject");
        assertEquals(newCheckIn.getClassType(),ClassType.Course);
        assertEquals(newCheckIn.getNumberOfCheckedInUsers(),32);
        assertEquals(newCheckIn.getCreateDate(),createDate);
        assertEquals(newCheckIn.getFinishingFlag(),false);
    }
}