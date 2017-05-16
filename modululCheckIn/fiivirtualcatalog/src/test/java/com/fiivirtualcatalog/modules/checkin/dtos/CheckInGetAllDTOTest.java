package com.fiivirtualcatalog.modules.checkin.dtos;

import com.fiivirtualcatalog.modules.checkin.enums.ClassType;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CheckInGetAllDTOTest {
    private CheckInGetAllDTO checkInGetAllDTO;

    @Before
    public void setUp() throws Exception {
        checkInGetAllDTO = new CheckInGetAllDTO();
    }

    @Test
    public void forANewCheckInDTOShouldBeTheSame() throws ParseException {
        String dDate = "2011-11-11 12:16";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = formatter.parse(dDate);
        String createDate = formatter.format(date);
        checkInGetAllDTO.setId(12);
        checkInGetAllDTO.setSubject("Subject");
        checkInGetAllDTO.setClassType(ClassType.Course);
        checkInGetAllDTO.setCreateDate(date);
        checkInGetAllDTO.setNumberOfCheckedInUsers(32);
        checkInGetAllDTO.setFinishingFlag(false);

        assertEquals(checkInGetAllDTO.getId(), 12);
        assertEquals(checkInGetAllDTO.getSubject(), "Subject");
        assertEquals(checkInGetAllDTO.getClassType(), ClassType.Course);
        assertEquals(checkInGetAllDTO.getCreateDate(), createDate);
        assertEquals(checkInGetAllDTO.getNumberOfCheckedInUsers(), 32);
        assertEquals(checkInGetAllDTO.getFinishingFlag(), false);
    }

    @Test
    public void forCreatingACheckInGetDTOShouldReturnTheSameInformation() throws ParseException {
        String dDate = "2011-11-11 12:16";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = formatter.parse(dDate);
        String createDate = formatter.format(date);
        checkInGetAllDTO.setSubject("Subject");
        checkInGetAllDTO.setClassType(ClassType.Course);
        checkInGetAllDTO.setCreateDate(date);
        checkInGetAllDTO.setNumberOfCheckedInUsers(32);
        checkInGetAllDTO.setFinishingFlag(false);

        CheckInGetAllDTO.Builder builder = new CheckInGetAllDTO.Builder();
        builder.id(3).subject("Subject").classType(ClassType.Course).createDate(date).numberOfCheckedInUsers(32).finishingFlag(false);

        CheckInGetAllDTO newCheckIn = builder.create();

        assertEquals(newCheckIn.getId(),3);
        assertEquals(newCheckIn.getSubject(), "Subject");
        assertEquals(newCheckIn.getClassType(), ClassType.Course);
        assertEquals(newCheckIn.getNumberOfCheckedInUsers(), 32);
        assertEquals(newCheckIn.getCreateDate(), createDate);
        assertEquals(newCheckIn.getFinishingFlag(), false);
    }
}