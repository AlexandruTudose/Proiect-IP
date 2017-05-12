package com.fiivirtualcatalog.modules.checkin.dtos;

import com.fiivirtualcatalog.modules.checkin.enums.ClassType;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class CheckInPostDTOTest {
    private CheckInPostDTO checkInPostDTO;

    @Before
    public void setUp() throws Exception {
        checkInPostDTO = new CheckInPostDTO();
    }

    @Test
    public void forANewCheckInDTOShouldBeTheSame() throws ParseException {

        checkInPostDTO.setUserId(1);
        checkInPostDTO.setSubject("Subject");
        checkInPostDTO.setClassType(ClassType.Course);

        assertEquals(checkInPostDTO.getUserId(),1);
        assertEquals(checkInPostDTO.getSubject(),"Subject");
        assertEquals(checkInPostDTO.getClassType(),ClassType.Course);
    }

    @Test
    public void forCreatingACheckInPostDTOShouldReturnTheSameInformation() throws ParseException {
        checkInPostDTO.setUserId(1);
        checkInPostDTO.setSubject("Subject");
        checkInPostDTO.setClassType(ClassType.Course);

        CheckInPostDTO.Builder builder = new CheckInPostDTO.Builder();
        builder.user(1).subject("Subject").classType(ClassType.Course);

        CheckInPostDTO newCheckIn = builder.create();

        assertEquals(newCheckIn.getUserId(),1);
        assertEquals(newCheckIn.getSubject(),"Subject");
        assertEquals(newCheckIn.getClassType(),ClassType.Course);
    }

}